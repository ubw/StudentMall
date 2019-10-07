package com.cjwstorm.controller;

import com.cjwstorm.bean.*;
import com.cjwstorm.service.IAddressService;
import com.cjwstorm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
    @Resource(name="addressService")
    private IAddressService addressService;


    @RequestMapping(method=RequestMethod.POST, value="/list_address_info.do")
    public String showList(){
        return "address_list";
    }

    //????????
    @RequestMapping(method = RequestMethod.POST, value="/handle_add.do")
    @ResponseBody
    public ResponseResult<Void> handleAdd(Address address, HttpSession session){
        System.out.println("add  address begin, address"+address);
        ResponseResult<Void> ret = new ResponseResult<>();

        Integer uid = getUidFromSession(session);
        address.setUid(uid);

        try {
            addressService.insertAddress(address);
            ret.setState(0);
            ret.setMsg("成功");
        } catch ( Exception e){
            e.printStackTrace();
            ret.setState(-1);
            ret.setMsg("失败");
        }
        System.out.println("增加完成");
        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/province.do")
    @ResponseBody
    public ResponseResult<List<Province>> showProvinceList(){
        ResponseResult<List<Province>> ret = null;
        List<Province> provinceList = addressService.listProvinces();
        ret = new ResponseResult<>(0, "成功", provinceList);
        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/city.do")
    @ResponseBody
    public ResponseResult<List<City>> showCityList(@RequestParam("provinceCode") String code){
        ResponseResult<List<City>> ret = null;
        List<City> cityList = addressService.listCitiesByProvinceCode(code);
        ret = new ResponseResult<>(0, "成功", cityList);
        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/area.do")
    @ResponseBody
    public ResponseResult<List<Area>> showAreaList(@RequestParam("cityCode") String code){
        ResponseResult<List<Area>> ret = null;
        List<Area> areaList = addressService.listAreasByCityCode(code);
        ret = new ResponseResult<>(0, "成功", areaList);
        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/show_address_list.do")
    @ResponseBody
    public ResponseResult<List<Address>> showAddressList(HttpSession session){
        System.out.println("取出地址列表开始");
        Integer uid = getUidFromSession(session);

        List<Address> addressList = addressService.getAddressByUid(uid);
        System.out.println("取出的地址列表为："+addressList);
        return new ResponseResult<>(0, "成功", addressList);
    }

    @RequestMapping(method = RequestMethod.POST, value="/delete_address.do")
    @ResponseBody
    public ResponseResult<Void> deleteAddress(Integer id, HttpSession session){
        ResponseResult<Void> ret = null;
        Integer uid = getUidFromSession(session);

        try {
            if (addressService.deleteAddress(id, uid) == 1) {
                ret = new ResponseResult<>(0, "删除成功");
            } else {
                ret = new ResponseResult<>(-1, "删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ret = new ResponseResult<>(-2, "删除失败");
        }

        return ret;
    }

    @RequestMapping(method = RequestMethod.POST, value="/update_address.do")
    @ResponseBody
    public ResponseResult<Void> updateAddress(Address address, HttpSession session){
        System.out.println("开始修改地址，address："+address);
        ResponseResult<Void> ret = null;
        Integer uid = getUidFromSession(session);

        //绑定uid到address
        address.setUid(uid);

        if (addressService.updateAddress(address) == 0 ){
            ret = new ResponseResult<>(-1, "更新失败");
            System.out.println("更新失败");
        } else {
            ret = new ResponseResult<>(0, "更新成功");
        }
        return  ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/get_address.do")
    @ResponseBody
    public ResponseResult<Address> getAddressByIdAndUid(Integer id, HttpSession session){
        Integer uid = getUidFromSession(session);
        ResponseResult<Address> ret = null;

        Address address = addressService.getAddressByIdAndUid(id, uid);
        if(address == null){
            ret = new ResponseResult<>(-1, "获取失败");
            return ret;
        }

        ret = new ResponseResult<>(0, "获取成功", address);
        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/set_default.do")
    @ResponseBody
    public ResponseResult<Void> setDefaultAddress(@RequestParam("id") Integer id, HttpSession session){

        System.out.println("控制器层 设置默认地址开始, id="+id);
        ResponseResult<Void> ret = null;
        Integer uid = getUidFromSession(session);

        try{
            addressService.setDefaultAddressOrCancel(id, uid);
            ret = new ResponseResult<>(0, "设置默认地址成功");
        }catch (Exception e){
            e.printStackTrace();
            ret = new ResponseResult<>(-1, "设置默认地址失败");
        }

        return ret;
    }
}
