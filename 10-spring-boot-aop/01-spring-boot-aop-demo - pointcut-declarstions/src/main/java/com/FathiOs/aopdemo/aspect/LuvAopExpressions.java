package com.FathiOs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.FathiOs.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.FathiOs.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methode
    @Pointcut("execution(* com.FathiOs.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut : include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
