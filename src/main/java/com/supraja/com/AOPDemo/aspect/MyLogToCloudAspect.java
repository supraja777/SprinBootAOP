package com.supraja.com.AOPDemo.aspect;

import com.supraja.com.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@Order(2)
public class MyLogToCloudAspect {

    @Before("com.supraja.com.AOPDemo.aspect.AOPExpressions.forDAOPackageAndNoGettersAndSetters()")
    public void logToCloud(JoinPoint theJoinPoint) {
        System.out.println( "------------------Executing @Before for logToCloud()");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("MethodSignature " + methodSignature);

        // display arguments

        // get arguments
        Object [] args = theJoinPoint.getArgs();

        // display arguments
        System.out.println("Logging arguments");
        for (Object arg : args) {
            if (arg instanceof Account) {
                // downcasting

                Account theAccount = (Account) arg;
                System.out.println("Printing the actual account " + theAccount.getName() + theAccount.getLevel());
            }
            else
            System.out.println(arg);
        }

    }
}
