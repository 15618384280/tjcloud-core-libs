//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.redis.service;

import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public interface RedisCache {
    long expire(String var1, int var2);

    long expireAt(String var1, int var2);

    String trimList(String var1, long var2, long var4);

    long countSet(String var1);

    boolean addSet(String var1, int var2, String[] var3);

    boolean addSet(String var1, String[] var2);

    boolean containsInSet(String var1, String var2);

    Set<String> getSet(String var1);

    boolean removeSetValue(String var1, String[] var2);

    int removeListValue(String var1, List<String> var2);

    int removeListValue(String var1, long var2, List<String> var4);

    boolean removeListValue(String var1, long var2, String var4);

    List<String> rangeList(String var1, long var2, long var4);

    long countList(String var1);

    boolean addList(String var1, int var2, String[] var3);

    boolean addList(String var1, String[] var2);

    boolean addList(String var1, List<String> var2);

    List<String> getList(String var1);

    boolean setHSet(String var1, String var2, String var3);

    String getHSet(String var1, String var2);

    long delHSet(String var1, String var2);

    long delHSet(String var1, String[] var2);

    boolean existsHSet(String var1, String var2);

    List<Entry<String, String>> scanHSet(String var1, String var2);

    List<String> hvals(String var1);

    Set<String> hkeys(String var1);

    long lenHset(String var1);

    boolean setSortedSet(String var1, long var2, String var4);

    Set<String> getSoredSet(String var1, long var2, long var4, boolean var6);

    long countSoredSet(String var1, long var2, long var4);

    boolean delSortedSet(String var1, String var2);

    Set<String> getSoredSetByRange(String var1, int var2, int var3, boolean var4);

    Double getScore(String var1, String var2);

    boolean set(String var1, String var2, int var3);

    boolean set(String var1, String var2, long var3);

    boolean set(String var1, String var2);

    String get(String var1, String var2);

    String get(String var1);

    String msg(int var1);

    boolean del(String var1);

    long incr(String var1);

    long decr(String var1);

    boolean exists(String var1);

    Long lpush(String var1, String... var2);

    Long rpush(String var1, String... var2);

    String lpop(String var1);

    String rpop(String var1);

    List<String> blpop(String var1);

    List<String> brpop(String var1);
}
