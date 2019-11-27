package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.HibernateUtil;
import lk.ijse.dep.rcrmoto.business.custom.OrderBO;
import lk.ijse.dep.rcrmoto.dao.DAOFactory;
import lk.ijse.dep.rcrmoto.dao.DAOTypes;
import lk.ijse.dep.rcrmoto.dao.custom.ItemDAO;
import lk.ijse.dep.rcrmoto.dao.custom.OrderDetailDAO;
import lk.ijse.dep.rcrmoto.dao.custom.OrdersDAO;
import lk.ijse.dep.rcrmoto.dao.custom.QueryDAO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO2;
import lk.ijse.dep.rcrmoto.entity.CustomEntity;
import lk.ijse.dep.rcrmoto.entity.Orders;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            ordersDAO.setSession(session);
            session.beginTransaction();
            String lastOrderId = ordersDAO.getLastOrderId();
            session.getTransaction().commit();
            return lastOrderId;
        }
    }

    @Override
    public boolean placeOrder(OrderDTO order) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//
//        try {
//            connection.setAutoCommit(false);
//
////            boolean result = ordersDAO.save(new Orders(order.getOrderId(),order.getDate(),order.getCustomerId()));
//
//            if(!result){
//                connection.rollback();
//                System.out.println("saveOrder");
//                throw new RuntimeException("Something went wrong!");
//            }
//
//            for (OrderDetailDTO orderDetails : order.getOrderDetail() ) {
//
//                result = orderDetailDAO.save(new OrderDetail(order.getOrderId(),orderDetails.getItemId(),orderDetails.getQty(),orderDetails.getUnitPrice()));
//
//                if(!result){
//                    System.out.println("Order Details");
//                    connection.rollback();
//                    throw new RuntimeException("Something went wrong!");
//                }
//
//                Item item = itemDAO.find(orderDetails.getItemId());
//                int qty=item.getQtyOnHand()-orderDetails.getQty();
//                item.setQtyOnHand(qty);
//                result = itemDAO.update(item);
//
//                if(!result){
//                    connection.rollback();
//                    System.out.println("Item");
//                    throw new RuntimeException("Something went wrong!");
//                }
//            }
//            connection.commit();
//            return true;
//
//        }catch (Throwable e){
//            connection.rollback();
//            return false;
//        }finally {
//            connection.setAutoCommit(true);
//        }
        return Boolean.parseBoolean(null);
    }

    @Override
    public List<String> getAllOrderIDs() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            ordersDAO.setSession(session);
            session.beginTransaction();
            List<Orders> allOrders= ordersDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Orders allOrder : allOrders) {
                ids.add(allOrder.getOrderId());
            }
            session.getTransaction().commit();
            return ids;
        }
    }

    @Override
    public List<OrderDTO2> getOrderInfo() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            ordersDAO.setSession(session);
            session.beginTransaction();
            List<CustomEntity> orders = queryDAO.getOrderInfo();
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }
            session.getTransaction().commit();
            return all;
        }
    }

    @Override
    public List<OrderDTO2> searchOrder(String text) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            ordersDAO.setSession(session);
            session.beginTransaction();
            List<CustomEntity> orders = queryDAO.searchOrder(text);
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }
            session.getTransaction().commit();
            return all;
        }
    }


}
