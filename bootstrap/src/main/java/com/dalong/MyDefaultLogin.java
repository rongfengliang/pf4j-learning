package com.dalong;

public class MyDefaultLogin implements  UserLogin{
    @Override
    public String token(String name, String password) {
        return String.format("%s-%s-default ",name,password);
    }
}
