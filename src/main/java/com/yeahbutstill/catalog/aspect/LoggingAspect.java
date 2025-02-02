package com.yeahbutstill.catalog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.yeahbutstill.catalog.web.*.*(..))")
    private void restAPI() {
    }

    @Pointcut("within(com.yeahbutstill.catalog.web.*)")
    private void withinPointcutExample() {
    }

    @Pointcut("args(com.yeahbutstill.catalog.domain.dto.PublisherCreateRequestDTO)")
    private void argsPointcutExample() {
    }

    @Pointcut("@args(com.yeahbutstill.catalog.annotation.LogThisArg)")
    private void argsAnnotationPointcutExample() {
    }

    @Pointcut("@annotation(com.yeahbutstill.catalog.annotation.LogThisMethod)")
    private void annotationPointcutExample() {
    }

    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect before method executed");
    }

    @After("annotationPointcutExample()")
    public void afterExecutedLogging() {
        log.info("this is log from aspect after method executed");
    }


    @AfterReturning("annotationPointcutExample()")
    public void afterReturnExecutedLogging() {
        log.info("this is log from aspect after returning method executed");
    }


    @AfterThrowing("annotationPointcutExample()")
    public void afterThrowingExecutedLogging() {
        log.info("this is log from aspect after throwing method executed");
    }

    @Around("restAPI()")
    public Object processingTimeLogging(ProceedingJoinPoint jointPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();


        try {
            log.info("********** start {}.{} **********", jointPoint.getTarget().getClass().getName(), jointPoint.getSignature().getName());
            stopWatch.start();
            return jointPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("********** finish {}.{}  execution time = {} **********", jointPoint.getTarget().getClass().getName(),
                    jointPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());
        }


    }

}
