package com.bankProject.dao;

import com.bankProject.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUserByAccountNumber(String accountNumber);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(String accountNumber);
}

