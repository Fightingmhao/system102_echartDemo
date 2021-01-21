package com.rayootech.service.sale;

import com.rayootech.bean.sale.Sale;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/27 10:58
 */
public interface ISaleService {
    /**
     * 根据部门名称查询未立项的客户名称
     * @param deptName
     * @return
     */
    public ResponseVo<Object> selectCusNameByDeptName(String deptName);

    /**
     * 通过客户名称查询销售名称和交付部门
     * @param saleCusname
     * @return
     */
    public ResponseVo<Object> selectSaleByCusName(String saleCusname);

    public ResponseVo<Object> selectSalesByDeptName(String deptName);

    public ResponseVo<Object> selectCusBySaleName(String saleName);

    /**
     * 查询项目指派列表
     *
     * @return 项目指派集合
     */
    ResponseVo<Object> selectSaleList(Integer currentPage, Integer pageSize,  String saleCusName,
                                      String saleName,
                                      String beginTime,
                                      String endTime,
                                      String canHremail);

    /**
     * 新增项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    public ResponseVo<Object> insertSale( Sale sale);

    /**
     * 查询项目指派
     *
     * @param saleId 项目指派ID
     * @return 项目指派
     */
    public Sale selectSaleById(Long saleId);

    /**
     * 修改项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    ResponseVo<Object> updateSale(Sale sale);


}
