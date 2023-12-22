package com.example.layeredarchitecture.Dao.custom.impl;

import com.example.layeredarchitecture.Dao.SqlUtil;
import com.example.layeredarchitecture.Dao.custom.PlaceOrderDAOinterface;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;

public class OrderDAOimpl implements PlaceOrderDAOinterface {
    @Override
    public String newId() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery*/

        ResultSet rst = SqlUtil.test("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }


    @Override
    public ItemDTO findItem(String itemCode) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement*/

        return SqlUtil.test("SELECT * FROM Item WHERE code=?",itemCode);

        /*pstm.setString(1, itemCode);
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new ItemDTO(itemCode, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));*/
    }

    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement*/

        return SqlUtil.test("SELECT oid FROM `Orders` WHERE oid=?",orderId);

        /*stm.setString(1, orderId);
        return stm.executeQuery().next();*/
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement*/

        return SqlUtil.test("SELECT id FROM Customer WHERE id=?",id);

        /*pstm.setString(1, id);
        return pstm.executeQuery().next();*/
    }

    @Override
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement*/

        return SqlUtil.test("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto);

        /*stm.setString(1, dto.getOid());
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());
        return stm.executeUpdate()>0;*/
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement*/

        return SqlUtil.test("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());

        /*stm.setString(1, dto.getOrderId());
        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
        stm.setString(3, dto.getCustomerId());
        return stm.executeUpdate()>0;*/
    }

}
