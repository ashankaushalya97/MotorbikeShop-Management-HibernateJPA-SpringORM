package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.DeliveryDAO;
import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;
@Component
public class DeliveryDAOImpl extends CrudDAOImpl<Delivery,DeliveryPK> implements DeliveryDAO {

    @Override
    public String getLastDeliveryId() throws Exception {
        Query nativeQuery = entityManager.createNativeQuery("SELECT delivery_id FROM Delivery ORDER BY delivery_id DESC LIMIT 1");
        return nativeQuery.getResultList().size() > 0 ? (String) nativeQuery.getSingleResult() : null;
    }

    @Override
    public List<Delivery> searchDelivery(String text) throws Exception {
       return entityManager.createNativeQuery("SELECT * FROM Delivery WHERE delivery_id LIKE ?1 OR order_id LIKE ?2 OR address LIKE ?3 OR states LIKE ?")
                .setParameter(1,text).setParameter(2,text).setParameter(3,text).getResultList();
    }
}
