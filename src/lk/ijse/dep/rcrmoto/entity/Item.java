package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item implements SuperEntity{
    @Id
    @Column(name = "item_id")
    private String itemId;
    @OneToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;
    private String brand;
    private String description;
    @Column(name = "qty_on_hand")
    private int qtyOnHand;
    @Column(name = "buy_price")
    private Double buyPrice;
    @Column(name = "unit_price")
    private Double unitPrice;
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;

    public Item() {
    }

    public Item(String itemId, Category category, String brand, String description, int qtyOnHand, Double buyPrice, Double unitPrice) {
        this.itemId = itemId;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.buyPrice = buyPrice;
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void addOrderDetails(OrderDetail orderDetails) {
        orderDetails.setItem(this);
        this.orderDetails.add(orderDetails);
    }
}
