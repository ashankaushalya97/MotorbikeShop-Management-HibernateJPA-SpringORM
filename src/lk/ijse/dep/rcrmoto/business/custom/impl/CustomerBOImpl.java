package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.JPAUtil;
import lk.ijse.dep.rcrmoto.business.custom.CustomerBO;
import lk.ijse.dep.rcrmoto.dao.custom.CustomerDAO;
import lk.ijse.dep.rcrmoto.dto.CustomerDTO;
import lk.ijse.dep.rcrmoto.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class CustomerBOImpl implements CustomerBO {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void saveCustomer(CustomerDTO customer) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            customerDAO.save(new Customer(customer.getCustomerId(),customer.getName(),customer.getContact()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCustomer(CustomerDTO customer) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            customerDAO.update(new Customer(customer.getCustomerId(),customer.getName(),customer.getContact()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteCustomer(String id) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            customerDAO.delete(id);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<Customer> all = customerDAO.findAll();
            List<CustomerDTO> customerDTOS = new ArrayList<>();
            for (Customer customer : all) {
                customerDTOS.add(new CustomerDTO(customer.getCustomerId(),customer.getName(),customer.getContact()));
            }

        em.getTransaction().commit();
        em.close();
            return customerDTOS;
    }

    @Override
    public String getLastCustomerId() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            String lastCustomerId = customerDAO.getLastCustomerId();

        em.getTransaction().commit();
        em.close();
            return lastCustomerId;
    }

    @Override
    public List<CustomerDTO> searchCustomer(String text) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        customerDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<Customer> search = customerDAO.searchCustomers(text);
            List<CustomerDTO> customers = new ArrayList<>();
            for (Customer customer : search) {
                customers.add(new CustomerDTO(customer.getCustomerId(),customer.getName(),customer.getContact()));
            }

        em.getTransaction().commit();
        em.close();
            return customers;
    }
}
