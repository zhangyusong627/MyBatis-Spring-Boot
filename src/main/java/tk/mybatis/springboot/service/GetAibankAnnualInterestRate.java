package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.CreditInfoMapper;
import tk.mybatis.springboot.service.CommonAnnualInterestRateService;
import tk.mybatis.springboot.util.BankEnum;

/**
 * @Description TODO
 * @Author zhuangyusong
 * @Date 2019/12/18 8:18 PM
 **/
@Service
public class GetAibankAnnualInterestRate implements CommonAnnualInterestRateService {
    @Autowired
    private CreditInfoMapper creditInfoMapper;
    /**
     * 获取资方年利率
     *
     * @param uid     用户唯一标识
     * @param channel 资方
     * @return
     */
    @Override
    public String getAnnualInterestRate(String uid, String channel) {
//        String info = creditInfoMapper.selectCreditInfo(uid, channel);
        return "百信";
    }

    @Override
    public BankEnum getCode() {
        return BankEnum.AIBANK;
    }
}
