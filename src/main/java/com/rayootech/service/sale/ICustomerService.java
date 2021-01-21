package com.rayootech.service.sale;

import com.rayootech.bean.Vo.CustomerVo;
import com.rayootech.bean.sale.Customer;
import com.rayootech.resultInfo.ResponseVo;


/**
 * 客户线索信息Service接口
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
public interface ICustomerService 
{

    /**
     * 查询客户线索信息列表
     * 
     * @return 客户线索信息集合
     */
    public ResponseVo<Object> selectCustomerList(Integer currentPage, Integer pageSize,  CustomerVo customerVo);

    /**
     * 新增客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    public ResponseVo<Object> insertCustomer(Customer customer);


    /**
     * 查询客户线索信息
     *
     * @param cusId 客户线索信息ID
     * @return 客户线索信息
     */
    public Customer selectCustomerById(Long cusId);

    /**
     * 修改客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    public ResponseVo<Object> updateCustomer(Customer customer);


}
