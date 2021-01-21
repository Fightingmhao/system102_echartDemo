package com.rayootech.controller.sale;

import com.rayootech.bean.sale.Sale;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.sale.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/27 11:03
 */
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    /**
     * 查询某个部门未立项的客户名称
     * @param deptName
     * @return
     */
    @PostMapping("getCusNameByDept/{deptName}")
    public ResponseVo<Object> selectCusNameByDeptName(@PathVariable String deptName){
        return saleService.selectCusNameByDeptName(deptName);
    }

    /**
     *  根据客户名称查询对应的销售和交付部门
     * @param saleCusname
     * @return
     */
    @PostMapping("getSalByCusname/{saleCusname}")
    public ResponseVo<Object> selectSalByCusname(@PathVariable String saleCusname){
        return saleService.selectSaleByCusName(saleCusname);
    }



    @PostMapping("getSaleName/{deptName}")
    public ResponseVo<Object> selectSalesByDeptName(@PathVariable String deptName){
        return saleService.selectSalesByDeptName(deptName);
    }

    @PostMapping("getCusName/{saleName}")
    public ResponseVo<Object> selectCusBySaleName(@PathVariable String saleName){
        return saleService.selectCusBySaleName(saleName);
    }


    /**
     * 查询项目指派列表
     */
    @GetMapping("/listSale")
    public ResponseVo<Object> list(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                   String saleCusName,
                                   String saleCusname,
                                   String canHremail,
                                   String saleName,
                                   String beginTime,
                                   String endTime) {

        return saleService.selectSaleList(currentPage,pageSize,saleCusname,saleName,beginTime,endTime,canHremail);
    }

    /**
     * 导出项目指派列表
     */
   /* @GetMapping("/export")
    public AjaxResult export(Sale sale)
    {
        List<Sale> list = saleService.selectSaleList(sale);
        ExcelUtil<Sale> util = new ExcelUtil<Sale>(Sale.class);
        return util.exportExcel(list, "sale");
    }*/


    /**
     * 新增项目指派
     */
    @PostMapping("/addSale")
    public ResponseVo<Object> add(@RequestBody Sale sale)
    {
        return saleService.insertSale(sale);
    }
    /**
     * 获取项目指派详细信息
     */
    @GetMapping("/saleById")
    public ResponseVo<Object> getInfo(@RequestParam   Long saleId)
    {
        return ResponseVo.success(saleService.selectSaleById(saleId));
    }

    /**
     * 修改项目指派
     */
    @PutMapping("updateSale")
    public ResponseVo<Object> edit(@RequestBody Sale sale)
    {
        return saleService.updateSale(sale);
    }



}
