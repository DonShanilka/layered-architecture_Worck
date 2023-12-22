package lk.ijse.layeredarchitecture.Dao;

import lk.ijse.layeredarchitecture.Dao.custom.impl.CustomerDAOimpl;
import lk.ijse.layeredarchitecture.Dao.custom.impl.ItemDAOimpl;
import lk.ijse.layeredarchitecture.Dao.custom.impl.OrderDAOimpl;
import lk.ijse.layeredarchitecture.Dao.custom.impl.QuaryDAOimpl;

public class DAOfactry {

    private static DAOfactry daOfactry;

    private DAOfactry(){

    }

    public static DAOfactry getDaOfactry(){
        return (daOfactry == null) ? new DAOfactry() : daOfactry;
    }

    public enum DAOTyps {
        CUSTOMER,ITEM,ORDERS,QUARY
    }

    public SupperDAO getDao(DAOTyps daoTyps){
        switch (daoTyps){
            case CUSTOMER:
                return new CustomerDAOimpl();

            case ITEM:
                return new ItemDAOimpl();

            case ORDERS:
                return (SupperDAO) new OrderDAOimpl();

            case QUARY:
                return (SupperDAO) new QuaryDAOimpl();

            default:
                return null;
        }
    }
}
