package com.programmingdevesh.inventoryservice.CustomExceptions;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
