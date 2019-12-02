package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.OrderBO;
import lk.ijse.dep.rcrmoto.dao.custom.*;
import lk.ijse.dep.rcrmoto.dto.OrderDTO;
import lk.ijse.dep.rcrmoto.dto.OrderDTO2;
import lk.ijse.dep.rcrmoto.dto.OrderDetailDTO;
import lk.ijse.dep.rcrmoto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
public class OrderBOImpl implements OrderBO {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    QueryDAO queryDAO;
    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional(readOnly = true)
    public String getLastOrderId() throws Exception {
            String lastOrderId = ordersDAO.getLastOrderId();
            return lastOrderId;
    }

    @Override
    public void placeOrder(OrderDTO order) throws Exception {
        ordersDAO.save(new Orders(order.getOrderId(),order.getDate(),customerDAO.find(order.getCustomerId())));
            for (OrderDetailDTO orderDetails : order.getOrderDetail() ) {

                orderDetailDAO.save(new OrderDetail(order.getOrderId(),orderDetails.getItemId(),orderDetails.getQty(),orderDetails.getUnitPrice()));
                Item item = itemDAO.find(orderDetails.getItemId());
                int qty=item.getQtyOnHand()-orderDetails.getQty();
                item.setQtyOnHand(qty);
                itemDAO.update(item);
            }
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllOrderIDs() throws Exception {
            List<Orders> allOrders= ordersDAO.findAll();
            List<String> ids = new ArrayList<>();
            for (Orders allOrder : allOrders) {
                ids.add(allOrder.getOrderId());
            }
            return ids;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO2> getOrderInfo() throws Exception {
            List<CustomEntity> orders = queryDAO.getOrderInfo();
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }
            return all;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO2> searchOrder(String text) throws Exception {
            List<CustomEntity> orders = queryDAO.searchOrder(text);
            List<OrderDTO2> all = new ArrayList<>();
            for (CustomEntity order : orders) {
                all.add(new OrderDTO2(order.getOrderId(),order.getDate(),order.getCustomerId(),order.getName(),order.getTotal()));
            }
            return all;
    }


}
