//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.tjcloud.data.aspect;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.data.redis.service.RedisCache;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MPowerAspect {
    private static final Logger logger = LoggerFactory.getLogger(MPowerAspect.class);
    @Autowired
    private RedisCache redisCache;

    public MPowerAspect() {
    }

    @Pointcut("@annotation(com.tjcloud.core.annotation.PowerRequired)")
    public void powerAspect() {
    }

    @Before("powerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("############ join point power required. {}", joinPoint.getTarget().getClass().getName());
        Object[] var2 = joinPoint.getArgs();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object parameter = var2[var4];
            if (parameter != null && parameter instanceof Map) {
                Map<String, Object> map = (Map)parameter;
                String token = StringUtils.msNull((String)map.get("tokenId"));
                logger.info("^_^ join point token is, {}", token);
                if (StringUtils.isNotEmpty(token)) {
                    String platformAdmin = this.redisCache.get("platform_admin" + token);
                    if (StringUtils.isNotEmpty(platformAdmin)) {
                        logger.info("^_^ current user is platform admin, {}", platformAdmin);
                        map.put("isPlatformAdmin", "1");
                    }

                    String tenantAdmin = this.redisCache.get("tenant_admin" + token);
                    String stadiumIds;
                    if (StringUtils.isNotEmpty(tenantAdmin)) {
                        logger.info("^_^ current user is tenant admin, {}", tenantAdmin);
                        map.put("isTenantAdmin", "1");
                        stadiumIds = this.redisCache.get("tenant_id" + token);
                        map.put("tenantId", stadiumIds);
                    }

                    stadiumIds = this.redisCache.get("stadium_ids" + token);
                    if (StringUtils.isNotEmpty(stadiumIds)) {
                        map.put("stadiumIds", JSON.parseArray(stadiumIds));
                    }

                    String stadiumItemIds = this.redisCache.get("stadium_item_ids" + token);
                    if (StringUtils.isNotEmpty(stadiumItemIds)) {
                        map.put("stadiumItemIds", JSON.parseArray(stadiumItemIds));
                    }
                } else {
                    logger.info("o_o join point power required, but token is empty. parameters {}", "~");
                }
            }
        }

        logger.info("^_^ after add new parameters {}", JSON.toJSONString(joinPoint.getArgs()));
    }
}
