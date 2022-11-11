package com.example.scheduler.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Around("execution(* com.example.scheduler.controller..*(..))")
    public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String classname = methodSignature.getDeclaringType().getSimpleName();
        String methodname = methodSignature.getName();
        String[] parameterNames = methodSignature.getParameterNames();
        log.info("-------- Executing " + classname + "." + methodname + Arrays.toString(parameterNames) + " -----------------");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("-------- Method " + classname + "." + methodname + Arrays.toString(parameterNames)
                + " was executed in " + stopWatch.getTotalTimeMillis() + "ms -----------------");
        return result;
    }
}
