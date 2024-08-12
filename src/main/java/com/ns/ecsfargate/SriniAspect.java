package com.ns.ecsfargate;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SriniAspect {

    Logger logger = LoggerFactory.getLogger(SriniAspect.class);

    /*
    For Around if you have single package you are targeting then use below
    @Around("within(com.ns.ecsfargate.*)")
    private String hControllerPointcut(ProceedingJoinPoint pjp) {
        String logMsg= pjp.getSignature().toShortString().concat("---> Srini Aspect around logger");
        logger.info(logMsg);
        return logMsg;
    }

    For Around if you have classes from different packages you are targeting then use below

    @Pointcut("within(com.ns.ecsfargate.HelloController)")
    private void helloControllerPointcut(){
    }

    @Pointcut("within(com.ns.ecsfargate.HomeController)")
    private void homeControllerPointcut(){
    }

    @Around("helloControllerPointcut() || homeControllerPointcut()" )
    public String messageLogger(ProceedingJoinPoint pjp) {
        String logMsg= pjp.getSignature().toShortString().concat("---> Srini Aspect around logger");
        logger.info(logMsg);
        return logMsg;
    }
     */

    @Before("execution(* com.ns.ecsfargate.*.*(..))")
    public String messageLoggerBefore(JoinPoint jp) {
        String logMsg= "Before executing:---> "+ jp.getSignature().toShortString();
        logger.info(logMsg);
        return logMsg;
    }

    @After("execution(* com.ns.ecsfargate.*.*(..))")
    public String messageLoggerAfter(JoinPoint jp) {
        String logMsg= "After executing:---> "+ jp.getSignature().toShortString();
        logger.info(logMsg);
        return logMsg;
    }
}
