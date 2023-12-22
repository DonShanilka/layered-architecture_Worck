package com.example.layeredarchitecture.Dao.custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAOInterface extends CrudDAO<ItemDTO> {
    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;
    String genarateNewId() throws SQLException, ClassNotFoundException;

    }
