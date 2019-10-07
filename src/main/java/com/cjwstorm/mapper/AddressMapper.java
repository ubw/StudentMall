package com.cjwstorm.mapper;

import com.cjwstorm.bean.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    Integer insertAddress(Address address);
    List<Address> getAddressByUid(Integer uid);
    Integer delete(@Param("id") Integer id, @Param("uid") Integer uid);
    Integer updateAddress(Address address);
    Address getAddressByIdAndUid(@Param("id") Integer id, @Param("uid") Integer uid);
    Integer setDefaultAddressOrCancel(@Param("id") Integer id, @Param("uid") Integer uid, @Param("defaultFlag") Integer defaultFlag);
}
