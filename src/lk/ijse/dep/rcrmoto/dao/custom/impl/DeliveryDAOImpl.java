package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.DeliveryDAO;
import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeliveryDAOImpl extends CrudDAOImpl<Delivery,DeliveryPK> implements DeliveryDAO {

    @Override
    public String getLastDeliveryId() throws Exception {
       return (String) entityManager.createNativeQuery("SELECT deliveryId FROM delivery ORDER BY deliveryId DESC LIMIT 1").getSingleResult();

    }

    @Override
    public List<Delivery> searchDelivery(String text) throws Exception {
       return entityManager.createNativeQuery("SELECT * FROM delivery WHERE deliveryId LIKE ?1 OR orderId LIKE ?2 OR address LIKE ?3 OR states LIKE ?")
                .setParameter(1,text).setParameter(2,text).setParameter(3,text).getResultList();
    }
}
