package com.cjwstorm.service;



import com.cjwstorm.bean.Address;
import com.cjwstorm.bean.Area;
import com.cjwstorm.bean.City;
import com.cjwstorm.bean.Province;
import com.cjwstorm.mapper.AddressMapper;
import com.cjwstorm.mapper.DistrictMapper;
import com.cjwstorm.service.ex.AddressNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {
    @Resource(name="addressMapper")
    private AddressMapper addressMapper;

    @Resource(name="districtMapper")
    private DistrictMapper districtMapper;

    //常用的业务放在前面注册，登陆
    @Override
    public Integer insertAddress(Address address) {
        //一个屏幕可以看完一个方法，如果超出一个屏幕，优化，能够分出去的分出去。
        address.setRecvDistrictProvince(findProvinceNameByCode(address.getRecvProvince()));
        address.setRecvDistrictCity(findCityNameByCode(address.getRecvCity()));
        address.setRecvDistrictArea(findAreaNameByCode(address.getRecvArea()));
        Integer ret = addressMapper.insertAddress(address);

        return ret;
    }

    @Override
    public List<Province> listProvinces() {
        return districtMapper.listProvinces();
    }

    @Override
    public List<City> listCitiesByProvinceCode(String code) {
        return districtMapper.findCitiesByProvinceCode(code);
    }

    @Override
    public List<Area> listAreasByCityCode(String code) {
        return districtMapper.findAreasByCityCode(code);
    }

    @Override
    public String findProvinceNameByCode(String code) {
        return districtMapper.findProvinceNameByCode(code);
    }

    @Override
    public String findCityNameByCode(String code) {
        return districtMapper.findCityNameByCode(code);
    }

    @Override
    public String findAreaNameByCode(String code) {
        return districtMapper.findAreaNameByCode(code);
    }

    @Override
    public List<Address> getAddressByUid(Integer uid) {
        return addressMapper.getAddressByUid(uid);
    }

    @Override
    @Transactional
    public Integer deleteAddress(Integer id, Integer uid) {
        Integer ret = 0;
        try {
            //先删除
            ret = addressMapper.delete(id, uid);

            //再查询是否还有默认地址
            List<Address> addressList = getAddressByUid(uid);
            //如果地址列表是空或者仍存在默认地址，直接退出
            if (addressList.size() == 0 || addressList.get(0).getDefaultAddress() == 1) {
                System.out.println("地址列表为空，或者删的不是默认地址，直接退出");
                return ret;
            } else {
                //默认地址已经被删，需设置下个默认地址
                System.out.println("需设置新的默认地址，新的默认地址id为"+addressList.get(0).getId());
                setDefaultAddressOrCancel(addressList.get(0).getId(), uid);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public Integer updateAddress(Address address) {
        address.setRecvDistrictProvince(findProvinceNameByCode(address.getRecvProvince()));
        address.setRecvDistrictCity(findCityNameByCode(address.getRecvCity()));
        address.setRecvDistrictArea(findAreaNameByCode(address.getRecvArea()));
        Integer ret  = addressMapper.updateAddress(address);
        return ret;
    }

    @Override
    public Address getAddressByIdAndUid(Integer id, Integer uid) {
        return addressMapper.getAddressByIdAndUid(id, uid);
    }

    @Override
    @Transactional
    public Integer setDefaultAddressOrCancel(Integer id, Integer uid) {
        System.out.println("设置默认地址业务层，id="+id+" uid="+uid);
        if (id == null){
            System.out.println("id为空，设置默认地址失败");
            return -1;
        }

        Integer ret;
        //设置所有的都为非默认
        ret = addressMapper.setDefaultAddressOrCancel(null, uid, 0);
        if (ret <= 0){
            throw  new AddressNotFoundException("设置非默认地址失败，uid未获取到");
        }

        //设置该id为默认
        ret = addressMapper.setDefaultAddressOrCancel(id, uid, 1);
        if (ret <= 0){
            throw  new AddressNotFoundException("设置默认地址失败");
        }

        return ret;
    }
}
