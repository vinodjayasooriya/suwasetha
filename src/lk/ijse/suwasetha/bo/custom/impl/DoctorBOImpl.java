package lk.ijse.suwasetha.bo.custom.impl;

import lk.ijse.suwasetha.bo.custom.DoctorBO;
import lk.ijse.suwasetha.dao.DaoFactory;
import lk.ijse.suwasetha.dao.custom.DoctorDAO;
import lk.ijse.suwasetha.dao.custom.impl.DoctorDAOImpl;
import lk.ijse.suwasetha.dto.DoctorDTO;
import lk.ijse.suwasetha.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorBOImpl implements DoctorBO {

    DoctorDAO dao =
            DaoFactory.getInstance().
            getDao(DaoFactory.
                    DAOType.DOCTOR);


    @Override
    public boolean saveDoctor(DoctorDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(new Doctor(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getEmail(),
                dto.getImage()
        ));
    }

    @Override
    public boolean updateDoctor(DoctorDTO dto) throws SQLException, ClassNotFoundException {
        return dao.update(
                new Doctor(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getEmail(),
                        dto.getImage()
                )
        );
    }

    @Override
    public boolean deleteDoctor(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public DoctorDTO getDoctor(String id) throws SQLException, ClassNotFoundException {
        Doctor doctor = dao.get(id);
        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getAddress(),
                doctor.getContact(),
                doctor.getEmail(),
                doctor.getImage()
        );
    }

    @Override
    public List<DoctorDTO> getAllDoctors() throws SQLException, ClassNotFoundException {

        List<DoctorDTO> list = new ArrayList<>();
        List<Doctor> all = dao.getAll();

        for (Doctor doctor : all) {
            list.add(
                    new DoctorDTO(
                            doctor.getId(),
                            doctor.getName(),
                            doctor.getAddress(),
                            doctor.getContact(),
                            doctor.getEmail(),
                            doctor.getImage()
                    )
            );
        }

        return list;
    }
}
