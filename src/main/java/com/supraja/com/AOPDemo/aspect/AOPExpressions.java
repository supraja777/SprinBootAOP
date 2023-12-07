package com.supraja.com.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
    @Pointcut("execution (* com.supraja.com.AOPDemo.dao.*.*(..))")
    public void forDAOPackage() {};

    //create a pointcut expression for getter
    @Pointcut ("execution (* com.supraja.com.AOPDemo.dao.*.get*(..))")
    public void forGetterMethods() {};
    //create a pointcut expression for setter
    @Pointcut ("execution (* com.supraja.com.AOPDemo.dao.*.set*(..))")
    public void forSetterMethods() {};

    //create pointcut expression to include all the methods except for getters and setters
    @Pointcut (" forDAOPackage() && !(forGetterMethods() || forSetterMethods())")
    public void forDAOPackageAndNoGettersAndSetters() {};
}
