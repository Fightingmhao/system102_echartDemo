package com.rayootech.controller.sale;


import com.rayootech.bean.Vo.CustomerVo;
import com.rayootech.bean.sale.Customer;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.sale.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 客户线索信息Controller
 * 
 * @author ruoyi
 * @date 2020-11-25
 */
@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private ICustomerService customerService;

    /**
     * 查询客户线索信息列表
     */
    @GetMapping("/cusList")
    public ResponseVo<Object> list(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                   CustomerVo customerVo
                                  )
    {

        return customerService.selectCustomerList(currentPage,pageSize,customerVo);
    }

    /**
     * 新增客户线索信息
     */
    @PostMapping("/addCus")
    public ResponseVo<Object> add(@RequestBody Customer customer)
    {
        return customerService.insertCustomer(customer);
    }

    /**
     * 获取客户线索信息详细信息
     */
    @GetMapping("/cusById")
    public ResponseVo<Object> getInfo(@RequestParam Long cusId)
    {
        return ResponseVo.success(customerService.selectCustomerById(cusId));
    }
    /**
     * 修改客户线索信息
     */
    @PutMapping("/updateCus")
    public ResponseVo<Object> edit(@RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }


}
