package com.mokhovav.base_spring_boot_project.injectors;

import com.mokhovav.base_spring_boot_project.annotations.Tracking;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Component
@Aspect
public class TrackingInjector {
    private final Logger logger;

    public TrackingInjector(Logger logger) {
        this.logger = logger;
    }

    @Pointcut("@annotation(com.mokhovav.base_spring_boot_project.annotations.Tracking)")
    public void trackingAnnotationMethods(){
    }

    @Around("trackingAnnotationMethods()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Throwable interceptor = null;
        Object result = null;
        String name = joinPoint.getSignature().getName();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Tracking tracking = method.getDeclaredAnnotation(Tracking.class);
        String log = String.format("START %s", name);
        logger.debug(log);
        LocalDateTime start = LocalDateTime.now();
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable){
            interceptor = throwable;
        }
        LocalDateTime stop = LocalDateTime.now();

        log = String.format("STOP: %s. Start at: %s Duration: %ss %sms Value: %s",
                name, start, stop.getSecond() - start.getSecond(),stop.minusNanos(start.getNano()).getNano()/1000000,tracking.value());
        logger.debug(log);

        if (interceptor != null) throw interceptor;
        return result;
    }
}
