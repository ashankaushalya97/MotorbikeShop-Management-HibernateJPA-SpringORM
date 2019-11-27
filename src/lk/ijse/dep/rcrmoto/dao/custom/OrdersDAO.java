package lk.ijse.dep.rcrmoto.dao.custom;

import lk.ijse.dep.rcrmoto.dao.CrudDAO;
import lk.ijse.dep.rcrmoto.entity.Orders;

public interface OrdersDAO extends CrudDAO<Orders,String> {

    String getLastOrderId()throws Exception;
}
