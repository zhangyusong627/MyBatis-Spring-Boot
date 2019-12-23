package tk.mybatis.springboot.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.util.BankEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zhuangyusong
 * @Date 2019/12/19 10:33 AM
 **/

@Service
public class BeanFactory implements ApplicationContextAware {

    private static Map<BankEnum, CommonAnnualInterestRateService> rateServiceMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, CommonAnnualInterestRateService> map = applicationContext.getBeansOfType(CommonAnnualInterestRateService.class);
        rateServiceMap = new HashMap<>();
        map.forEach((key, value) -> rateServiceMap.put(value.getCode(), value));

    }

    public static <T extends CommonAnnualInterestRateService> T getRateService(BankEnum code) {
        return (T) rateServiceMap.get(code);
    }

}
