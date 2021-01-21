package com.rayootech.mapper.sale;

import com.rayootech.bean.sale.Customer;
import com.rayootech.bean.sale.Sale;

import java.util.List;


/**
 * 客户线索信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
public interface CustomerMapper 
{
    /**
     * 查询客户线索信息
     * 
     * @param cusId 客户线索信息ID
     * @return 客户线索信息
     */
    public Customer selectCustomerById(Long cusId);

    /**
     * 查询客户线索信息列表
     * 
     * @param customer 客户线索信息
     * @return 客户线索信息集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 客户名称
     * @return
     */
    List<Customer> getCusName();


}
