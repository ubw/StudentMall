package com.cjwstorm.bean;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer uid;
    private String recvName;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvDistrictProvince;
    private String recvDistrictCity;
    private String recvDistrictArea;
    private String recvAddr;
    private String recvPhone;
    private String recvTel;
    private String recvZip;
    private String recvTag;
    private Integer defaultAddress;
    private String createdUser;
    private String modifiedUser;

    //参数这么多，不需要设置全参数的构造器
    public Address() {
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

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvProvince() {
        return recvProvince;
    }

    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince;
    }

    public String getRecvCity() {
        return recvCity;
    }

    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity;
    }

    public String getRecvArea() {
        return recvArea;
    }

    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea;
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

    public String getRecvTag() {
        return recvTag;
    }

    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag;
    }

    public Integer getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Integer defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(uid, address.uid) &&
                Objects.equals(recvName, address.recvName) &&
                Objects.equals(recvProvince, address.recvProvince) &&
                Objects.equals(recvCity, address.recvCity) &&
                Objects.equals(recvArea, address.recvArea) &&
                Objects.equals(recvDistrictProvince, address.recvDistrictProvince) &&
                Objects.equals(recvDistrictCity, address.recvDistrictCity) &&
                Objects.equals(recvDistrictArea, address.recvDistrictArea) &&
                Objects.equals(recvAddr, address.recvAddr) &&
                Objects.equals(recvPhone, address.recvPhone) &&
                Objects.equals(recvTel, address.recvTel) &&
                Objects.equals(recvZip, address.recvZip) &&
                Objects.equals(recvTag, address.recvTag) &&
                Objects.equals(defaultAddress, address.defaultAddress) &&
                Objects.equals(createdUser, address.createdUser) &&
                Objects.equals(modifiedUser, address.modifiedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, recvName, recvProvince, recvCity, recvArea, recvDistrictProvince, recvDistrictCity, recvDistrictArea, recvAddr, recvPhone, recvTel, recvZip, recvTag, defaultAddress, createdUser, modifiedUser);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uid=" + uid +
                ", recvName='" + recvName + '\'' +
                ", recvProvince='" + recvProvince + '\'' +
                ", recvCity='" + recvCity + '\'' +
                ", recvArea='" + recvArea + '\'' +
                ", recvDistrictProvince='" + recvDistrictProvince + '\'' +
                ", recvDistrictCity='" + recvDistrictCity + '\'' +
                ", recvDistrictArea='" + recvDistrictArea + '\'' +
                ", recvAddr='" + recvAddr + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvZip='" + recvZip + '\'' +
                ", recvTag='" + recvTag + '\'' +
                ", defaultAddress=" + defaultAddress +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                '}';
    }
}
