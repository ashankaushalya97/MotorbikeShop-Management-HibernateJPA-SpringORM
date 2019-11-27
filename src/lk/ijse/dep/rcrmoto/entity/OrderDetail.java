package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.*;

@Entity
public class OrderDetail implements SuperEntity{
    @EmbeddedId
    private OrderDetailPK orderDetailPk;
    private int qty;
    @Column(name = "unit_price")
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",insertable = false,updatable = false)
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName ="item_id",insertable = false,updatable = false )
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(String orderId,String itemId, int qty, Double unitPrice) {
        this.orderDetailPk = new OrderDetailPK(orderId,itemId);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailPK getOrderDetailPk() {
        return orderDetailPk;
    }

    public void setOrderDetailPk(OrderDetailPK orderDetailPk) {
        this.orderDetailPk = orderDetailPk;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
