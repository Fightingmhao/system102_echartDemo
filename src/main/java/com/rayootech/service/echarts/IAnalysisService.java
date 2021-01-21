package com.rayootech.service.echarts;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/12 13:59
 */
public interface IAnalysisService {

    ResponseVo<Object> getDataDeliverOne(AnalysisVo analysisVo);

    ResponseVo<Object> getDataDeliverTwo(AnalysisVo analysisVo);
}
