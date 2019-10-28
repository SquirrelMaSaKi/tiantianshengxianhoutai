import com.rj.dao.PermDao;
import com.rj.dao.RoleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class PermAndRoleTest {
    @Autowired
    private PermDao permDao;
    @Autowired
    private RoleDao roleDao;


    @Test
    public void testRole() {
        Set<String> admin = roleDao.roleNames("admin");
        System.out.println(admin);
        System.out.println("================");
        Set<String> strings = roleDao.roleNames("2411886382@qq.com");
        System.out.println(strings);
    }

    @Test
    public void testPerm() {
        Set<String> admin = permDao.permNames("admin");
        System.out.println(admin);
        Set<String> strings = permDao.permNames("2411886382@qq.com");
        System.out.println(strings);
    }

}
