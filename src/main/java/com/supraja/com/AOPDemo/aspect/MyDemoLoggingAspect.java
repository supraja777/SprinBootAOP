package com.supraja.com.AOPDemo.aspect;

import com.supraja.com.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    // New method for AfterThrowing
    @AfterThrowing(pointcut = "execution(* com.supraja.com.AOPDemo.dao.AccountDAO.find*(..))",
    throwing = "theExc"
    )
    public void afterThrowingForFindAccounts(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("Method name for AfterThrowing " + method);

        System.out.println("Logging the exception in AfterThrowing " + theExc);

    }

    // Add a new method for afterReturningAspect
    @AfterReturning(
            pointcut = "execution(* com.supraja.com.AOPDemo.dao.AccountDAO.find*())",
            returning = "result"
    )
    public void afterReturningFindAccounts(JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("Method name for AfterReturning " + method);

        System.out.println("After returning ");
        System.out.println("In afterReturning aspect, before modifying logging result " + result);

        // Modifying the result

        if (!result.isEmpty()) {
            Account tempAccount = result.get(0);
            tempAccount.setName("Daffy Duck");
        }

        System.out.println("In afterReturning aspect, before modifying logging result " + result);
    }

    @Before("com.supraja.com.AOPDemo.aspect.AOPExpressions.forDAOPackageAndNoGettersAndSetters()")
    public void beforeAddAccount() {
        System.out.println( "------------------Executing @Before for addAccount()");
    }
}
