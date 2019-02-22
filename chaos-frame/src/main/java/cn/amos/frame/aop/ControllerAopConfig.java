package cn.amos.frame.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
@Configuration
@Aspect
public class ControllerAopConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAopConfig.class);

    /**
     * 当前包下类: @Pointcut("within(cn.amos.design.*)")
     * 当前包及子包下类: @Pointcut("within(cn.amos.design..*)")
     * 指定类, 注意其对接口无效: @Pointcut("within(cn.amos.design.creation.OperationAdd)")
     * 指定接口可如右: @Pointcut("execution(* cn.amos.design.creation.Operation.*(..))")
     */
    @Pointcut("within(cn.amos.web.controller.*)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void executionPoint(JoinPoint joinPoint) {
        LOGGER.info("方法【" + joinPoint.getSignature().getName() + "】开始执行...");
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("====== Http请求开始 ======");

        // 方法名 || 参数 || 返回值
        Object[] args = proceedingJoinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(obj.toString());
            sb.append("\t");
        }
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("--- 参数: " + sb.toString());
        LOGGER.info("--- 返回值: " + result);

        return result;
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        LOGGER.info("====== Http请求结束 ======\n");
    }

}
