//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.utils;

import org.springframework.stereotype.Component;

@Component
public class DBContextHolder {
    private ThreadLocal<String> contextHolder = new ThreadLocal();

    public DBContextHolder() {
    }

    public String getDBSource() {
        String db = (String)this.contextHolder.get();
        if (db == null) {
            db = "db_master";
        }

        return db;
    }

    public void setDBSource(String dbSource) {
        this.contextHolder.set(dbSource);
    }

    public void clearDBSource() {
        this.contextHolder.remove();
    }
}
