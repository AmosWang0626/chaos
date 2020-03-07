package cn.amos.chaos.test.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
//@Aspect
//@Configuration
public class ControllerAopConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAopConfig.class);

    /**
     * 当前包下类: @Pointcut("within(cn.amos.design.*)")
     * 当前包及子包下类: @Pointcut("within(cn.amos.design..*)")
     * 指定类, 注意其对接口无效: @Pointcut("within(cn.amos.design.creation.OperationAdd)")
     * 指定接口可如右: @Pointcut("execution(* cn.amos.design.creation.Operation.*(..))")
     */
    @Pointcut("within(cn.amos.chaos.test.web.controller.*)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("aop-03 >>> method: [" + joinPoint.getSignature().getName() + "] run begin...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("aop-01 >>> ====== http request begin ======");

        // 方法名 || 参数 || 返回值
        String params = Arrays.stream(proceedingJoinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
        LOGGER.info("aop-02 >>> params: " + params);

        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("aop-04 >>> return: " + result.getClass().getSimpleName());

        return result;
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        LOGGER.info("aop-05 >>> ====== http request finish ======\n");
    }

}
