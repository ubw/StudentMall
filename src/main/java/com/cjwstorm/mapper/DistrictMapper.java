package com.cjwstorm.mapper;

import com.cjwstorm.bean.Area;
import com.cjwstorm.bean.City;
import com.cjwstorm.bean.Province;

import java.util.List;

public interface DistrictMapper {
    List<Province> listProvinces();
    List<City> findCitiesByProvinceCode(String code);
    List<Area> findAreasByCityCode(String code);
    String findProvinceNameByCode(String provinceCode);
    String findCityNameByCode(String cityCode);
    String findAreaNameByCode(String areaCode);
}
