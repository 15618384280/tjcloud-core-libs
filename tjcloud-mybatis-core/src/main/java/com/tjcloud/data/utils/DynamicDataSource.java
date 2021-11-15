//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    private DBContextHolder dbContextHolder;

    public DynamicDataSource() {
    }

    protected Object determineCurrentLookupKey() {
        return this.dbContextHolder.getDBSource();
    }
}
