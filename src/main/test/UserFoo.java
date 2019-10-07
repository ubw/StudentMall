import com.cjwstorm.bean.User;
import com.cjwstorm.controller.UserController;
import com.cjwstorm.mapper.UserMapper;
import com.cjwstorm.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserFoo {
    @Test
    public  void testService(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IUserService um = ctx.getBean("userService", IUserService.class);

        try {
            Integer ret = um.register(new User("ljh","ljh", "176123123","123@163.com",0));
            System.out.println(ret);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        UserMapper um = ctx.getBean("userMapper", UserMapper.class);

        try {
            um.findUserByEmail("cjwstorm@163.com");

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testChangePassWordService(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IUserService um = ctx.getBean("userService", IUserService.class);

        try {
            um.changePassword(22, "123123", "lemon2012");

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testEditInfoService(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IUserService um = ctx.getBean("userService", IUserService.class);

        try {
            um.editPersonalInfo(22, "cjw100", "110", "110@163.com", 1);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

}
