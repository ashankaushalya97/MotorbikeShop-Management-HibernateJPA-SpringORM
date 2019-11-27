package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer implements SuperEntity{
    @Column(name = "customer_id")
    @Id
    private String customerId;
    private String name;
    private String contact;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(String customerId, String name, String contact) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void addOrders(Orders orders) {
        orders.setCustomer(this);
        this.orders.add(orders);
    }
}
