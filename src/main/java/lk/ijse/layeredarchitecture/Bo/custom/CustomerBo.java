package lk.ijse.layeredarchitecture.Bo.custom;


import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SupperBO{
    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
}
