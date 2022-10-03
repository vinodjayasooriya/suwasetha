package lk.ijse.suwasetha.dao.custom.impl;

import lk.ijse.suwasetha.dao.CrudUtil;
import lk.ijse.suwasetha.dao.custom.DoctorDAO;
import lk.ijse.suwasetha.db.DatabaseConnection;
import lk.ijse.suwasetha.entity.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public boolean save(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO doctor VALUES(?,?,?,?,?,?)",
                doctor.getId(),
                doctor.getName(),
                doctor.getAddress(),
                doctor.getContact(),
                doctor.getEmail(),
                doctor.getImage()
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM doctor WHERE d_id=?",s);
    }

    @Override
    public boolean update(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE doctor " +
                "SET name=?," +
                "address=?," +
                "contact=?," +
                "email=?," +
                "image=? " +
                "WHERE d_id=?",
                doctor.getName(),
                doctor.getAddress(),
                doctor.getContact(),
                doctor.getEmail(),
                doctor.getImage(),
                doctor.getId()
                );
    }

    @Override
    public Doctor get(String s) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM doctor WHERE d_id=?");
        stm.setObject(1, s);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
           return  new Doctor(
                   set.getString(1),
                   set.getString(2),
                   set.getString(3),
                   set.getString(4),
                   set.getString(5),
                   set.getString(6)
           );
        }
        return null;
    }

    @Override
    public List<Doctor> getAll() throws SQLException, ClassNotFoundException {

        List<Doctor> list= new ArrayList<>();
        ResultSet set=CrudUtil.execute("SELECT * FROM doctor");
        while(set.next()){
            list.add(
                    new Doctor(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            set.getString(6)
                    )
            );
        }
        return list;
    }
}
