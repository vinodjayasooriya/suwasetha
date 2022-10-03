package lk.ijse.suwasetha.bo;

import lk.ijse.suwasetha.dto.DoctorDTO;

import java.sql.SQLException;
import java.util.List;
public interface CustomQueryBO extends SuperBO {
    public List<DoctorDTO> getSelectedDoctors(String text) throws SQLException, ClassNotFoundException;
}
