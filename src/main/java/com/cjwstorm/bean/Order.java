package com.cjwstorm.bean;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer uid;
    private String receiver;
    private String recvDistrictProvince;
    private String recvDistrictCity ;
    private String recvDistrictArea ;
    private String recvAddr;
    private String recvPhone;
    private String recvTel;
    private String recvZip;
    private Integer orderStatus;
    private Integer totalPrice;

    public Order() {
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRecvDistrictProvince() {
        return recvDistrictProvince;
    }

    public void setRecvDistrictProvince(String recvDistrictProvince) {
        this.recvDistrictProvince = recvDistrictProvince;
    }

    public String getRecvDistrictCity() {
        return recvDistrictCity;
    }

    public void setRecvDistrictCity(String recvDistrictCity) {
        this.recvDistrictCity = recvDistrictCity;
    }

    public String getRecvDistrictArea() {
        return recvDistrictArea;
    }

    public void setRecvDistrictArea(String recvDistrictArea) {
        this.recvDistrictArea = recvDistrictArea;
    }

    public String getRecvAddr() {
        return recvAddr;
    }

    public void setRecvAddr(String recvAddr) {
        this.recvAddr = recvAddr;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }

    public String getRecvZip() {
        return recvZip;
    }

    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(uid, order.uid) &&
                Objects.equals(receiver, order.receiver) &&
                Objects.equals(recvDistrictProvince, order.recvDistrictProvince) &&
                Objects.equals(recvDistrictCity, order.recvDistrictCity) &&
                Objects.equals(recvDistrictArea, order.recvDistrictArea) &&
                Objects.equals(recvAddr, order.recvAddr) &&
                Objects.equals(recvPhone, order.recvPhone) &&
                Objects.equals(recvTel, order.recvTel) &&
                Objects.equals(recvZip, order.recvZip) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, receiver, recvDistrictProvince, recvDistrictCity, recvDistrictArea, recvAddr, recvPhone, recvTel, recvZip, orderStatus, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", receiver='" + receiver + '\'' +
                ", recvDistrictProvince='" + recvDistrictProvince + '\'' +
                ", recvDistrictCity='" + recvDistrictCity + '\'' +
                ", recvDistrictArea='" + recvDistrictArea + '\'' +
                ", recvAddr='" + recvAddr + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvZip='" + recvZip + '\'' +
                ", orderStatus=" + orderStatus +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
