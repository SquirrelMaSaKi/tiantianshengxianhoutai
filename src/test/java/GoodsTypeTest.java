import com.rj.dao.GoodsTypeDao;
import com.rj.pojo.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class GoodsTypeTest {
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Test
    public void testFind() {
        GoodsType byId = goodsTypeDao.findById(1);
        List<GoodsType> all = goodsTypeDao.findAll();
        for (GoodsType goodsType : all) {
            System.out.println(goodsType.toString());
        }
        System.out.println("==========");
        System.out.println(byId.toString());
    }
}
