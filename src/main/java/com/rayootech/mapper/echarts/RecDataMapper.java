package com.rayootech.mapper.echarts;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.bean.Vo.echartsVo.RecDataVo;
import com.rayootech.resultInfo.ResponseVo;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/4 10:17
 */
public interface RecDataMapper {

    List<String> getProName(String uName);

    List<RecDataVo> getData(RecDataVo recDataVo);

    List<RecDataVo> getDataSale(RecDataVo recDataVo);

    List<String> getEmail(String hrEmail);

//    List<String> getsleProN(String recHrEmail);

    List<String> deliverProName(String uName);

    List<RecDataVo> deliverData(RecDataVo recDataVo);



}
