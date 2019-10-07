package com.cjwstorm.service;

import com.cjwstorm.bean.*;

import java.util.List;


public interface IAddressService {
    Integer insertAddress(Address address);
    List<Province> listProvinces();
    List<City> listCitiesByProvinceCode(String code);
    List<Area> listAreasByCityCode(String code);
    String findProvinceNameByCode(String code);
    String findCityNameByCode(String code);
    String findAreaNameByCode(String code);
    List<Address> getAddressByUid(Integer uid);
    Integer deleteAddress(Integer id, Integer uid);
    Integer updateAddress(Address address);
    Address getAddressByIdAndUid(Integer id, Integer uid);
    Integer setDefaultAddressOrCancel(Integer id, Integer uid);
}
