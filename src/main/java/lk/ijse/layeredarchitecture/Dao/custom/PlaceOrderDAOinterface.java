package lk.ijse.layeredarchitecture.Dao.custom;

import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface PlaceOrderDAOinterface {

    String newId() throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException;

    boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
