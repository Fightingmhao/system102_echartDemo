package com.rayootech.service.sale.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.CustomerVo;
import com.rayootech.bean.sale.Customer;
import com.rayootech.mapper.sale.CustomerMapper;
import com.rayootech.mapper.sale.CustomerVoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.sale.ICustomerService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * 客户线索信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
@Service
public class CustomerServiceImpl implements ICustomerService
{
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CustomerVoMapper customerVoMapper;
    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;


    /**
     * 查询客户线索信息列表
     * 
     * @return 客户线索信息
     */
    @Override
    public ResponseVo<Object> selectCustomerList(Integer currentPage,
                                             Integer pageSize,
                                                 CustomerVo customerVo){
        customerVo.setCanHremail(dataScopeServiceImp.getDataScope(customerVo.getCanHremail()));
        PageHelper.startPage(currentPage,pageSize);
        List<CustomerVo> customerList = customerVoMapper.selectCustomerList(customerVo);
        PageInfo pageInfo = new PageInfo(customerList);
        pageInfo.setList(customerList);
        return ResponseVo.success(pageInfo);
    }

    /**
     * 新增客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    @Override
    public ResponseVo<Object> insertCustomer(Customer customer) {
        List<Customer> cusNameList = customerMapper.getCusName();
        String cusName = customer.getCusName();
        int k=0;
        for (int i = 0; i <cusNameList.size() ; i++) {
            if (cusNameList.get(i).getCusName().equals(cusName)) {
                k++;
            }
        }
//        操作时间
        customer.setCusTime(new Date());
        if (k == 0){
            int i = customerMapper.insertCustomer(customer);
            if (i>0){
                return ResponseVo.success();
            }
            else {
                return ResponseVo.error(1,"添加失败！");
            }
        }else {
            return ResponseVo.error(1,"客户名称重复");
        }

    }


    /**
     * 查询客户线索信息
     *
     * @param cusId 客户线索信息ID
     * @return 客户线索信息
     */
    @Override
    public Customer selectCustomerById(Long cusId)
    {
        return customerMapper.selectCustomerById(cusId);
    }
    /**
     * 修改客户线索信息
     * 
     * @param customer 客户线索信息
     * @return 结果
     */
    @Override
    public ResponseVo<Object> updateCustomer(Customer customer) {
        List<Customer> cusNameList = customerMapper.getCusName();
        String cusName = customer.getCusName();
        Integer cusId = customer.getCusId();
        int k=0;
        for (int i = 0; i <cusNameList.size() ; i++) {
            if (cusNameList.get(i).getCusName().equals(cusName)&& cusNameList.get(i).getCusId() != cusId) {
                k++;
            }
        }

//        操作时间
        customer.setCusTime(new Date());

        if (k == 0){
            int i = customerMapper.updateCustomer(customer);
            if (i>0){
                return ResponseVo.success();
            }
            else {
                return ResponseVo.error(1,"修改失败！");
            }
        }else {
            return ResponseVo.error(1,"客户名称重复");
        }

    }


}
