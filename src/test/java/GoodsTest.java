import com.rj.dao.GoodsDao;
import com.rj.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class GoodsTest {
    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void testAdd() {
        Goods goods = new Goods(null, 1, "蟠桃", "非常好吃", new BigDecimal(20.00), null, "非常好吃", null, null, new Date(), 5, null);
        goodsDao.add(goods);
    }

    @Test
    public void testFindAll() {
        List<Goods> all = goodsDao.findAll();
        for (Goods goods : all) {
            System.out.println(goods.toString());
        }
    }

    @Test
    public void testFindById() {
        Goods byGoodId = goodsDao.findByGoodId(17);
        System.out.println(byGoodId.toString());
    }
}
