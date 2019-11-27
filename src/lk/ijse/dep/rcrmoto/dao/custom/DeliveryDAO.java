package lk.ijse.dep.rcrmoto.dao.custom;

import lk.ijse.dep.rcrmoto.dao.CrudDAO;
import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;

import java.util.List;

public interface DeliveryDAO extends CrudDAO<Delivery, DeliveryPK> {

    String getLastDeliveryId()throws Exception;

    List<Delivery> searchDelivery(String text)throws Exception;
}
