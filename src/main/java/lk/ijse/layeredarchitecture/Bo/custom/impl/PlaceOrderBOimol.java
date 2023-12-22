package lk.ijse.layeredarchitecture.Bo.custom.impl;

import lk.ijse.layeredarchitecture.Bo.custom.PlaceOrderBo;
import lk.ijse.layeredarchitecture.Dao.DAOfactry;
import lk.ijse.layeredarchitecture.Dao.custom.ItemDAOInterface;
import lk.ijse.layeredarchitecture.Dao.custom.PlaceOrderDAOinterface;
import lk.ijse.layeredarchitecture.Dao.custom.impl.OrderDAOimpl;
import lk.ijse.layeredarchitecture.db.DBConnection;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOimol implements PlaceOrderBo {

    OrderDAOimpl placeOrderDAOimpl = (OrderDAOimpl) DAOfactry.getDaOfactry().getDao(DAOfactry.DAOTyps.ORDERS);
    ItemDAOInterface itemDAOInterface = (ItemDAOInterface) DAOfactry.getDaOfactry().getDao(DAOfactry.DAOTyps.ITEM);
    PlaceOrderDAOinterface placeOrderDAOinterface = (PlaceOrderDAOinterface) DAOfactry.getDaOfactry().getDao(DAOfactry.DAOTyps.ORDERS);

    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();

            //Check order id already exist or not

            boolean b1 = placeOrderDAOimpl.existOrder(orderId);
            //*if order id already exist*//*
            if (b1) {
                return false;
            }
            connection.setAutoCommit(false);

            //Save the Order to the order table
            boolean b2 = placeOrderDAOimpl.saveOrder(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            // add data to the Order Details table

            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = placeOrderDAOimpl.saveOrderDetails(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = placeOrderDAOimpl.findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                boolean b = itemDAOInterface.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return true;
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return placeOrderDAOinterface.existCustomer(id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return placeOrderDAOinterface.newId();
    }

    @Override
    public void loadAllCustomerIds() {

    }

    @Override
    public void loadAllItemCodes() {

    }

    @Override
    public void navigateToHome(MouseEvent event) throws IOException {

    }

    @Override
    public void btnAdd_OnAction(ActionEvent actionEvent) {

    }

    @Override
    public void calculateTotal() {

    }

    @Override
    public void enableOrDisablePlaceOrderButton() {

    }

    @Override
    public void txtQty_OnAction(ActionEvent actionEvent) {

    }

    @Override
    public void btnPlaceOrder_OnAction(ActionEvent actionEvent) {

    }

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        return true; //placeOrderDAOinterface.saveOrder(orderId,orderDate,customerId,orderDetails);
    }
}
