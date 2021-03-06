package ru.kpfu.itis.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import ru.kpfu.itis.annotation.RetryIfException;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ServiceAspect {

    public void before() {
        System.out.println("РАБОТАЕТ!!!");
    }

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start invoking "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End invoking method: " + (end - start) + "ms");
        return result;
    }

    public Object retry(ProceedingJoinPoint joinPoint) throws Throwable {
        Class clazz = joinPoint.getTarget().getClass();
        Method method = clazz.getMethod(joinPoint.getSignature().getName());
        RetryIfException retryIfException = method.getAnnotation(RetryIfException.class);
        int count = retryIfException.value();
        System.out.println("OK BOSS " + count);

        return joinPoint.proceed();
    }

}
