package lk.ijse.layeredarchitecture.Bo.custom.impl;

import lk.ijse.layeredarchitecture.Bo.custom.ItemBo;
import lk.ijse.layeredarchitecture.Dao.custom.ItemDAOInterface;
import lk.ijse.layeredarchitecture.Dao.custom.impl.ItemDAOimpl;
import lk.ijse.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoimpl implements ItemBo {

    ItemDAOInterface itemDAOInterface = new ItemDAOimpl();

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAOInterface.getAll();
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAOInterface.save(dto);
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAOInterface.update(dto);
    }

    @Override
    public boolean delete(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAOInterface.delete(dto);
    }

    @Override
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
        return itemDAOInterface.loadAllItem();
    }

    @Override
    public String genarateNewId() throws SQLException, ClassNotFoundException {
        return itemDAOInterface.genarateNewId();
    }
}
