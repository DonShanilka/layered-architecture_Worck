package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderDAOinterface {

    String newId() throws SQLException, ClassNotFoundException;

    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException;

}
