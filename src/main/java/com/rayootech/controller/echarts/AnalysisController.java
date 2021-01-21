package com.rayootech.controller.echarts;

import com.rayootech.bean.Vo.AttendanceVo;
import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.echarts.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/12 11:00
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private IAnalysisService analysisService;


    /**
     * 交付项目业绩分析1:项目数量
     * @param analysisVo
     * @return
     */
    @GetMapping("/getDataDeliverOne")
    public ResponseVo<Object> getDataDeliverOne(AnalysisVo analysisVo){
        return analysisService.getDataDeliverOne(analysisVo);
    }

    /**
     * 交付项目业绩分析2:人员数量
     * @param analysisVo
     * @return
     */
    @GetMapping("/getDataDeliverTwo")
    public ResponseVo<Object> getDataDeliverTwo(AnalysisVo analysisVo){
        return analysisService.getDataDeliverTwo(analysisVo);
    }
}
