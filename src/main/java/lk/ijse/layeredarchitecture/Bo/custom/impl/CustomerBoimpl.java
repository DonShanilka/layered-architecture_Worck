package lk.ijse.layeredarchitecture.Bo.custom.impl;

import lk.ijse.layeredarchitecture.Bo.custom.CustomerBo;
import lk.ijse.layeredarchitecture.Dao.custom.CustomerDAOinterFace;
import lk.ijse.layeredarchitecture.Dao.custom.impl.CustomerDAOimpl;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoimpl implements CustomerBo {
    CustomerDAOinterFace customerDAOimpl = new CustomerDAOimpl();

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDAOimpl.getAll();
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAOimpl.save(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAOimpl.update(dto);
    }

    @Override
    public boolean deleteCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAOimpl.delete(dto);
    }
}
