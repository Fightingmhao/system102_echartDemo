package com.rayootech.service.echarts;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.bean.Vo.echartsVo.RecDataVo;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/4 10:14
 */
public interface IRecDataService {
    ResponseVo<Object> getProName(String uName);

    ResponseVo<Object> getData(RecDataVo recDataVo);

    ResponseVo<Object> getName(String uName);

    ResponseVo<Object> getGroup(String uName);

    ResponseVo<Object> getSaleData(RecDataVo recDataVo);

    ResponseVo<Object> getSaleproName(String uName);

    ResponseVo<Object> getUName(String groupName);

    ResponseVo<Object> getproGroup(String recProName);

    ResponseVo<Object> getsalepro(String hrEmail);

    ResponseVo<Object> deliverProName(String uName);

    ResponseVo<Object> deliverData(RecDataVo recDataVo);

    ResponseVo<Object> getperformanceSale(AnalysisVo analysisVo);

    ResponseVo<Object> getperforDeliver(AnalysisVo analysisVo);

}
