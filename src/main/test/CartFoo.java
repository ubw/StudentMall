
import com.cjwstorm.bean.Cart;
import com.cjwstorm.mapper.CartMapper;
import com.cjwstorm.service.ICartService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class CartFoo {

    @Test
    public  void testService(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        ICartService um = ctx.getBean("cartService", ICartService.class);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setUid(1);
        cart.setGoodsId(1);

        try {
            um.addToCart(cart);

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
        CartMapper um = ctx.getBean("cartMapper", CartMapper.class);

        try {
            List<Integer> IntegerList = new ArrayList<>();
            IntegerList.add(10000017);
            IntegerList.add(10000015);
            List<Cart> cartList1 = um.findCartListByUidAndGoodsIds(30, IntegerList);
            System.out.println(cartList1);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }
    }


    @Test
    public  void testService1(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        ICartService um = ctx.getBean("cartService", ICartService.class);

        try {
            List<Integer> IntegerList = new ArrayList<>();
            IntegerList.add(10000017);
            IntegerList.add(10000015);
            List<Cart> cartList1 = um.findCartListByUidAndGoodsIds(30, IntegerList);
            System.out.println(cartList1);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }
    }
}
