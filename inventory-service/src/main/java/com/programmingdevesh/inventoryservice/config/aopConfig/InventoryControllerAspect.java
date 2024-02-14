package com.programmingdevesh.inventoryservice.config.aopConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class InventoryControllerAspect {

    @Before(value = "execution(* com.programmingdevesh.inventoryservice.controller.InventoryController.checkIfItemsExistInInventory(..))")
    public void beforeAdviceForInventoryController(JoinPoint joinPoint) {
        System.out.println("Request to InventoryController " + joinPoint.getSignature() + "started at " + new Date());
    }

    @After(value = "execution(* com.programmingdevesh.inventoryservice.controller.InventoryController.checkIfItemsExistInInventory(..))")
    public void afterAdviceForInventoryController(JoinPoint joinPoint) {
        System.out.println("Request to InventoryController " + joinPoint.getSignature() + "ended at " + new Date());
    }

}
