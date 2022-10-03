package lk.ijse.suwasetha.dao.custom.impl;


import lk.ijse.suwasetha.entity.Doctor;

import java.sql.SQLException;

class DoctorDAOImplTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new DoctorDAOImplTest().save();
    }

    void save() throws SQLException, ClassNotFoundException {
        boolean isSaved=new DoctorDAOImpl().save(
                new Doctor(
                        "D004",
                        "Nimal",
                        "Colombo",
                        "contact",
                        "email",
                        "no image"
                )
        );

        System.out.println(isSaved);
    }
}