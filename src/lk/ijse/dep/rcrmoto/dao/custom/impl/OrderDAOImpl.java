package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.OrdersDAO;
import lk.ijse.dep.rcrmoto.entity.Orders;
import org.springframework.stereotype.Component;


public class OrderDAOImpl extends CrudDAOImpl<Orders,String> implements OrdersDAO {

    @Override
    public String getLastOrderId() throws Exception {
        return (String) entityManager.createNativeQuery("SELECT orderId FROM orders ORDER BY orderId DESC LIMIT 1").getSingleResult();
    }
}
