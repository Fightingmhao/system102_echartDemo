package com.rayootech.service.echarts.impl;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.mapper.echarts.AnalysisMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.echarts.IAnalysisService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/12 14:00
 */
@Service
public class AnalysisServiceImpl implements IAnalysisService {
    @Autowired
    private AnalysisMapper analysisMapper;
    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;

    @Override
    public ResponseVo<Object> getDataDeliverOne(AnalysisVo analysisVo) {
//        根据传过来的登录人邮箱查询所在的部门
        analysisVo.setProDept(dataScopeServiceImp.getDeptName(analysisVo.getInfoSaleCode()));
        if (analysisVo.getYearTime() == null){
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            analysisVo.setYearTime(String.valueOf(year));
        }
        List<Integer> dataDeliverOne = analysisMapper.getDataDeliverOne(analysisVo);

        return ResponseVo.success(dataDeliverOne);
    }

    @Override
    public ResponseVo<Object> getDataDeliverTwo(AnalysisVo analysisVo) {
        //        根据传过来的登录人邮箱查询所在的部门
        analysisVo.setProDept(dataScopeServiceImp.getDeptName(analysisVo.getInfoSaleCode()));

        return ResponseVo.success(analysisMapper.getDataDeliverTwo(analysisVo));
    }
}
