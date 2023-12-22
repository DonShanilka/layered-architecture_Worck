package lk.ijse.layeredarchitecture.Dao.custom.impl;

import lk.ijse.layeredarchitecture.Dao.SqlUtil;
import lk.ijse.layeredarchitecture.Dao.custom.CustomerDAOinterFace;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAOinterFace {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery*/

        ResultSet rst = SqlUtil.test("SELECT * FROM Customer");

        ArrayList <CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),
                    rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean delete(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM Customer WHERE id=?",dto.getId());
    }

    /*@Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList <CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),
            rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }

    @Override
    public boolean saveOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        *//*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement*//*

        return SqlUtil.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());

        *//*pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        return pstm.executeUpdate() > 0;*//*
    }

    @Override
    public boolean updateOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        *//*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement*//*

        return SqlUtil.test("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());

        *//*pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());
        return pstm.executeUpdate() > 0;*//*
    }

    @Override
    public boolean deleteOnAction(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        *//*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement*//*

        return SqlUtil.test("DELETE FROM Customer WHERE id=?",dto.getId());

        *//*pstm.setString(1, dto.getId());
        return pstm.executeUpdate() > 0 ;*//*
    }

    public boolean serchCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();
    }*/
}

