package com.rayootech.controller.echarts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.rayootech.service.echarts.EchartsGetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EchartsGetDataController {

    @Autowired
    private EchartsGetDataService dataService;
    @PostMapping("/proManAnalysis")
    public String proManAnalysis(){
        Map map = new HashMap();
        int a[] = {3000,4000,6000,9000,5000};
        map.put("projectEaring",a);
        int b[] = {2000,3000,5500,7000,4000};
        map.put("projectProfits",b);
        int c[] = {2000,3000,5500,7000,4000};
        map.put("projectBack",c);
        int d[] = {1000,2000,5000,6000,3000};
        map.put("projectBackcel",d);
        int e[] = {8,12,15,20,11};
        map.put("peopleNum",e);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    /**
     * 查看整个公司的面试数据统计
     * @return
     */
    @GetMapping("/queryInterviewByCom")
    public String queryInterviewByCompany(){
        return dataService.queryInterviewByCompany();
    }

    /**
     * 根据hr 查询
     * @param uName
     * @return
     */
    @GetMapping("/queryInterviewByHRorPro")
    public String queryInterviewByHR(String proName,String uName){
        System.out.println(proName);
        System.out.println(uName);
        return dataService.queryInterviewByHRorPro(proName,uName);
    }

    /**
     * 根据 部门 统计
     * @param deptId
     * @return
     */
    @GetMapping("/queryInterviewByDept/{deptId}")
    public String queryInterviewByDept(@PathVariable Integer deptId){
        System.out.println(deptId);
        return dataService.queryInterviewByDept(deptId);
    }

    /**
     * 项目支持分析
     * @return
     */
    @PostMapping("/proResAnalysis1")
    public String proManAnalysis1() {
        String uName = "";
        return dataService.queryProInfoByUName(uName);
    }

}
