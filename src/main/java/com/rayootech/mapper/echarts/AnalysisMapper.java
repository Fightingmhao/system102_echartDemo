package com.rayootech.mapper.echarts;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/12 14:02
 */
public interface AnalysisMapper {


    List<String> getProNameSale(String infoSaleCode);

    List<Double> gerProIncome(AnalysisVo analysisVo);

    List<Double> getEmpCost(AnalysisVo analysisVo);

//    List<String> delProName(AnalysisVo analysisVo);

    List<AnalysisVo> getDeliverIncom(AnalysisVo analysisVo);

    List<Double> getDeliverCost(AnalysisVo analysisVo);

    List<Integer> getDataDeliverOne(AnalysisVo analysisVo);

    List<AnalysisVo> getDataDeliverTwo(AnalysisVo analysisVo);
}
