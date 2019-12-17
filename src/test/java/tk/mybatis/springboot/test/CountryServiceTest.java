package tk.mybatis.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.springboot.Application;
import tk.mybatis.springboot.mapper.BfProcessInfoMapper;
import tk.mybatis.springboot.mapper.TestMapper;

/**
 * @author liuzh
 * @since 2017/9/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class CountryServiceTest {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private BfProcessInfoMapper bfProcessInfoMapper;

    @Test
    public void test() {
        int i = bfProcessInfoMapper.selectData();
        System.err.println("成功查询到"+i+"条");
    }
}
