package lk.ijse.layeredarchitecture.Dao.custom;

import lk.ijse.layeredarchitecture.Dao.CrudDAO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAOInterface extends CrudDAO<ItemDTO> {
    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;
    String genarateNewId() throws SQLException, ClassNotFoundException;

    }
