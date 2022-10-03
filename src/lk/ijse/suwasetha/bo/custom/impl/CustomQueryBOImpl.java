package lk.ijse.suwasetha.bo.custom.impl;

import lk.ijse.suwasetha.bo.CustomQueryBO;
import lk.ijse.suwasetha.dao.DaoFactory;
import lk.ijse.suwasetha.dao.QueryDAO;
import lk.ijse.suwasetha.dto.DoctorDTO;
import lk.ijse.suwasetha.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomQueryBOImpl implements CustomQueryBO {

    QueryDAO dao = DaoFactory.getInstance().
            getDao(DaoFactory.DAOType.QUERY);

    @Override
    public List<DoctorDTO> getSelectedDoctors(String text) throws SQLException, ClassNotFoundException {
        List<Doctor> searchDetail = dao.getSearchDetail(text);
        List<DoctorDTO> list = new ArrayList<>();

        for (Doctor doctor : searchDetail) {
            list.add(new DoctorDTO(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getAddress(),
                    doctor.getContact(),
                    doctor.getEmail(),
                    doctor.getImage()
            ));
        }
        return list;
    }

}
