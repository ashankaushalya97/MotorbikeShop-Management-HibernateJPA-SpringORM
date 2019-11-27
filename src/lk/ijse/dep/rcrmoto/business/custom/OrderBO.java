package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO2;

import java.util.List;

public interface OrderBO extends SuperBO {

    String getLastOrderId()throws Exception;

    void placeOrder(OrderDTO order)throws Exception;

    List<String> getAllOrderIDs ()throws Exception;

    List<OrderDTO2> getOrderInfo()throws Exception;

    List<OrderDTO2> searchOrder(String text)throws Exception;

}
