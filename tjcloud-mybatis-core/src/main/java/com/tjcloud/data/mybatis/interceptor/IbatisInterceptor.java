//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.mybatis.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.data.redis.service.RedisCache;
import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
)})
public class IbatisInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(IbatisInterceptor.class);
    @Autowired
    private RedisCache redisCache;
    private Properties properties;

    public IbatisInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        if (methodName.equals("update")) {
            Object parameter = invocation.getArgs()[1];
            if (parameter != null && parameter instanceof AbstractEntity) {
                AbstractEntity entity = (AbstractEntity)parameter;
                logger.info("^_^ mybatis interceptor parameter entity is {}, [{}]", methodName, parameter.getClass().getName());
                String authid = "184c58cb65ee11e68fe10242ac11000a";
                String username = "alien";
                String tokenId = entity.getTokenId();
                if (StringUtils.isNotEmpty(tokenId) && !"00000000".equals(tokenId)) {
                    JSONObject userObj = JSON.parseObject(this.redisCache.get(tokenId));
                    if (userObj != null) {
                        authid = userObj.getString("id");
                        username = userObj.getString("username");
                    }
                }

                long time = System.currentTimeMillis();
                entity.setCreatorId(authid);
                entity.setCreatedBy(username);
                entity.setCreatedTime(time);
                entity.setLastAccess(time);
                entity.setUpdaterId(authid);
                entity.setUpdatedBy(username);
                entity.setLastAccess(time);
            }
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
