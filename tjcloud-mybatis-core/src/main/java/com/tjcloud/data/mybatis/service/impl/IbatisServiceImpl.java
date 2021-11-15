//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.mybatis.service.impl;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.data.mybatis.dao.IBatisDao;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class IbatisServiceImpl<D extends IBatisDao<T, ID>, T extends AbstractEntity, ID extends Serializable> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private D dao;

    public IbatisServiceImpl() {
    }

    protected D getDao() {
        return this.dao;
    }
}
