package tk.mybatis.springboot.test;

import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.springboot.Application;
import tk.mybatis.springboot.mapper.BfProcessInfoMapper;
import tk.mybatis.springboot.mapper.CreditInfoMapper;
import tk.mybatis.springboot.mapper.TestMapper;
import tk.mybatis.springboot.service.BeanFactory;
import tk.mybatis.springboot.service.CommonAnnualInterestRateService;
import tk.mybatis.springboot.util.BankEnum;


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
    private CreditInfoMapper creditInfoMapper;

    @Autowired
    private BfProcessInfoMapper bfProcessInfoMapper;


    @Test
    public void test() {
        int i = bfProcessInfoMapper.selectData();
        System.err.println("成功查询到"+i+"条");
    }

    @Test
    public void test03() {
//        根据资方获取不同的实现类
        CommonAnnualInterestRateService psbcxj = BeanFactory.getRateService(BankEnum.AIBANK);
//        根据不同的实现类，调用不同的方法
        String interestRate = psbcxj.getAnnualInterestRate("5174e809-252c-45b1-843d-e596fcfd2069",BankEnum.PSBCXJ.toString());
        System.err.println("资方的年化利率为："+interestRate);
    }


    @Test
    public void test02() throws JSONException {
        String responseInfo = creditInfoMapper.selectCreditInfo("5174e809-252c-45b1-843d-e596fcfd2069", "PSBCXJ");
//        System.err.println("数据库原始输出："+psbcxj);
//        JSONObject jsonObject = new JSONObject(psbcxj);
//        System.err.println("转为json对象："+jsonObject.get("bank"));
//        JSONObject jsonObject2 = new JSONObject(jsonObject.get("respJson").toString());
//        System.out.println("获取年利率的值列表："+jsonObject2.get("rateList"));
//        JSONObject jsonObject3 = new JSONObject(jsonObject2.get("rateList").toString());
//        System.out.println("获取年利率的值："+jsonObject3.get("12"));
        String annualInterestRate = com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSONObject.parseObject(JSONObject.parseObject(responseInfo).get("respJson").toString()).get("rateList").toString()).get("12").toString();
        System.out.println("获取年利率的值："+annualInterestRate);


//        把json字符串转为json对象
//        JSONObject jsonObject = JSONObject.parseObject(jsonString);
//        Object respJson = JSONObject.parseObject(jsonString).get("respJson");
//        String string = JSONObject.toJSONString(respJson);
//        System.err.println("成功查询到psbcxj"+jsonObject.get("respJson"));
    }


}
