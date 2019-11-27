package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryBO extends SuperBO {

    void saveDelivery(DeliveryDTO delivery)throws Exception;

    void updateDelivery(DeliveryDTO delivery)throws Exception;

    void deleteDelivery(String deliveryId,String orderId)throws Exception;

    List<DeliveryDTO> findAllDeliveries()throws Exception;

    String getLastDeliveryId()throws Exception;

    List<String> getOrderIds()throws Exception;

    List<DeliveryDTO> searchDelivery(String text)throws Exception;
}
