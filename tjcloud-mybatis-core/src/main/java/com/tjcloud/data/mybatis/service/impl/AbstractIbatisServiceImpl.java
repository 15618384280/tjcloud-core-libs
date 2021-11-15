//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.mybatis.service.impl;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.exception.ServiceException;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.data.mybatis.dao.AbstractIBatisDao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractIbatisServiceImpl<D extends AbstractIBatisDao<T, ID>, T extends AbstractEntity, ID extends Serializable> implements AbstractService<T, ID> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private D dao;

    public AbstractIbatisServiceImpl() {
    }

    protected D getDao() {
        return this.dao;
    }

    public T save(T entity) throws ServiceException {
        return this.getDao().save(entity);
    }

    public T create(T entity) throws ServiceException {
        return this.getDao().insert(entity);
    }

    public List<T> create(Iterable<T> entities) throws ServiceException {
        return this.getDao().insert(entities);
    }

    public int modify(T entity) throws ServiceException {
        return this.getDao().update(entity);
    }

    public int modify(Iterable<T> entities) throws ServiceException {
        return this.getDao().update(entities);
    }

    public int remove(ID id) throws ServiceException {
        return this.getDao().delete(id);
    }

    public int remove(T entity) throws ServiceException {
        return this.getDao().delete(entity);
    }

    public T get(ID id) throws ServiceException {
        return this.getDao().get(id);
    }

    public boolean exists(ID id) throws ServiceException {
        return this.getDao().exists(id);
    }

    public T findOne(Map<String, Object> params) throws ServiceException {
        return params != null && !params.isEmpty() ? this.getDao().findOne(params) : null;
    }

    public List<T> findBy(Map<String, Object> params) throws ServiceException {
        return this.getDao().findBy(params);
    }

    public Pagination<T> queryPage(PageParam page, Map<String, Object> params) throws ServiceException {
        return this.getDao().queryPage(page, params);
    }
}
