import com.cjwstorm.bean.Address;
import com.cjwstorm.bean.User;
import com.cjwstorm.mapper.AddressMapper;
import com.cjwstorm.mapper.UserMapper;
import com.cjwstorm.service.IAddressService;
import com.cjwstorm.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;


public class AddressFoo {

    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        AddressMapper um = ctx.getBean("addressMapper", AddressMapper.class);

        Address address = new Address();
        address.setId(1);
        address.setUid(20);
        address.setRecvName("cjw");
        address.setRecvProvince("10001");
        address.setRecvCity("10001");
        address.setRecvArea("10001");
        address.setRecvDistrictProvince("110");
        address.setRecvDistrictCity("110");
        address.setRecvDistrictArea("110");
        address.setRecvAddr("123123");
        address.setRecvPhone("17602137856");
        try {
            um.insertAddress(address);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }


    @Test
    public  void testService(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IAddressService um = ctx.getBean("addressService", IAddressService.class);

        Address address = new Address();
        address.setId(1);
        address.setUid(20);
        address.setRecvName("cjw");
        address.setRecvProvince("10001");
        address.setRecvCity("10001");
        address.setRecvArea("10001");
        address.setRecvDistrictProvince("110");
        address.setRecvDistrictCity("110");
        address.setRecvDistrictArea("110");
        address.setRecvAddr("123123");
        address.setRecvPhone("17602137856");
        try {
            um.insertAddress(address);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }


    @Test
    public  void testMapper2(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        AddressMapper um = ctx.getBean("addressMapper", AddressMapper.class);

        try {
            List<Address> addressList = um.getAddressByUid(20);
            System.out.println(addressList);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testService2(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        AddressMapper um = ctx.getBean("addressService", AddressMapper.class);

        try {
            List<Address> addressList = um.getAddressByUid(20);
            System.out.println(addressList);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testService3(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IAddressService um = ctx.getBean("addressService", IAddressService.class);

        try {
           Integer ret = um.deleteAddress(15, 20);
           System.out.println("ret:"+ret);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }


    @Test
    public  void testService4(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IAddressService um = ctx.getBean("addressService", IAddressService.class);

        try {
            Address address = new Address();
            address.setUid(20);
            address.setId(2);
            address.setRecvPhone("100");
            address.setRecvArea("310114");
            address.setRecvName("出击馼");
            address.setRecvProvince("310000");
            address.setRecvCity("310100");
            address.setRecvAddr("新的路");
            Integer ret = um.updateAddress(address);
            System.out.println("ret:"+ret);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }


    @Test
    public  void testService5(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IAddressService um = ctx.getBean("addressService", IAddressService.class);

        try {
            Address address = um.getAddressByIdAndUid(2,20);
            System.out.println("address:"+address);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testMapper6(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        AddressMapper um = ctx.getBean("addressMapper", AddressMapper.class);

        try {
            um.setDefaultAddressOrCancel(20, 20, 1);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testService7(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IAddressService um = ctx.getBean("addressService", IAddressService.class);

        try {
            um.setDefaultAddressOrCancel(23, 20);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }
}
