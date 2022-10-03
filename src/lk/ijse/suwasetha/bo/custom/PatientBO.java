package lk.ijse.suwasetha.bo.custom;

import lk.ijse.suwasetha.bo.SuperBO;
import lk.ijse.suwasetha.dto.PatientDTO;
import lk.ijse.suwasetha.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO {

    public boolean savePatient(PatientDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updatePatient(PatientDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deletePatient(String id) throws SQLException, ClassNotFoundException;

    public PatientDTO getPatient(String id) throws SQLException, ClassNotFoundException;

    public List<PatientDTO> getAllPatients() throws SQLException, ClassNotFoundException;


}
