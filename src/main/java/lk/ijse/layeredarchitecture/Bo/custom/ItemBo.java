package lk.ijse.layeredarchitecture.Bo.custom;

import lk.ijse.layeredarchitecture.dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SupperBO{

    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException ;
    boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException ;
    boolean delete(ItemDTO dto) throws SQLException, ClassNotFoundException ;
    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException ;
    String genarateNewId() throws SQLException, ClassNotFoundException ;

}
