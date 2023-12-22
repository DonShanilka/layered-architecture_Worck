package lk.ijse.layeredarchitecture.Bo.custom;

import lk.ijse.layeredarchitecture.Bo.custom.impl.CustomerBoimpl;
import lk.ijse.layeredarchitecture.Bo.custom.impl.ItemBoimpl;
import lk.ijse.layeredarchitecture.Bo.custom.impl.PlaceOrderBOimol;

public class BOfactry {

    private static BOfactry bOfactry;

    private BOfactry() {

    }

    public static BOfactry getDaOfactry(){
        return (bOfactry == null) ? new BOfactry() : bOfactry;
    }

    public enum  BOType{
        CUSTOMER,ITEM,ORDERS,QUARY
    }

    public SupperBO getBo(BOfactry.BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBoimpl();

            case ITEM:
                return new ItemBoimpl();

            case ORDERS:
                return new PlaceOrderBOimol();

            default:
                return null;
        }
    }

}
