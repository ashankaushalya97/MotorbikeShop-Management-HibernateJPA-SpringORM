package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.JPAUtil;
import lk.ijse.dep.rcrmoto.business.custom.DeliveryBO;
import lk.ijse.dep.rcrmoto.dao.DAOFactory;
import lk.ijse.dep.rcrmoto.dao.DAOTypes;
import lk.ijse.dep.rcrmoto.dao.custom.DeliveryDAO;
import lk.ijse.dep.rcrmoto.dto.DeliveryDTO;
import lk.ijse.dep.rcrmoto.entity.Delivery;
import lk.ijse.dep.rcrmoto.entity.DeliveryPK;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {

    DeliveryDAO deliveryDAO= DAOFactory.getInstance().getDAO(DAOTypes.DELIVERY);
    @Override
    public void saveDelivery(DeliveryDTO delivery) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        deliveryDAO.setEntityManager(em);
        em.getTransaction().begin();
            deliveryDAO.save(new Delivery(delivery.getDeliveryId(),delivery.getOrderId(),delivery.getAddress(),delivery.getStates()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateDelivery(DeliveryDTO delivery) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            deliveryDAO.update (new Delivery(delivery.getDeliveryId(),delivery.getOrderId(),delivery.getAddress(),delivery.getStates()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteDelivery(String deliveryId, String orderId) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            deliveryDAO.delete(new DeliveryPK(deliveryId,orderId));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<DeliveryDTO> findAllDeliveries() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            List<Delivery> all = deliveryDAO.findAll();
            List<DeliveryDTO> deliveryDTOS = new ArrayList<>();
            for (Delivery delivery : all) {
                deliveryDTOS.add(new DeliveryDTO(delivery.getDeliveryPK().getDeliveryId(),delivery.getDeliveryPK().getOrderId(),delivery.getAddress(),delivery.getStates()));
            }

        em.getTransaction().commit();
        em.close();
            return deliveryDTOS;
    }

    @Override
    public String getLastDeliveryId() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            String id= deliveryDAO.getLastDeliveryId();

        em.getTransaction().commit();
        em.close();
            return id;
    }

    @Override
    public List<String> getOrderIds() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            List<Delivery> all = deliveryDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Delivery delivery : all) {
                ids.add(delivery.getDeliveryPK().getOrderId());
            }

        em.getTransaction().commit();
        em.close();
            return ids;
    }

    @Override
    public List<DeliveryDTO> searchDelivery(String text) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        deliveryDAO.setEntityManager(em);
            List<Delivery> search = deliveryDAO.searchDelivery(text);
            List<DeliveryDTO> deliveries = new ArrayList<>();
            for (Delivery delivery : search) {
                deliveries.add(new DeliveryDTO(delivery.getDeliveryPK().getDeliveryId(),delivery.getDeliveryPK().getOrderId(),delivery.getAddress(),delivery.getStates()));
            }

        em.getTransaction().commit();
        em.close();
            return deliveries;
    }
}
