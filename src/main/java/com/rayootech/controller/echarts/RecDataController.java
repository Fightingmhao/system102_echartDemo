package com.rayootech.controller.echarts;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.bean.Vo.echartsVo.RecDataVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.echarts.IRecDataService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/4 10:10
 */
@RestController
@RequestMapping("/recdata")
public class RecDataController {


    @Autowired
    private IRecDataService recDataService;


    /**
     * 查找招聘负责的项目
     * @param uName
     * @return
     */
    @GetMapping("/getProName/{uName}")
    public ResponseVo<Object> getProName(@PathVariable String uName){
        return recDataService.getProName(uName);
    }

    /**
     * 人员的名字
     * @param uName
     * @return
     */
    @GetMapping("/getName/{uName}")
    public ResponseVo<Object> getName(@PathVariable String uName){
        return recDataService.getName(uName);
    }

    /**
     * 小组的名称
     * @param uName
     * @return
     */
    @GetMapping("/getGroup/{uName}")
    public ResponseVo<Object> getGroup(@PathVariable String uName){
        return recDataService.getGroup(uName);
    }

    /**
     * 根据项目名称查询负责的小组
     * @return
     */
    @GetMapping("/getproGroup/{recProName}")
    public ResponseVo<Object> getproGroup(@PathVariable String  recProName ){
        return recDataService.getproGroup(recProName);
    }
    /**
     * 查询小组中人员
     * @param groupName
     * @return
     */
    @GetMapping("/getUName/{groupName}")
    public ResponseVo<Object> getUName(@PathVariable String groupName){
        return recDataService.getUName(groupName);
    }

    /**
     * 获取招聘相关的招聘信息
     * @param recDataVo
     * @return
     */
    @GetMapping("/getData")
    public ResponseVo<Object> getData( RecDataVo recDataVo ){
        return recDataService.getData(recDataVo);
    }
    /**
     * 销售相关项目的招聘信息
     * @param recDataVo
     * @return
     */
    @GetMapping("/getsaleDate")
    public ResponseVo<Object> getSaleData(RecDataVo recDataVo ){
        return recDataService.getSaleData(recDataVo);
    }

    /**
     * 获取部门中所有项目名称
     * @param uName
     * @return
     */
    @GetMapping("/getSaleproName/{uName}")
    public ResponseVo<Object> getSaleproName(@PathVariable String uName){
        return recDataService.getSaleproName(uName);
    }

    /**
     * 查询销售负责的项目
     * @param hrEmail
     * @return
     */
    @GetMapping("/getsalepro/{hrEmail}")
    public ResponseVo<Object> getsalepro(@PathVariable String hrEmail){
        return recDataService.getsalepro(hrEmail);
    }

    /**
     * 交付部门负责的项目名称
     * @param uName
     * @return
     */
    @GetMapping("/deliverProName/{uName}")
    public ResponseVo<Object> deliverProName(@PathVariable String uName){
        return recDataService.deliverProName(uName);
    }

    @GetMapping("/delviceData")
    public ResponseVo<Object> delvieData(RecDataVo recDataVo){
        return recDataService.deliverData(recDataVo);
    }


    /**
     * 查询销售相关的项目业绩信息
     * @param analysisVo
     * @return
     */
    @GetMapping("/getperformanceSale")
    public ResponseVo<Object> getperformanceSale(AnalysisVo analysisVo){
        return recDataService.getperformanceSale(analysisVo);
    }

    /**
     * 查询交付人员的项目业绩
     * @param analysisVo
     * @return
     */
    @GetMapping("/getperforDeliver")
    public ResponseVo<Object> getperforDeliver(AnalysisVo analysisVo){
        return recDataService.getperforDeliver(analysisVo);
    }
}
