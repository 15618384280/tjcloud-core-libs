//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.mybatis.dao;

import com.tjcloud.core.entity.AbstractEntity;
import java.io.Serializable;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public interface IBatisDao<T extends AbstractEntity, ID extends Serializable> {
    SqlSessionTemplate getSessionTemplate();

    SqlSession getBaseSqlSession();
}