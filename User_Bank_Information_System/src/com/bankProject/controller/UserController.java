package com.bankProject.controller;

import com.bankProject.model.*;
import com.bankProject.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserService userService;
    private Scanner scanner;

    public UserController() {
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws SQLException {

        while (true) {
            System.out.println("Enter 1 for login as ADMIN");
            System.out.println("Enter 2 for login as BANK_USER");
            System.out.print("Enter Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            if(ch==1){
                System.out.println("Enter ADMIN Name: ");
                String aName = scanner.nextLine();
                System.out.println("Enter ADMIN Password: ");
                String aPass = scanner.nextLine();
                Admin admin = new Admin();
                admin.setAName(aName);
                admin.setAPass(aPass);

               boolean isAdm = userService.isAdmin(admin);
                System.out.println(isAdm);
                if(isAdm==true){
                    while (true){
                        System.out.println("1. Add User to bank and create Bank Account");
                        System.out.println("2. Get User");
                        System.out.println("3. Get All Users");
                        System.out.println("4. Update User");
                        System.out.println("5. Delete User");
                        System.out.println("6. Create Bank IFSC Code");
                        System.out.println("7. Get Bank Account Details");
                        System.out.println("8. Get All Bank Accounts");
                        System.out.println("9. Update Bank Account");
                        System.out.println("10. Delete Bank Account");
                        System.out.println("11. Add Money To Your Account");
                        System.out.println("12. Withdraw Money From Your Account");
                        System.out.println("13. Get Transactions by Account ID");
                        System.out.println("14. Get All Transactions");
                        System.out.println("15. Exit");
                        System.out.print("Enter choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (choice) {
                            case 1:
                                addUser();
                                break;
                            case 2:
                                getUser();
                                break;
                            case 3:
                                getAllUsers();
                                break;
                            case 4:
                                updateUser();
                                break;
                            case 5:
                                deleteUser();
                                break;
                            case 6:
                                addBankAccount();
                                break;
                            case 7:
                                getBankAccount();
                                break;
                            case 8:
                                getAllBankAccounts();
                                break;
                            case 9:
                                updateBankAccount();
                                break;
                            case 10:
                                deleteBankAccount();
                                break;
                            case 11:
                                addTransaction();
                                break;
                            case 12:
                                removeTransaction();
                                break;
                            case 13:
                                getTransactionsByAccountId();
                                break;
                            case 14:
                                getAllTransactions();
                                break;
                            case 15:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }


                }


            }
            else if(ch==2) {
                System.out.println("You can only add yourself in a bank And Create a Bank Account: ");
                addUser();
            }
        }
    }


    private void addUser() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Minimum Balance of 500 to open a Account: ");
        String balance = scanner.nextLine();
        while(Integer.parseInt(balance)<500){
            System.out.println("Enter minimum amount of 500");
            System.out.println("Re-enter your details...");
            addUser();
        }

        BankUser bu = new BankUser();
        User u = new User();
        u.setBalance(Double.parseDouble(balance));
        bu.setName(name);
        bu.setEmail(email);

        userService.addBankUser(bu,u);
        System.out.println("User Added Successfully");

//        scanner.nextLine(); // Consume newline


    }

    private void getUser() {
        System.out.print("Enter Email: ");
        String accountNumber = scanner.nextLine();
        User user = userService.getUserByAccountNumber(accountNumber);
        if (user != null) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Account Number: " + user.getAccountNumber());
            System.out.println("Balance: " + user.getBalance());
        } else {
            System.out.println("User not found.");
        }
    }

    private void getAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("User ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Account Number: " + user.getAccountNumber());
            System.out.println("Balance: " + user.getBalance());
            System.out.println("-------------------");
        }
    }

    private void updateUser() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = userService.getUserByAccountNumber(accountNumber);
        if (user != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            user.setName(name);
            user.setBalance(balance);

            userService.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        userService.deleteUser(accountNumber);
        System.out.println("User deleted successfully.");
    }

    private void addBankAccount() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter Bank Name: ");
        String ifscCode = scanner.nextLine();

        BankAccount bankAccount = new BankAccount();
        bankAccount.setUserId(userId);
        bankAccount.setBranchName(branchName);
        bankAccount.setIfscCode(ifscCode);

        userService.addBankAccount(bankAccount);
        System.out.println("Bank account added successfully.");
    }

    private void getBankAccount() {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount bankAccount = userService.getBankAccountByUserId(userId);
        if (bankAccount != null) {
            System.out.println("Account ID: " + bankAccount.getAccountId());
            System.out.println("Branch Name: " + bankAccount.getBranchName());
            System.out.println("IFSC Code: " + bankAccount.getIfscCode());
        } else {
            System.out.println("Bank account not found.");
        }
    }

    private void getAllBankAccounts() {
        List<BankAccount> bankAccounts = userService.getAllBankAccounts();
        for (BankAccount bankAccount : bankAccounts) {
            System.out.println("Account ID: " + bankAccount.getAccountId());
            System.out.println("User ID: " + bankAccount.getUserId());
            System.out.println("Branch Name: " + bankAccount.getBranchName());
            System.out.println("IFSC Code: " + bankAccount.getIfscCode());
            System.out.println("-------------------");
        }
    }

    private void updateBankAccount() {
        System.out.print("Enter user ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        BankAccount bankAccount = userService.getBankAccountByUserId(accountId);
        if (bankAccount != null) {
            System.out.print("Enter new branch name: ");
            String branchName = scanner.nextLine();
            System.out.print("Enter new IFSC code: ");
            String ifscCode = scanner.nextLine();

            bankAccount.setBranchName(branchName);
            bankAccount.setIfscCode(ifscCode);

            userService.updateBankAccount(bankAccount);
            System.out.println("Bank account updated successfully.");
        } else {
            System.out.println("Bank account not found.");
        }
    }

    private void deleteBankAccount() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        userService.deleteBankAccount(accountId);
        System.out.println("Bank account deleted successfully.");
    }

    private void addTransaction() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();

        System.out.print("Enter transaction amount: ");
        double transactionAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter EmailId: ");
        String email = scanner.nextLine();
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setTransactionAmount(transactionAmount);

        userService.addTransaction(transaction,email);
        System.out.println("Money Deposited successfully.");
    }

    private void removeTransaction() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();

        System.out.print("Enter transaction amount: ");
        double transactionAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter EmailId: ");
        String email = scanner.nextLine();
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setTransactionAmount(transactionAmount);

        userService.removeTransaction(transaction,email);
        System.out.println("Money Withdrawed successfully.");
    }


    private void getTransactionsByAccountId() {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Transaction> transactions = userService.getTransactionsByAccountId(accountId);
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Account ID: " + transaction.getAccountId());
            System.out.println("Transaction Amount: " + transaction.getTransactionAmount());
            System.out.println("Transaction Date: " + transaction.getTransactionDate());
            System.out.println("-------------------");
        }
    }

    private void getAllTransactions() {
        List<Transaction> transactions = userService.getAllTransactions();
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Account ID: " + transaction.getAccountId());
            System.out.println("Transaction Amount: " + transaction.getTransactionAmount());
            System.out.println("Transaction Date: " + transaction.getTransactionDate());
            System.out.println("-------------------");
        }
    }
}
