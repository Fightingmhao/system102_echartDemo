package com.rayootech.service.sale.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.sale.Sale;
import com.rayootech.mapper.sale.SaleMapper;
import com.rayootech.resultInfo.ResponseEnum;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.sale.ISaleService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/27 10:59
 */
@Service
public class SaleServiceImpl implements ISaleService {
    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    /**
     * 根据部门名称查询未立项的客户名称
     * @param deptName
     * @return
     */
    @Override
    public ResponseVo<Object> selectCusNameByDeptName(String deptName) {
        List<String> list = saleMapper.selectCusNameByDeptName(deptName);
        return ResponseVo.success(list);
    }

    /**
     * 根据客户名称查询销售姓名和交付部门
     * @param saleCusname
     * @return
     */
    @Override
    public ResponseVo<Object> selectSaleByCusName(String saleCusname) {
        return ResponseVo.success(saleMapper.selectSaleByCusName(saleCusname));
    }

    @Override
    public ResponseVo<Object> selectSalesByDeptName(String deptName) {
        return null;
    }

    @Override
    public ResponseVo<Object> selectCusBySaleName(String saleName) {
        return null;
    }

    /**
     * 查询项目指派列表
     *
     * @return 项目指派
     */
    @Override
    public ResponseVo<Object> selectSaleList(Integer currentPage, Integer pageSize,  String saleCusName,
                                             String saleName,
                                             String beginTime,
                                             String endTime,
                                             String canHremail)
    {
        List<Sale> saleList = new ArrayList<>();
        canHremail = dataScopeServiceImp.getDataScope(canHremail);
        if (beginTime == null || endTime == null){

            PageHelper.startPage(currentPage,pageSize);
            saleList = saleMapper.selectSaleList1(saleCusName,saleName, beginTime, endTime,canHremail);

        }else {
//            currentPage = 1;
            PageHelper.startPage(currentPage,pageSize);
            saleList = saleMapper.selectSaleList(saleCusName, saleName,beginTime, endTime, canHremail);

        }
        PageInfo pageInfo = new PageInfo(saleList);
        pageInfo.setList(saleList);
        return ResponseVo.success(pageInfo);

    }

    /**
     * 新增项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    @Override
    public ResponseVo<Object> insertSale(Sale sale) {
        List<Sale> cusNamelist = saleMapper.getCusName();
        String saleCusname = sale.getSaleCusname();
        int k=0;
        for (int i = 0; i <cusNamelist.size() ; i++) {
            if (cusNamelist.get(i).getSaleCusname().equals(saleCusname)) {
                k++;
            }
        }
//        客户编码
        Random random = new Random();
        int i = random.nextInt(100000000);
        String rand = String.valueOf(i);
        sale.setSaleCuscode("ray"+rand);
//        操作时间
        sale.setSaleCreatetime(new Date());
        if (k == 0){
            int i1 = saleMapper.insertSale(sale);
            if (i1>0) {
                return ResponseVo.success();
            }else {
                return ResponseVo.error(1,"添加失败！");
            }
        }else {
            return ResponseVo.error(1,"客户名称重复");
        }


    }


    /**
     * 查询项目指派
     *
     * @param saleId 项目指派ID
     * @return 项目指派
     */
    @Override
    public Sale selectSaleById(Long saleId)
    {
        return saleMapper.selectSaleById(saleId);
    }
    /**
     * 修改项目指派
     *
     * @param sale 项目指派
     * @return 结果
     */
    @Override
    public ResponseVo<Object> updateSale(Sale sale) {
        List<Sale> cusNamelist = saleMapper.getCusName();
        String saleCusname = sale.getSaleCusname();
        Long saleId = sale.getSaleId();
//        操作时间
        sale.setSaleCreatetime(new Date());
        int k=0;
//
        for (int i = 0; i <cusNamelist.size() ; i++) {
            if (cusNamelist.get(i).getSaleCusname().equals(saleCusname) && cusNamelist.get(i).getSaleId() != saleId ) {
                k++;
            }
        }

        if ( k==0){
            int j = saleMapper.updateSale(sale);
            if (j>0){
                return ResponseVo.success(ResponseEnum.SUCCESS);
            }else {
                return ResponseVo.error(2,"数据更新失败");
            }
        }else {
            return ResponseVo.error(1,"客户名称重复");
        }

    }





}
