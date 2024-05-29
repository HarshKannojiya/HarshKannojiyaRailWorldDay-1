package com.bankProject.dao;

import com.bankProject.model.Admin;
import com.bankProject.model.User;
import com.bankProject.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean isAdmin(Admin admin) {
        String query = "SELECT admin_name,admin_password FROM admin_table";
        List<User> adm = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                if(admin.getAName().equals(rs.getString("admin_name")) && admin.getAPass().equals(rs.getString("admin_password"))){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
