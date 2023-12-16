package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

import java.util.ArrayList;

public interface PlaceOrderDAOinterface {

    String newId() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;

    boolean saveOder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException;

}
