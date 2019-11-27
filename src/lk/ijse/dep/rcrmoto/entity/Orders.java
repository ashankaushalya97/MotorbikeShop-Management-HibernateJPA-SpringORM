package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Orders implements SuperEntity{
    @Id
    @Column(name = "order_id")
    private String orderId;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;
    @OneToOne(mappedBy = "orders")
    private Delivery delivery;
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;

    public Orders() {
    }

    public Orders(String orderId, Date date, Customer customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        delivery.setOrders(this);
        this.delivery = delivery;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void addOrderDetails(OrderDetail orderDetails) {
        orderDetails.setOrders(this);
        this.orderDetails.add(orderDetails);
    }
}
