package lk.ijse.suwasetha.dao;

import lk.ijse.suwasetha.dao.custom.impl.DoctorDAOImpl;
import lk.ijse.suwasetha.dao.custom.impl.PatientDAOImpl;
import lk.ijse.suwasetha.dao.custom.impl.QueryDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public enum DAOType {
        DOCTOR, PATIENT,QUERY
    }

    public static DaoFactory getInstance() {
        if (null == daoFactory) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

   /* public SuperDAO getDao(DAOType type) {
        switch (type) {
            case DOCTOR:
                return new DoctorDAOImpl();
            case PATIENT:
                return new PatientDAOImpl();
            default:
                return null;
        }
    }*/

    public <T> T getDao(DAOType type) {
        switch (type) {
            case DOCTOR:
                return (T)new DoctorDAOImpl();
            case PATIENT:
                return (T)new PatientDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
