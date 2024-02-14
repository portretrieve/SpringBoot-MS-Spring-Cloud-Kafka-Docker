package com.programmingdevesh.productservice.config.aopConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ControllerAspect {

    @Before(value = "execution(* com.programmingdevesh.productservice.controller.ProductController.getListOfAllProducts(..))")
    public void beforeAdviceForProductController(JoinPoint joinPoint) {
        System.out.println("Request to ProductController " + joinPoint.getSignature() + "started at " + new Date());
    }

    @After(value = "execution(* com.programmingdevesh.productservice.controller.ProductController.getListOfAllProducts(..))")
    public void afterAdviceForProductController(JoinPoint joinPoint) {
        System.out.println("Request to ProductController " + joinPoint.getSignature() + "ended at " + new Date());
    }

}
