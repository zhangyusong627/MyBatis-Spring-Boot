package tk.mybatis.springboot.service;


import tk.mybatis.springboot.util.BankEnum;

/**
 * @Description TODO
 * @Author zhuangyusong
 * @Date 2019/12/18 5:52 PM
 **/

public interface CommonAnnualInterestRateService {
    /**
     * 获取资方年利率
     * @param uid  用户唯一标识
     * @param channel  资方
     * @return
     */
    String getAnnualInterestRate(String uid, String channel);

    /**
     * 获取资方
     * @return
     */
    BankEnum getCode();
}
