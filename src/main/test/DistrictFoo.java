import com.cjwstorm.bean.Address;
import com.cjwstorm.bean.Area;
import com.cjwstorm.bean.City;
import com.cjwstorm.bean.Province;
import com.cjwstorm.mapper.AddressMapper;
import com.cjwstorm.mapper.DistrictMapper;
import com.cjwstorm.service.IAddressService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DistrictFoo {

    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        DistrictMapper um = ctx.getBean("districtMapper", DistrictMapper.class);

        try {
            List<Province> provinceList = um.listProvinces();
            System.out.println(provinceList);

            List<City> cityList = um.findCitiesByProvinceCode("320000");
            System.out.println(cityList);

            List<Area> areaList = um.findAreasByCityCode("320400");
            System.out.println(areaList);

            String proviceName = um.findProvinceNameByCode("130000");
            System.out.println(proviceName);
            String cityName = um.findCityNameByCode("130300");
            System.out.println(cityName);
            String areaName = um.findAreaNameByCode("130303");
            System.out.println(areaName);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

}
