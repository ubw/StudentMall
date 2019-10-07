package com.cjwstorm.bean;

import java.io.Serializable;
import java.util.Objects;

public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String id;
    private Integer categoryId;
    private  String itemType;
    private  String title;
    private  String sellPoint;
    private Integer price;
    private Integer num;
    private  String barcode;
    private  String image;
    private Integer status;
    private Integer priority;

    public Goods() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(categoryId, goods.categoryId) &&
                Objects.equals(itemType, goods.itemType) &&
                Objects.equals(title, goods.title) &&
                Objects.equals(sellPoint, goods.sellPoint) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(num, goods.num) &&
                Objects.equals(barcode, goods.barcode) &&
                Objects.equals(image, goods.image) &&
                Objects.equals(status, goods.status) &&
                Objects.equals(priority, goods.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, itemType, title, sellPoint, price, num, barcode, image, status, priority);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
