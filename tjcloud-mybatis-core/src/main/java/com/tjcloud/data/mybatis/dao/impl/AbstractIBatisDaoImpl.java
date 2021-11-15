package com.tjcloud.data.mybatis.dao.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.exception.DAOException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class AbstractIBatisDaoImpl<T extends AbstractEntity, ID extends Serializable> extends SqlSessionDaoSupport implements AbstractIBatisDao<T, ID> {
    public static final String SQL_INSERT = "insert";

    public static final String SQL_BATCH_INSERT = "batchInsert";

    public static final String SQL_UPDATE = "update";

    public static final String SQL_BATCH_UPDATE = "batchUpdate";

    public static final String SQL_GET_BY_ID = "getById";

    public static final String SQL_DELETE_BY_ID = "deleteById";

    public static final String SQL_LIST_PAGE = "listPage";

    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";

    public static final String SQL_LIST_BY = "listBy";

    public static final String SQL_LOG_SUFFIX = "_log";

    public static final String SQL_LOCK = "lock";

    public static final String SQL_UNLOCK = "unlock";

    public static final String SQL_BATCH_LOCK = "batchLock";

    public static final String SQL_BATCH_UNLOCK = "batchUnlock";

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public T save(T entity) throws DAOException {
        if (StringUtils.isNotEmpty(entity.getId())) {
            T obj = get((ID)entity.getId());
            if (obj != null) {
                update(entity);
            } else {
                entity = insert(entity);
            }
        } else {
            entity = insert(entity);
        }
        return entity;
    }

    public T insert(T entity) throws DAOException {
        long time = System.currentTimeMillis();
        entity.setCreatedTime(Long.valueOf(time));
        entity.setLastAccess(Long.valueOf(time));
        int result = getSessionTemplate().insert(getStatement("insert"), entity);
        if (result > 0) {
            LogRequired logRequired = entity.getClass().<LogRequired>getAnnotation(LogRequired.class);
            if (logRequired != null) {
                entity.setIsNew(Boolean.valueOf(true));
                entity.setLogTime(Long.valueOf(System.currentTimeMillis()));
                getSessionTemplate().insert(getStatement("insert_log"), entity);
            }
            return entity;
        }
        return null;
    }

    public List<T> insert(Iterable<T> entities) throws DAOException {
        List<T> list = convertIterableToList(entities);
        if (list.isEmpty())
            return list;
        getSessionTemplate().insert(getStatement("batchInsert"), list);
        return list;
    }

    public int update(T entity) throws DAOException {
        LogRequired logRequired = entity.getClass().<LogRequired>getAnnotation(LogRequired.class);
        if (logRequired != null) {
            entity.setIsNew(Boolean.valueOf(false));
            entity.setLogTime(Long.valueOf(System.currentTimeMillis()));
            getSessionTemplate().insert(getStatement("insert_log"), entity);
        }
        entity.setLastAccess(Long.valueOf(System.currentTimeMillis()));
        int result = getSessionTemplate().update(getStatement("update"), entity);
        ValidateUtils.isFalse((result > 1), 0, "effect more than one rows or is zero");
        if (logRequired != null) {
            entity.setIsNew(Boolean.valueOf(true));
            entity.setLogTime(Long.valueOf(System.currentTimeMillis()));
            getSessionTemplate().insert(getStatement("insert_log"), entity);
        }
        return result;
    }

    public int update(Iterable<T> entities) throws DAOException {
        List<T> list = convertIterableToList(entities);
        if (list.isEmpty())
            return 0;
        int result = getSessionTemplate().update(getStatement("batchUpdate"), list);
        ValidateUtils.isFalse((result > 10000), 0, "effect more than 10000 rows.");
        return result;
    }

    public int delete(ID id) throws DAOException {
        Assert.notNull(id, "parameter is null");
        T entity = get(id);
        if (entity != null) {
            LogRequired logRequired = entity.getClass().<LogRequired>getAnnotation(LogRequired.class);
            if (logRequired != null) {
                entity.setIsNew(Boolean.valueOf(false));
                entity.setLogTime(Long.valueOf(System.currentTimeMillis()));
                getSessionTemplate().insert(getStatement("insert_log"), entity);
            }
        }
        int cnt = getSessionTemplate().delete(getStatement("deleteById"), id);
        ValidateUtils.isFalse((cnt > 1), 0, "effect more than one rows or is zero");
        return cnt;
    }

    public int delete(T entity) throws DAOException {
        LogRequired logRequired = entity.getClass().<LogRequired>getAnnotation(LogRequired.class);
        if (logRequired != null) {
            entity.setIsNew(Boolean.valueOf(false));
            entity.setLogTime(Long.valueOf(System.currentTimeMillis()));
            getSessionTemplate().insert(getStatement("insert_log"), entity);
        }
        int cnt = getSessionTemplate().delete(getStatement("deleteById"), entity.getId());
        ValidateUtils.isFalse((cnt > 1), 0, "effect more than one rows or is zero");
        return cnt;
    }

    public T get(ID id) throws DAOException {
        Assert.notNull(id, "parameter is null");
        return (T)getSessionTemplate().selectOne(getStatement("getById"), id);
    }

    public boolean exists(ID id) throws DAOException {
        return (get(id) != null);
    }

    public Pagination<T> queryPage(PageParam page, Map<String, Object> params) throws DAOException {
        return queryPage(page, params, null, null);
    }

    public Pagination<T> queryPage(PageParam page, Map<String, Object> params, String countSQL, String pageSQL) throws DAOException {
        if (params == null)
            params = Maps.newHashMapWithExpectedSize(8);
        if (page != null && page.getPageSize() > 0) {
            if (page.getPageNo() < 0)
                page.setPageNo(1);
            params.put("pageFirst", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            params.put("pageSize", Integer.valueOf(page.getPageSize()));
            params.put("startRowNum", Integer.valueOf((page.getPageNo() - 1) * page.getPageSize()));
            params.put("endRowNum", Integer.valueOf(page.getPageNo() * page.getPageSize()));
            Long count = (Long)getSessionTemplate().selectOne(getStatement(StringUtils.msNull(countSQL, "listPageCount")), params);
            int maxPage = (new BigDecimal(count.longValue())).divide(new BigDecimal(page.getPageSize()), RoundingMode.CEILING).intValue();
            if (maxPage < page.getPageNo())
                page.setPageNo(maxPage);
            List<T> list = getSessionTemplate().selectList(getStatement(StringUtils.msNull(pageSQL, "listPage")), params);
            ValidateUtils.isFalse((list.size() > 10000), 0, "Found more than 10000 rows.");
            return new Pagination(page.getPageNo(), page.getPageSize(), count.intValue(), list);
        }
        return new Pagination(findBy(params));
    }

    public Long findCount(Map<String, Object> params) throws DAOException {
        return findCount(params, null);
    }

    public Long findCount(Map<String, Object> params, String countSQL) throws DAOException {
        return (Long)getSessionTemplate().selectOne(getStatement(StringUtils.msNull(countSQL, "listPageCount")), params);
    }

    public List<T> findBy(Map<String, Object> params) throws DAOException {
        List<T> list = getSessionTemplate().selectList(getStatement("listBy"), params);
        if (list != null && !list.isEmpty())
            ValidateUtils.isFalse((list.size() > 10000), 0, "Found more than 10000 rows.");
        return list;
    }

    public T findOne(Map<String, Object> params) throws DAOException {
        if (params == null || params.isEmpty())
            return null;
        return (T)getSessionTemplate().selectOne(getStatement("listBy"), params);
    }

    public boolean lock(ID id) throws DAOException {
        int success = getSessionTemplate().update(getStatement("lock"), id);
        ValidateUtils.isFalse((success > 1), 0, "effect more than one rows or is zero");
        return (success == 1);
    }

    public boolean unlock(ID id) throws DAOException {
        int success = getSessionTemplate().update(getStatement("unlock"), id);
        ValidateUtils.isFalse((success > 1), 0, "effect more than one rows or is zero");
        return (success == 1);
    }

    public boolean batchLock(List<ID> ids) throws DAOException {
        boolean success = false;
        List<T> list = getSessionTemplate().selectList(getStatement("listBy"), ids);
        if (list != null && !list.isEmpty()) {
            int count = getSessionTemplate().update(getStatement("batchLock"), ids);
            success = (count == list.size());
            if (!success)
                throw new DAOException(Integer.valueOf(10104));
        }
        return success;
    }

    public boolean batchUnlock(List<ID> ids) throws DAOException {
        boolean success = false;
        List<T> list = getSessionTemplate().selectList(getStatement("listBy"), ids);
        if (list != null && !list.isEmpty()) {
            int count = getSessionTemplate().update(getStatement("batchUnlock"), ids);
            success = (count == list.size());
            if (!success)
                throw new DAOException(Integer.valueOf(10105));
        }
        return success;
    }

    public SqlSessionTemplate getSessionTemplate() {
        return this.sessionTemplate;
    }

    public SqlSession getBaseSqlSession() {
        return getSqlSession();
    }

    public String getStatement(String sqlId) {
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getName()).append(".").append(sqlId);
        return sb.toString();
    }

    private static <T> List<T> convertIterableToList(Iterable<T> entities) {
        if (entities instanceof List)
            return (List<T>)entities;
        int capacity = tryDetermineRealSizeOrReturn(entities, 10);
        if (capacity == 0 || entities == null)
            return Collections.emptyList();
        List<T> list = Lists.newArrayListWithCapacity(capacity);
        for (T entity : entities)
            list.add(entity);
        return list;
    }

    private static int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
        return (iterable == null) ? 0 : ((iterable instanceof Collection) ? ((Collection)iterable).size() : defaultSize);
    }
}
