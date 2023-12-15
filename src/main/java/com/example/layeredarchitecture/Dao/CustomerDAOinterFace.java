package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAOinterFace {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean saveOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException;
}
