package lk.ijse.suwasetha.bo.custom;

import lk.ijse.suwasetha.bo.SuperBO;
import lk.ijse.suwasetha.dto.DoctorDTO;
import lk.ijse.suwasetha.dto.PatientDTO;

import java.sql.SQLException;
import java.util.List;

public interface DoctorBO extends SuperBO {
    public boolean saveDoctor(DoctorDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateDoctor(DoctorDTO dto) throws SQLException, ClassNotFoundException;

    public boolean deleteDoctor(String id) throws SQLException, ClassNotFoundException;

    public DoctorDTO getDoctor(String id) throws SQLException, ClassNotFoundException;

    public List<DoctorDTO> getAllDoctors() throws SQLException, ClassNotFoundException;
}
