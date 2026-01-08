package com.bdomanager.infrastructure.utils.exceptions.items;

public class ItemAlreadyExists extends RuntimeException {
    public ItemAlreadyExists(){ super("O item já existe!"); }
    public ItemAlreadyExists(String message){ super(message); }
}
