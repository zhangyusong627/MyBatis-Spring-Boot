package tk.mybatis.springboot.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.CreditInfoMapper;
import tk.mybatis.springboot.util.BankEnum;

/**
 * @Description TODO
 * @Author zhuangyusong
 * @Date 2019/12/18 5:53 PM
 **/

@Service
public class GetPsbcxjAnnualInterestRate implements CommonAnnualInterestRateService {

    @Autowired
    private CreditInfoMapper creditInfoMapper;

    @Autowired(required = false)
    private  RateService rateService;

    /**
     * 获取资方年利率
     *
     * @param uid     用户唯一标识
     * @param channel 资方
     * @return
     */
    @Override
    public String getAnnualInterestRate(String uid, String channel) {
        if ("PSBCXJ".equals(channel)){
            String responseInfo = creditInfoMapper.selectCreditInfo(uid, channel);
            System.err.println("数据库原始的输出："+responseInfo);
            return JSONObject.parseObject(JSONObject.parseObject(JSONObject.parseObject(responseInfo).get("respJson").toString()).get("rateList").toString()).get("12").toString();
        }
        return null;
    }

    @Override
    public BankEnum getCode() {
        return BankEnum.PSBCXJ;
    }
}
