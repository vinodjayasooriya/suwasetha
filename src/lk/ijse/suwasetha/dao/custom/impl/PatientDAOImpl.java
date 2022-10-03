package lk.ijse.suwasetha.dao.custom.impl;

import lk.ijse.suwasetha.dao.CrudUtil;
import lk.ijse.suwasetha.dao.custom.PatientDAO;
import lk.ijse.suwasetha.db.DatabaseConnection;
import lk.ijse.suwasetha.entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean save(Patient patient) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO patient VALUES (?,?,?,?,?,?,?)",
                patient.getNic(),
                patient.getName(),
                patient.getContact(),
                patient.getAddress(),
                patient.getGender(),
                patient.getAge(),
                patient.getEmail()
        );

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM patient", s);
    }

    @Override
    public boolean update(Patient patient) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE patient SET name=?,contact=?,address=?, gender=?,age=?, email=? WHERE nic=?",
                patient.getName(),
                patient.getContact(),
                patient.getAddress(),
                patient.getGender(),
                patient.getAge(),
                patient.getEmail(),
                patient.getNic());
    }

    @Override
    public Patient get(String s) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM patient WHERE nic=?", s);

        if (set.next()) {
            return new Patient(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getInt(6),
                    set.getString(7)
            );
        }
        return null;
    }

    @Override
    public List<Patient> getAll() throws SQLException, ClassNotFoundException {
        List<Patient> list = new ArrayList<>();

        ResultSet set = CrudUtil.execute("SELECT * FROM patient");

        while (set.next()) {
            list.add(
                    new Patient(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            set.getInt(6),
                            set.getString(7)
                    )
            );
        }

        return list;
    }
}
