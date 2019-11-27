package lk.ijse.dep.rcrmoto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Category implements SuperEntity{
    @Id
    @Column(name = "category_id")
    private String categoryId;
    private String description;
    @OneToOne(mappedBy = "category")
    private
    Item item;
    public Category() {
    }

    public Category(String categoryId, String description) {
        this.categoryId = categoryId;
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Item getItem() {
        return item;
    }

    public void addItem(Item item) {
        item.setCategory(this);
        this.item = item;
    }
}
