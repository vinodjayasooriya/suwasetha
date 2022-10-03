package lk.ijse.suwasetha.dao.custom.impl;

import lk.ijse.suwasetha.dao.CrudUtil;
import lk.ijse.suwasetha.dao.QueryDAO;
import lk.ijse.suwasetha.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {


    @Override
    public List<Doctor> getSearchDetail(String text) throws SQLException, ClassNotFoundException {

        ResultSet set =
                CrudUtil.execute(
                        "SELECT * FROM doctor WHERE name LIKE ?", "" +
                                "%" + text + "%");
        List<Doctor> list = new ArrayList<>();
        while (set.next()) {
            list.add(new Doctor(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6)
            ));
        }
        return list;
    }
}
