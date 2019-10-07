
import com.cjwstorm.bean.Goods;
import com.cjwstorm.mapper.GoodsMapper;
import com.cjwstorm.service.IGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class GoodsFoo {
    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        GoodsMapper um = ctx.getBean("goodsMapper", GoodsMapper.class);

        try {
            List<Goods> goodsList = um.findGoodsListByCategoryId(163, "price desc", 0, 3);
            System.out.println(goodsList);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }
    }

    @Test
    public  void testMapper1(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        IGoodsService um = ctx.getBean("goodsService", IGoodsService.class);

        try {
            List<Goods> goodsList = um.findGoodsListByCategoryId(163, null, 2);
            System.out.println(goodsList);
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
        IGoodsService um = ctx.getBean("goodsService", IGoodsService.class);

        try {
            Goods goods = um.findGoodsById(10000013);
            System.out.println(goods);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }
    }
}
