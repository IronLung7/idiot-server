//package com.v.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * Created by zhlingyu on 2016/7/29.
// */
//@Aspect
//@Component
//public class LoggerAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
//
//    @Around("execution(* com.v..*(..))")
//    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("lol");
//        if (joinPoint == null) {
//            logger.error("Cannot traceMethod for NULL");
//            return null;
//        }
//        logger.info("in method");
//        Object retVal = null;
//        try {
//            retVal = joinPoint.proceed();
//        } catch (Throwable t) {
//
//        } finally {
//            logger.info("end method");
//        }
//        return retVal;
//    }
//}