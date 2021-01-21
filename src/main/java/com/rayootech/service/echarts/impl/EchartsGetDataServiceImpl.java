package com.rayootech.service.echarts.impl;

import com.google.gson.Gson;
import com.rayootech.bean.Vo.echartsVo.ProInfoVo;
import com.rayootech.mapper.echarts.EchartsGetDataMapper;
import com.rayootech.service.echarts.EchartsGetDataService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EchartsGetDataServiceImpl implements EchartsGetDataService {

    @Autowired
    private EchartsGetDataMapper dataMapper;
    @Autowired
    private DataScopeServiceImp dataScopeService;
    @Override
    public String queryInterviewByCompany() {
        Map map = new HashMap();
        Gson gson = new Gson();
        List<Integer> list = new ArrayList<Integer>();
        List<Double> list1 = new ArrayList();
        double appointmentPre = 0;
        double interViewPre = 0;
        double interViewPassedPre = 0;
        double jobPre = 0;
        //1、查询推荐的总人数
        //2、查询简历审核通过的人数
        int a =  dataMapper.getArgeeNum();
        //3、查询约到面试的人
        int b = dataMapper.getInterViewNum();
        //4、参加面试的人数
        int c = dataMapper.getJoinInterNum();
        //5、面试通过的人数
        int d = dataMapper.getPassedInterViewNum();
        //6、谈判结果为入职的人数
        int e = dataMapper.getTalkResultNum();
        //7、实际入职的人数
        int f = dataMapper.getJobNum();
        System.out.println(a+","+b+","+c+","+d+","+e+","+f);
        if(a != 0){
            // 约面率=约到面试的人数/简历审核通过的人数
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(b != 0){
            // 面试率=参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100 / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(c != 0){
            // 通过率=面试通过的人数/去参加面试的人数
            interViewPassedPre = new BigDecimal((float)d * 100 / c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(e != 0){
            // 入职率=实际入职人数/谈判结果为入职的人数
            jobPre = new BigDecimal((float)f * 100/ e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        System.out.println("appointmentPre"+ appointmentPre);
        System.out.println("interViewPre"+ interViewPre);
        System.out.println("interViewPassedPre"+ interViewPassedPre);
        System.out.println("jobPre"+ jobPre);
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            list.add(e);
            list.add(f);
           list1.add(appointmentPre );
           list1.add(interViewPre);
           list1.add(interViewPassedPre);
           list1.add(jobPre);

        map.put("interPre",list1);
        map.put("interPreNum",list);

        return gson.toJson(map);
    }



    @Override
    public String queryInterviewByDept(Integer deptId) {

        String deptype = dataScopeService.getDeptypeById(deptId);
        System.out.println(deptype);
        if(deptype.equals("J")){
            return  queryInterviewByDliDept(deptId);
        }
        //查询该部门下的所有人
        List<String> list = dataMapper.getDeptPeo(deptId);
        String  usernameList = "";
        for (int i = 0; i < list.size(); i++) {
            usernameList += ("'" + list.get(i) + "'");
            if (i < list.size() - 1) {
                usernameList += ",";
            }
        }
        System.out.println(usernameList);
        Map map = new HashMap();
        Gson gson = new Gson();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Double> list2 = new ArrayList();
        double appointmentPre = 0;
        double interViewPre = 0;
        double interViewPassedPre = 0;
        double jobPre = 0;
        //1、查询推荐的总人数
        //2、查询简历审核通过的人数
        int a =  dataMapper.getArgeeNumByDept(usernameList);
        //3、查询约到面试的人
        int b = dataMapper.getInterViewNumByDept(usernameList);
        if(a != 0){
            // 约面率=约到面试的人数/简历审核通过的人数
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        //4、参加面试的人数
        int c = dataMapper.getJoinInterNumByDept(usernameList);
        if(b != 0){
            // 面试率=参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100 / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        //5、面试通过的人数
        int d = dataMapper.getPassedInterViewNumByDept(usernameList);
        if(c != 0){
            // 通过率=面试通过的人数/去参加面试的人数
            interViewPassedPre = new BigDecimal((float)d * 100 / c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        //6、谈判结果为入职的人数
        int e = dataMapper.getTalkResultNumByDept(usernameList);
        //7、实际入职的人数
        int f = dataMapper.getJobNumByDept(usernameList);
        if(e != 0){
            // 入职率=实际入职人数/谈判结果为入职的人数
            jobPre = new BigDecimal((float)f * 100/ e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        System.out.println(a+","+b+","+c+","+d+","+e+","+f);
        System.out.println("appointmentPre"+ appointmentPre);
        System.out.println("interViewPre"+ interViewPre);
        System.out.println("interViewPassedPre"+ interViewPassedPre);
        System.out.println("jobPre"+ jobPre);
        list1.add(a);
        list1.add(b);
        list1.add(c);
        list1.add(d);
        list1.add(e);
        list1.add(f);

        list2.add(appointmentPre );
        list2.add(interViewPre);
        list2.add(interViewPassedPre);
        list2.add(jobPre);


        map.put("interPre",list2);
        map.put("interPreNum",list1);


        return gson.toJson(map);
    }

    @Override
    public String queryInterviewByHRorPro(String proName,String uName) {

        Map map = new HashMap();
        Gson gson = new Gson();
        List<Integer> list = new ArrayList<Integer>();
        List<Double> list1 = new ArrayList();
        double appointmentPre = 0;
        double interViewPre = 0;
        double interViewPassedPre = 0;
        double jobPre = 0;
        int a =  dataMapper.getArgeeNumByPro(proName,uName);
        //3、查询约到面试的人
        int b = dataMapper.getInterViewNumByPro(proName,uName);

        //4、参加面试的人数
        int c = dataMapper.getJoinInterNumByPro(proName,uName);
        //5、面试通过的人数
        int d = dataMapper.getPassedInterViewNumByPro(proName,uName);
        //6、谈判结果为入职的人数
        int e = dataMapper.getTalkResultNumByPro(proName,uName);
        //7、实际入职的人数
        int f = dataMapper.getJobNumByPro(proName,uName);
        System.out.println(a+","+b+","+c+","+d+","+e+","+f);
        if(a != 0){
            // 约面率=约到面试的人数/简历审核通过的人数
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(b != 0){
            // 面试率=参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100 / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(c != 0){
            // 通过率=面试通过的人数/去参加面试的人数
            interViewPassedPre = new BigDecimal((float)d * 100 / c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(e != 0){
            // 入职率=实际入职人数/谈判结果为入职的人数
            jobPre = new BigDecimal((float)f * 100/ e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        list1.add(appointmentPre );
        list1.add(interViewPre);
        list1.add(interViewPassedPre);
        list1.add(jobPre);

        map.put("interPre",list1);
        map.put("interPreNum",list);

        return gson.toJson(map);
    }

    String queryInterviewByDliDept(Integer deptId){
        Map map = new HashMap();
        Gson gson = new Gson();
        List<Integer> list = new ArrayList<Integer>();
        List<Double> list1 = new ArrayList();
        double appointmentPre = 0;
        double interViewPre = 0;
        double interViewPassedPre = 0;
        double jobPre = 0;
        int a =  dataMapper.getArgeeNumByDli(deptId);
        //3、查询约到面试的人
        int b = dataMapper.getInterViewNumByDli(deptId);

        //4、参加面试的人数
        int c = dataMapper.getJoinInterNumByDli(deptId);
        //5、面试通过的人数
        int d = dataMapper.getPassedInterViewNumByDli(deptId);
        //6、谈判结果为入职的人数
        int e = dataMapper.getTalkResultNumByDli(deptId);
        //7、实际入职的人数
        int f = dataMapper.getJobNumByDli(deptId);
        System.out.println(a+","+b+","+c+","+d+","+e+","+f);
        if(a != 0){
            // 约面率=约到面试的人数/简历审核通过的人数
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(b != 0){
            // 面试率=参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100 / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(c != 0){
            // 通过率=面试通过的人数/去参加面试的人数
            interViewPassedPre = new BigDecimal((float)d * 100 / c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if(e != 0){
            // 入职率=实际入职人数/谈判结果为入职的人数
            jobPre = new BigDecimal((float)f * 100/ e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        list1.add(appointmentPre );
        list1.add(interViewPre);
        list1.add(interViewPassedPre);
        list1.add(jobPre);

        map.put("interPre",list1);
        map.put("interPreNum",list);

        return gson.toJson(map);
    }


    @Override
    public String queryProInfoByUName(String uName) {




        Map map = new HashMap();

        String deptNameList[] = {"部门一", "部门二", "部门三", "部门四", "部门五", "部门六"};
        map.put("deptNameList", deptNameList);
        int deptResNumList[] = {1100, 1520, 2000, 3340, 3900, 3300};
        map.put("deptResNumList", deptResNumList);

        List<ProInfoVo> proNameInfo = dataMapper.getProNameInfo();
        List<String> proNameList = new ArrayList();
        List<Integer> proResNumList = new ArrayList();
        for (ProInfoVo proInfoVo:proNameInfo
             ) {
            System.out.println(proInfoVo.getProName());
            proNameList.add(proInfoVo.getProName());
            proResNumList.add(proInfoVo.getInterNum());
        }
        //String proNameList[] = {"项目一","项目二","项目三","项目四","项目五","项目六","项目七"};
        map.put("proNameList", proNameList);
        map.put("proResNumList", proResNumList);



        String peopleNameList[] = {"小二","张三","李四","王五","赵六","钱琪","郭八","王一","王二","王三","王四","王五","王六","小二","张三","李四","王五","赵六","钱琪","郭八","王一","王二","王三","王四","王五","王六"};
        map.put("peopleNameList", peopleNameList);

        int peopleResNumList[] = {110, 152, 200, 334, 390, 330, 220,110, 152, 200, 334, 390, 330,110, 152, 200, 334, 390, 330, 220,110, 152, 200, 334, 390, 330};
        map.put("peopleResNumList", peopleResNumList);



        Gson gson = new Gson();
        return gson.toJson(map);

    }



}
