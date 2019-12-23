package tk.mybatis.springboot.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author zhuangyusong
 * @Date 2019/12/19 7:02 PM
 **/

public interface RateService {
    @Select("select response_info from credit_info where uid = #{uid,jdbcType=VARCHAR} and channel = #{channel,jdbcType=VARCHAR}")
    String selectCreditInfo(@Param("uid") String uid, @Param("channel") String channel);
}
