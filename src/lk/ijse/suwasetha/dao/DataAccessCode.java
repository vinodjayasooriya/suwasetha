package lk.ijse.suwasetha.dao;

import lk.ijse.suwasetha.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessCode {

    public static ResultSet getAllDoctor() throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM doctor";
        PreparedStatement stm = con.prepareStatement(sql);
        return stm.executeQuery();
    }

    public static boolean saveDoctor(String id,String name,String address, String contact, String email, String img) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO doctor VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1, id);
        stm.setObject(2, name);
        stm.setObject(3, address);
        stm.setObject(4, contact);
        stm.setObject(5, email);
        stm.setObject(6, img);
        return stm.executeUpdate()>0;
    }

    public static boolean updateDoctor(String id,String name,String address, String contact, String email, String img) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.
                getInstance().getConnection();

        String sql = "UPDATE doctor " +
                "SET name=?," +
                "address=?," +
                "contact=?," +
                "email=?," +
                "image=? " +
                "WHERE d_id=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1, name);
        stm.setObject(2, address);
        stm.setObject(3, contact);
        stm.setObject(4,email);
        stm.setObject(5, img);
        stm.setObject(6, id);
        return stm.executeUpdate() > 0;

    }

}
