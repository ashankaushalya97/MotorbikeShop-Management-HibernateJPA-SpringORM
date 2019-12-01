package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.JPAUtil;
import lk.ijse.dep.rcrmoto.business.custom.OrderBO;
import lk.ijse.dep.rcrmoto.dao.custom.ItemDAO;
import lk.ijse.dep.rcrmoto.dao.custom.OrderDetailDAO;
import lk.ijse.dep.rcrmoto.dao.custom.OrdersDAO;
import lk.ijse.dep.rcrmoto.dao.custom.QueryDAO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO2;
import lk.ijse.dep.rcrmoto.dto.OrderDetailDTO;
import lk.ijse.dep.rcrmoto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Component
public class OrderBOImpl implements OrderBO {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    QueryDAO queryDAO;

    @Override
    public String getLastOrderId() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        ordersDAO.setEntityManager(em);
        em.getTransaction().begin();
            String lastOrderId = ordersDAO.getLastOrderId();

        em.getTransaction().commit();
        em.close();
            return lastOrderId;
    }

    @Override
    public void placeOrder(OrderDTO order) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        ordersDAO.setEntityManager(em);
        orderDetailDAO.setEntityManager(em);
        itemDAO.setEntityManager(em);

        em.getTransaction().begin();
        ordersDAO.save(new Orders(order.getOrderId(),order.getDate(),em.getReference(Customer.class, order.getCustomerId())));
            for (OrderDetailDTO orderDetails : order.getOrderDetail() ) {

                orderDetailDAO.save(new OrderDetail(order.getOrderId(),orderDetails.getItemId(),orderDetails.getQty(),orderDetails.getUnitPrice()));
                Item item = itemDAO.find(orderDetails.getItemId());
                int qty=item.getQtyOnHand()-orderDetails.getQty();
                item.setQtyOnHand(qty);
                itemDAO.update(item);
            }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<String> getAllOrderIDs() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        ordersDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<Orders> allOrders= ordersDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Orders allOrder : allOrders) {
                ids.add(allOrder.getOrderId());
            }

        em.getTransaction().commit();
        em.close();
            return ids;
    }

    @Override
    public List<OrderDTO2> getOrderInfo() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        ordersDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<CustomEntity> orders = queryDAO.getOrderInfo();
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }

        em.getTransaction().commit();
        em.close();
            return all;
    }

    @Override
    public List<OrderDTO2> searchOrder(String text) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        ordersDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<CustomEntity> orders = queryDAO.searchOrder(text);
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }

        em.getTransaction().commit();
        em.close();
            return all;
    }


}
