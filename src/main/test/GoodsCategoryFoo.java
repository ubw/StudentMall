
import com.cjwstorm.bean.GoodsCategory;
import com.cjwstorm.mapper.GoodsCategoryMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class GoodsCategoryFoo {

    @Test
    public  void testMapper(){
        // 获取Spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-controller.xml","spring-mapper.xml","spring-service.xml");

        // 获取持久层对象
        GoodsCategoryMapper um = ctx.getBean("goodsCategoryMapper", GoodsCategoryMapper.class);

        try {
            List<GoodsCategory> goodsCategoryList = um.findGoodsCategoryListByParentId(161, 3);
            System.out.println(goodsCategoryList);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ((ClassPathXmlApplicationContext) ctx).close();
        }

    }
}
