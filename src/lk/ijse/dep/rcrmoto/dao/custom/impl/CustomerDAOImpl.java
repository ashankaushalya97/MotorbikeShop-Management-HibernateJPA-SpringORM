package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.CustomerDAO;
import lk.ijse.dep.rcrmoto.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

public class CustomerDAOImpl extends CrudDAOImpl<Customer,String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
       return (String) entityManager.createNativeQuery("SELECT customer_id FROM Customer order by customer_id desc LIMIT 1").getSingleResult();
    }

    @Override
    public List<Customer> searchCustomers(String text) throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM Customer WHERE customer_id like ?1 or name like ?2 or contact like ?3").setParameter(1,text).setParameter(2,text).setParameter(3,text).getResultList();

    }
}
