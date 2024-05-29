package com.bankProject.dao;

import com.bankProject.model.BankUser;
import com.bankProject.model.User;
import com.bankProject.util.DBUtil;

import java.sql.*;

public class BankUserDAOImpl implements BankUserDAO {
    @Override
    public void addBankUser(BankUser bu, User u) throws SQLException {
        String query = "INSERT INTO bank_user (bank_user_name,bank_user_email) VALUES (?,?)";
        String query1 = "INSERT into users (name,balance,email,accountNumber) VALUES (?,?,?,?)";
        String query3 = "SELECT accountNumber FROM bank_user WHERE bank_user_email='"+bu.getEmail()+"'";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(query);
             PreparedStatement pstmt1 = conn.prepareStatement(query1)) {
            pstmt.setString(1, bu.getName());
            pstmt.setString(2, bu.getEmail());
            pstmt.executeUpdate();
            System.out.println(query3);
            System.out.println(bu.getEmail());
            ResultSet rs = stmt.executeQuery(query3);
            String s = "";
            while (rs.next()){
                 s = rs.getString("accountNumber");
            }

            pstmt1.setString(1, bu.getName());
            pstmt1.setDouble(2, u.getBalance());
            pstmt1.setString(3, bu.getEmail());
            pstmt1.setString(4, s);
            pstmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
