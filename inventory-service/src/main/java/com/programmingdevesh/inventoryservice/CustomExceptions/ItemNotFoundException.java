package com.programmingdevesh.inventoryservice.CustomExceptions;

import lombok.Data;

public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
