package lk.ijse.suwasetha.bo;

import lk.ijse.suwasetha.bo.custom.impl.CustomQueryBOImpl;
import lk.ijse.suwasetha.bo.custom.impl.DoctorBOImpl;
import lk.ijse.suwasetha.bo.custom.impl.PatientBOImpl;

import javax.swing.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public enum BOType {
        DOCTOR, PATIENT, QUERY
    }

    public static BOFactory getInstance() {
        return (null == boFactory) ? (boFactory = new BOFactory()) : boFactory;
    }

    public <T> T getBo(BOType type) {
        switch (type) {
            case PATIENT:
                return (T) new PatientBOImpl();
            case DOCTOR:
                return (T) new DoctorBOImpl();
            case QUERY:
                return (T) new CustomQueryBOImpl();
            default:
                return null;
        }
    }
}
