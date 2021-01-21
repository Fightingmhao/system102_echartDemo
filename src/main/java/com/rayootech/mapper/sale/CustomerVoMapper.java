package com.rayootech.mapper.sale;

import com.rayootech.bean.Vo.CustomerVo;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/11 17:24
 */
public interface CustomerVoMapper {


    List<CustomerVo> selectCustomerList(CustomerVo customerVo);
}
