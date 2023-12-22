package lk.ijse.layeredarchitecture.Dao.custom;

import lk.ijse.layeredarchitecture.Dao.CrudDAO;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAOinterFace extends CrudDAO<CustomerDTO> {
    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException ;

    boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean delete(CustomerDTO dto) throws SQLException, ClassNotFoundException;


}
