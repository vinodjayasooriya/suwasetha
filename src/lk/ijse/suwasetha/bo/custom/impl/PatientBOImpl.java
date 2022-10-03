package lk.ijse.suwasetha.bo.custom.impl;

import lk.ijse.suwasetha.bo.custom.PatientBO;
import lk.ijse.suwasetha.dao.DaoFactory;
import lk.ijse.suwasetha.dao.custom.DoctorDAO;
import lk.ijse.suwasetha.dao.custom.PatientDAO;
import lk.ijse.suwasetha.dao.custom.impl.PatientDAOImpl;
import lk.ijse.suwasetha.dto.PatientDTO;
import lk.ijse.suwasetha.entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {

    PatientDAO dao =
            DaoFactory.getInstance().
                    getDao(DaoFactory.
                            DAOType.PATIENT);

    @Override
    public boolean savePatient(PatientDTO dto) throws SQLException, ClassNotFoundException {
        return dao.save(
                new Patient(
                        dto.getNic(), dto.getName(), dto.getContact(), dto.getAddress(), dto.getGender(), dto.getAge(), dto.getEmail()
                )
        );
    }

    @Override
    public boolean updatePatient(PatientDTO dto) throws SQLException, ClassNotFoundException {
        return dao.update(
                new Patient(
                        dto.getNic(), dto.getName(), dto.getContact(), dto.getAddress(), dto.getGender(), dto.getAge(), dto.getEmail()
                )
        );
    }

    @Override
    public boolean deletePatient(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public PatientDTO getPatient(String id) throws SQLException, ClassNotFoundException {
        Patient patient = dao.get(id);
        return new PatientDTO(
                patient.getNic(), patient.getName(), patient.getContact(), patient.getAddress(), patient.getGender(), patient.getAge(), patient.getEmail()
        );
    }

    @Override
    public List<PatientDTO> getAllPatients() throws SQLException, ClassNotFoundException {
        List<Patient> all = dao.getAll();
        List<PatientDTO> list = new ArrayList<>();

        for (Patient patient : all) {
            list.add(
                    new PatientDTO(
                            patient.getNic(), patient.getName(), patient.getContact(), patient.getAddress(), patient.getGender(), patient.getAge(), patient.getEmail()
                    )
            );
        }

        return list;
    }
}
