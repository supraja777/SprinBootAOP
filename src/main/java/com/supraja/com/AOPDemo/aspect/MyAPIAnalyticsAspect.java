package com.supraja.com.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAPIAnalyticsAspect {

    @Before("com.supraja.com.AOPDemo.aspect.AOPExpressions.forDAOPackageAndNoGettersAndSetters()")
    public void beforeApiAnalytics() {
        System.out.println( "------------------Executing @Before for ApiAnalytics()");
    }
}
