package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.CustomerDAO;
import lk.ijse.dep.rcrmoto.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOImpl extends CrudDAOImpl<Customer,String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
        Query nativeQuery = entityManager.createNativeQuery("SELECT customer_id FROM Customer order by customer_id desc LIMIT 1");
        return nativeQuery.getResultList().size() > 0 ? (String) nativeQuery.getSingleResult() : null;
    }


    @Override
    public List<Customer> searchCustomers(String text) throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM Customer WHERE customer_id like ?1 or name like ?2 or contact like ?3").setParameter(1,text).setParameter(2,text).setParameter(3,text).getResultList();

    }
}
