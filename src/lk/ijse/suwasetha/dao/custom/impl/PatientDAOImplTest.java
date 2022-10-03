package lk.ijse.suwasetha.dao.custom.impl;

import lk.ijse.suwasetha.entity.Patient;

import java.sql.SQLException;

class PatientDAOImplTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new PatientDAOImplTest().save();
    }

    void save() throws SQLException, ClassNotFoundException {
       boolean isSaved=new PatientDAOImpl().save(
               new Patient(
                       "NIC100",
                       "nimal",
                       "011",
                       "colombo",
                       "male",
                       20,
                       "nimal@"
               )
       );
        System.out.println(isSaved);
    }
}