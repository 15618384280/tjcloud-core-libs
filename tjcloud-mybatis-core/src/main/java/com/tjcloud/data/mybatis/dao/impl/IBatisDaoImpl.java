package com.tjcloud.data.mybatis.dao.impl;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.data.mybatis.dao.IBatisDao;
import java.io.Serializable;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class IBatisDaoImpl<T extends AbstractEntity, ID extends Serializable> extends SqlSessionDaoSupport implements IBatisDao<T, ID> {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

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
}
