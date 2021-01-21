package com.rayootech.mapper.sale;

import com.rayootech.bean.sale.Sale;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/27 10:48
 */
public interface SaleMapper {
    /**
     * 根据部门名称查询未立项的客户名称
     *
     * @param deptName 部门名称
     * @return 客户名称
     */
    public List<String> selectCusNameByDeptName(String deptName);

    /**
     * 通过客户名称查询销售名称和所分配的部门
     *
     * @param saleCusname
     * @return
     */
    public Sale selectSaleByCusName(String saleCusname);

    /**
     * 通过客户编码查询客户名称
     *
     * @param cusName
     * @return
     */
    public String selectCusCodeByCusName(String cusName);

    /**
     * 查询项目指派
     *
     * @param saleId 项目指派ID
     * @return 项目指派
     */
    public Sale selectSaleById(Long saleId);

    /**
     * 查询项目指派列表
     *
     * @return 项目指派集合
     */
    public List<Sale> selectSaleList(String saleCusName,
                                     String saleName,
                                     String beginTime,
                                     String endTime,
                                     String canHremail);

    List<Sale> selectSaleList1(String saleCusName,
                               String saleName,
                               String beginTime,
                               String endTime, String canHremail);

    /**
     * 新增项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    public int insertSale(Sale sale);

    /**
     * 获取客户名称
     */
    List<Sale> getCusName();

    /**
     * 修改项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    public int updateSale(Sale sale);

    /**
     * 删除项目指派
     *
     * @param saleId 项目指派ID
     * @return 结果
     */
    public int deleteSaleById(Long saleId);

    /**
     * 批量删除项目指派
     *
     * @param saleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSaleByIds(Long[] saleIds);


}
