package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAOimpl {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),
            rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }
}
