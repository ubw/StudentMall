package com.cjwstorm.bean;

import java.io.Serializable;
import java.util.Objects;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer uid;
    private Integer goodsId;
    private String goodsImage;
    private String goodsTitle;
    private String goodsItemType;
    private Integer goodsPrice;
    private Integer goodsCount;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsItemType() {
        return goodsItemType;
    }

    public void setGoodsItemType(String goodsItemType) {
        this.goodsItemType = goodsItemType;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(uid, cart.uid) &&
                Objects.equals(goodsId, cart.goodsId) &&
                Objects.equals(goodsImage, cart.goodsImage) &&
                Objects.equals(goodsTitle, cart.goodsTitle) &&
                Objects.equals(goodsItemType, cart.goodsItemType) &&
                Objects.equals(goodsPrice, cart.goodsPrice) &&
                Objects.equals(goodsCount, cart.goodsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, goodsId, goodsImage, goodsTitle, goodsItemType, goodsPrice, goodsCount);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", goodsId=" + goodsId +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsItemType='" + goodsItemType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
