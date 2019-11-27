package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Delivery implements SuperEntity{
    @EmbeddedId
    private DeliveryPK deliveryPK;
    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false,updatable = false)
    private
    Orders orders;
    private String address;
    private String states;


    public Delivery() {
    }

    public Delivery(DeliveryPK deliveryPK, String address, String states) {
        this.deliveryPK = deliveryPK;
        this.address = address;
        this.states = states;
    }

    public Delivery(String deliveryId, String orderId, String address, String states) {
        this.deliveryPK = new DeliveryPK(deliveryId,orderId);
        this.address = address;
        this.states = states;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public DeliveryPK getDeliveryPK() {
        return deliveryPK;
    }

    public void setDeliveryPK(DeliveryPK deliveryPK) {
        this.deliveryPK = deliveryPK;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
