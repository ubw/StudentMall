import com.cjwstorm.bean.Cart;
import com.cjwstorm.bean.Order;
import com.cjwstorm.bean.OrderGoodsDtl;
import com.cjwstorm.mapper.OrderMapper;
import com.cjwstorm.service.ICartService;
import com.cjwstorm.service.IOrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class OrderFoo {

    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        OrderMapper um = ctx.getBean("orderMapper", OrderMapper.class);

        OrderGoodsDtl orderGoodsDtl = new OrderGoodsDtl();
        orderGoodsDtl.setId(1);
        orderGoodsDtl.setOrderId(1);
        orderGoodsDtl.setGoodsId(1);


        try {
            um.addOrderGoodsDtl(orderGoodsDtl);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }

    @Test
    public  void testService2() {
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        ICartService um = ctx.getBean("cartService", ICartService.class);

        OrderGoodsDtl orderGoodsDtl = new OrderGoodsDtl();
        List<Integer> goodsIds = new ArrayList<>();
        goodsIds.add(100027);
        goodsIds.add(100015);
        try {
            um.findCartListByUidAndGoodsIds(30, goodsIds);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }
    }

}
