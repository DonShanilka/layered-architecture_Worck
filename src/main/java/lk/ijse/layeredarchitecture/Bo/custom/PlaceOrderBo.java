package lk.ijse.layeredarchitecture.Bo.custom;

import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBo extends SupperBO{
    boolean existItem(String code) throws SQLException, ClassNotFoundException;


    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;


    String generateNewOrderId() throws SQLException, ClassNotFoundException;

    void loadAllCustomerIds() ;


    void loadAllItemCodes() ;

    void navigateToHome(MouseEvent event) throws IOException;


    void btnAdd_OnAction(ActionEvent actionEvent);

    void calculateTotal();

    void enableOrDisablePlaceOrderButton() ;

    void txtQty_OnAction(ActionEvent actionEvent) ;


    void btnPlaceOrder_OnAction(ActionEvent actionEvent);


    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) ;
        /*Transaction*/
}
