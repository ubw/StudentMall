package com.cjwstorm.bean;

import java.util.Objects;

public class OrderGoodsDtl {
    private Integer id;
    private Integer  orderId;
    private Integer goodsId;
    private String goodsImage;
    private String goodsTitle;
    private String goodsItemType;
    private Integer  goodsPrice;
    private Integer goodsCount;

    public OrderGoodsDtl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        OrderGoodsDtl that = (OrderGoodsDtl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(goodsImage, that.goodsImage) &&
                Objects.equals(goodsTitle, that.goodsTitle) &&
                Objects.equals(goodsItemType, that.goodsItemType) &&
                Objects.equals(goodsPrice, that.goodsPrice) &&
                Objects.equals(goodsCount, that.goodsCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, goodsId, goodsImage, goodsTitle, goodsItemType, goodsPrice, goodsCount);
    }

    @Override
    public String toString() {
        return "OrderGoodsDtl{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsItemType='" + goodsItemType + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
