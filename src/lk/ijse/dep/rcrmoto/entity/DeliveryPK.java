package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeliveryPK implements Serializable {
    @Column(name = "delivery_id")
    private String deliveryId;
    @Column(name = "order_id")
    private String orderId;

    public DeliveryPK() {
    }

    public DeliveryPK(String deliveryId, String orderId) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
