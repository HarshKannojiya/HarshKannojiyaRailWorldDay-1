package com.bankProject.model;

public class BankUser {
    private String name;
    private String email;

    public void setName(String name){
         this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
}
