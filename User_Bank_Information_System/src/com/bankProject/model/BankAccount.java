package com.bankProject.model;

public class BankAccount {
    private int accountId;
    private int userId;
    private String branchName;
    private String ifscCode;

    // Constructors, getters, and setters
    public BankAccount() {}

    public BankAccount(int accountId, int userId, String branchName, String ifscCode) {
        this.accountId = accountId;
        this.userId = userId;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}

