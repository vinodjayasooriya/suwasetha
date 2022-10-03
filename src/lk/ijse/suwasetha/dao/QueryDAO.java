package lk.ijse.suwasetha.dao;

import lk.ijse.suwasetha.entity.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO  extends SuperDAO{
    public List<Doctor> getSearchDetail(String text) throws SQLException, ClassNotFoundException;
}
