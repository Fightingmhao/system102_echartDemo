package com.rayootech.service.echarts.impl;

import com.rayootech.bean.Vo.echartsVo.AnalysisVo;
import com.rayootech.bean.Vo.echartsVo.RecDataVo;
import com.rayootech.mapper.UserDtoMapper;
import com.rayootech.mapper.deliver.ProjectMapper;
import com.rayootech.mapper.echarts.AnalysisMapper;
import com.rayootech.mapper.echarts.RecDataMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.echarts.IRecDataService;
import com.rayootech.service.serviceImpl.DataScopeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @version 1.0
 * @author:anxue
 * @date 2021/1/4 10:15
 */
@Service
public class RecDataService implements IRecDataService {
    @Autowired
    private RecDataMapper recDataMapper;
    @Autowired
    private UserDtoMapper userDtoMapper;
    @Autowired
    private DataScopeServiceImp dataScopeServiceImp;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public ResponseVo<Object> getProName(String uName) {
        String dataScope = dataScopeServiceImp.getDataScope(uName);
        return ResponseVo.success(recDataMapper.getProName(dataScope));
    }

    @Override
    public ResponseVo<Object> getData(RecDataVo recDataVo ) {
        String dataScope = null;
        dataScope = dataScopeServiceImp.getDataScope(recDataVo.getRecHrEmail());
//        根据月份查询数据
       if (recDataVo.getMonthTime() != null){
           Date date = recDataVo.getMonthTime();
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(date);
           calendar.add(Calendar.MONTH, 1);
           recDataVo.setMonthTime(calendar.getTime());
       }else if (recDataVo.getMonthTime() == null && recDataVo.getQuarterTime() == null && recDataVo.getYearTime() == null){
           Date date = new Date();
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(date);
           calendar.add(Calendar.MONTH, -1);
           recDataVo.setMonthTime(calendar.getTime());
       }
//        System.out.println("QuarterTime"+recDataVo.getQuarterTime());
        if (recDataVo.getQuarterTime() != null) {
            String[] temp = recDataVo.getQuarterTime().split("/");
            recDataVo.setYears(temp[0]);
            recDataVo.setSeason(temp[1]);
        }
//        System.out.println("year"+recDataVo.getYears());
//        System.out.println("season"+recDataVo.getSeason());
        if (recDataVo.getGroupName() != null){
            dataScope = dataScopeServiceImp.getHRByGroup(recDataVo.getGroupName());
        }
        recDataVo.setRecHrEmail(dataScope);
        List<RecDataVo> dataList = recDataMapper.getData(recDataVo);
//        System.out.println("datalist:"+dataList);
        List<Integer> list = new ArrayList<>();
        List<Double> list1 = new ArrayList<>();

//        面试率
        double interViewPre = 0;
//        约面率
        double appointmentPre = 0;
//        通过率
        double interViewPassedPre = 0;
//        入职率
        double jobPre = 0;
        list.add(dataList.get(0).getResumeCount());
        list.add(dataList.get(0).getResumePassCount());
        list.add(dataList.get(0).getInterviewCount());
        list.add(dataList.get(0).getTakeCount());
        list.add(dataList.get(0).getPassCount());
        list.add(dataList.get(0).getTalksEntryCount());
        list.add(dataList.get(0).getEntryCount());
        list.add(dataList.get(0).getLeaveCount());

//        简历审核通过数量
        int a = list.get(1);
//        约面数量
        int b = list.get(2);
//        参加面试数量
        int c = list.get(3);
//        面试通过数量
        int d = list.get(4);
//        谈判结果为入职的数量
        int e = list.get(5);
//        入职数量
        int f = list.get(6);

        if (b != 0){
            // 面试率=实际去参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (a != 0){
//            约面率=实际约到面试的人数b/简历审核通过的人数a
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (c != 0){
//            通过率=面试通过的人数d/去参加面试的人数c
            interViewPassedPre = new BigDecimal((float)d * 100/c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (e != 0){
//            入职率=实际入职人数f/谈判结果为入职的人数e
            jobPre = new BigDecimal((float)f * 100/e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        list1.add(interViewPre);
        list1.add(appointmentPre);
        list1.add(interViewPassedPre);
        list1.add(jobPre);

        Map map = new HashMap<>();
        map.put("dataList",list);
        map.put("viewAnalysis",list1);
        System.out.println(interViewPre+"--"+appointmentPre+"--"+interViewPassedPre+"--"+jobPre);

        return ResponseVo.success(map);
    }


    @Override
    public ResponseVo<Object> getName(String uName) {
        String dataScope = dataScopeServiceImp.getDataScope(uName);
        System.out.println("////"+dataScope);
        return ResponseVo.success(userDtoMapper.getName(dataScope));
    }

    @Override
    public ResponseVo<Object> getGroup(String uName) {
        return ResponseVo.success(userDtoMapper.getGroup(uName));
    }

    @Override
    public ResponseVo<Object> getSaleData(RecDataVo recDataVo) {
        String dataScope = null;
//        数据权限，获得下级销售的邮箱
        dataScope = dataScopeServiceImp.getDataScope(recDataVo.getRecHrEmail());
//        处理传过来的时间
        if (recDataVo.getMonthTime() != null){
            Date date = recDataVo.getMonthTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            recDataVo.setMonthTime(calendar.getTime());
        }else if (recDataVo.getMonthTime() == null && recDataVo.getQuarterTime() == null && recDataVo.getYearTime() == null){
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, -1);
            recDataVo.setMonthTime(calendar.getTime());
        }
//        System.out.println("QuarterTime"+recDataVo.getQuarterTime());
        if (recDataVo.getQuarterTime() != null) {
            String[] temp = recDataVo.getQuarterTime().split("/");
            recDataVo.setYears(temp[0]);
            recDataVo.setSeason(temp[1]);
        }
//        System.out.println("year"+recDataVo.getYears());
//        System.out.println("season"+recDataVo.getSeason());
        if (recDataVo.getGroupName() != null && recDataVo.getHrEmail() == null){
//            查询销售小组成员的邮箱
            dataScope = dataScopeServiceImp.getHRByGroup(recDataVo.getGroupName());
        }else if (recDataVo.getGroupName() != null && recDataVo.getHrEmail() != null){
            dataScope = dataScopeServiceImp.getHREmail(recDataVo.getHrEmail());
//            dataScope = recDataVo.getHrEmail();
        }
//        String email = dataScopeServiceImp.getEmail(dataScope);
        recDataVo.setRecHrEmail(dataScope);
//        根据销售邮箱查询到所负责的项目名称
//        根据项目名称查询到处需要的数据
        List<RecDataVo> dataList = recDataMapper.getDataSale(recDataVo);
        List<Integer> list = new ArrayList<>();
        List<Double> list1 = new ArrayList<>();

//        面试率
        double interViewPre = 0;
//        约面率
        double appointmentPre = 0;
//        通过率
        double interViewPassedPre = 0;
//        入职率
        double jobPre = 0;
        list.add(dataList.get(0).getResumeCount());
        list.add(dataList.get(0).getResumePassCount());
        list.add(dataList.get(0).getInterviewCount());
        list.add(dataList.get(0).getTakeCount());
        list.add(dataList.get(0).getPassCount());
        list.add(dataList.get(0).getTalksEntryCount());
        list.add(dataList.get(0).getEntryCount());
        list.add(dataList.get(0).getLeaveCount());
        //        简历审核通过数量
        int a = list.get(1);
//        约面数量
        int b = list.get(2);
//        参加面试数量
        int c = list.get(3);
//        面试通过数量
        int d = list.get(4);
//        谈判结果为入职的数量
        int e = list.get(5);
//        入职数量
        int f = list.get(6);

        if (b != 0){
            // 面试率=实际去参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (a != 0){
//            约面率=实际约到面试的人数b/简历审核通过的人数a
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (c != 0){
//            通过率=面试通过的人数d/去参加面试的人数c
            interViewPassedPre = new BigDecimal((float)d * 100/c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (e != 0){
//            入职率=实际入职人数f/谈判结果为入职的人数e
            jobPre = new BigDecimal((float)f * 100/e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        list1.add(interViewPre);
        list1.add(appointmentPre);
        list1.add(interViewPassedPre);
        list1.add(jobPre);

        Map map = new HashMap<>();
        map.put("dataList",list);
        map.put("viewAnalysis",list1);

        return ResponseVo.success(map);

    }
    @Override
    public ResponseVo<Object> getSaleproName(String uName) {
        String dataScope = dataScopeServiceImp.getDataScope(uName);
        return ResponseVo.success(projectMapper.getSaleproName(dataScope));
    }

    @Override
    public ResponseVo<Object> getUName(String groupName) {
        return ResponseVo.success(userDtoMapper.getUName(groupName));
    }

    @Override
    public ResponseVo<Object> getproGroup(String recProName) {
        return ResponseVo.success(userDtoMapper.getproGroup(recProName));
    }

    @Override
    public ResponseVo<Object> getsalepro(String hrEmail) {
        return ResponseVo.success(projectMapper.getsalepro(hrEmail));
    }

    @Override
    public ResponseVo<Object> deliverProName(String uName) {
        return ResponseVo.success(recDataMapper.deliverProName(uName));
    }

    @Override
    public ResponseVo<Object> deliverData(RecDataVo recDataVo) {
        //        处理传过来的时间
        if (recDataVo.getMonthTime() != null){
            Date date = recDataVo.getMonthTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            recDataVo.setMonthTime(calendar.getTime());
        }else if (recDataVo.getMonthTime() == null && recDataVo.getQuarterTime() == null && recDataVo.getYearTime() == null){
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, -1);
            recDataVo.setMonthTime(calendar.getTime());
        }
        if (recDataVo.getQuarterTime() != null) {
            String[] temp = recDataVo.getQuarterTime().split("/");
            recDataVo.setYears(temp[0]);
            recDataVo.setSeason(temp[1]);
        }
        List<RecDataVo> recDataVoList = recDataMapper.deliverData(recDataVo);
        List<Integer> list = new ArrayList<>();
        List<Double> list1 = new ArrayList<>();

//        面试率
        double interViewPre = 0;
//        约面率
        double appointmentPre = 0;
//        通过率
        double interViewPassedPre = 0;
//        入职率
        double jobPre = 0;
        list.add(recDataVoList.get(0).getResumeCount());
        list.add(recDataVoList.get(0).getResumePassCount());
        list.add(recDataVoList.get(0).getInterviewCount());
        list.add(recDataVoList.get(0).getTakeCount());
        list.add(recDataVoList.get(0).getPassCount());
        list.add(recDataVoList.get(0).getTalksEntryCount());
        list.add(recDataVoList.get(0).getEntryCount());
        list.add(recDataVoList.get(0).getLeaveCount());
        //        简历审核通过数量
        int a = list.get(1);
//        约面数量
        int b = list.get(2);
//        参加面试数量
        int c = list.get(3);
//        面试通过数量
        int d = list.get(4);
//        谈判结果为入职的数量
        int e = list.get(5);
//        入职数量
        int f = list.get(6);

        if (b != 0){
            // 面试率=实际去参加面试的人数/约到面试的人数
            interViewPre = new BigDecimal((float)c * 100/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (a != 0){
//            约面率=实际约到面试的人数b/简历审核通过的人数a
            appointmentPre = new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (c != 0){
//            通过率=面试通过的人数d/去参加面试的人数c
            interViewPassedPre = new BigDecimal((float)d * 100/c).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        if (e != 0){
//            入职率=实际入职人数f/谈判结果为入职的人数e
            jobPre = new BigDecimal((float)f * 100/e).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        list1.add(interViewPre);
        list1.add(appointmentPre);
        list1.add(interViewPassedPre);
        list1.add(jobPre);

        Map map = new HashMap<>();
        map.put("dataList",list);
        map.put("viewAnalysis",list1);
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo<Object> getperformanceSale(AnalysisVo analysisVo) {

//       小组不为空
        if (analysisVo.getGroupName() != null && analysisVo.getHrEmail() == null){
            String dataScope = dataScopeServiceImp.getHRByGroup(analysisVo.getGroupName());
            analysisVo.setInfoSaleCode(dataScope);
            System.out.println("dataScope" + dataScope);
        } else if (analysisVo.getGroupName() != null && analysisVo.getHrEmail() == ""){
            String dataScope = dataScopeServiceImp.getHRByGroup(analysisVo.getGroupName());
            analysisVo.setInfoSaleCode(dataScope);
            System.out.println("dataScope" + dataScope);
        } else if (analysisVo.getHrEmail() != null && analysisVo.getInfoSaleCode() != null){
            analysisVo.setInfoSaleCode(dataScopeServiceImp.getHREmail(analysisVo.getHrEmail()));
        }else if (analysisVo.getGroupName() == null && analysisVo.getHrEmail() == null && analysisVo.getInfoSaleCode() != null){
            analysisVo.setInfoSaleCode(dataScopeServiceImp.getHREmail(analysisVo.getInfoSaleCode()));
        }

        //        获取要查询销售人员的项目名称
        List<String> proNameList = analysisMapper.getProNameSale(analysisVo.getInfoSaleCode());
        System.out.println("proNameList"+proNameList);
        if (analysisVo.getMonthTime() != null){
            Date date = analysisVo.getMonthTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            analysisVo.setMonthTime(calendar.getTime());
        }else if (analysisVo.getMonthTime() == null && analysisVo.getYearTime() == null && analysisVo.getQuarterTime() == null){
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, -1);
            analysisVo.setMonthTime(calendar.getTime());
        }
        if (analysisVo.getQuarterTime() != null) {
            String[] temp = analysisVo.getQuarterTime().split("/");
            analysisVo.setYears(temp[0]);
            analysisVo.setSeason(temp[1]);
        }
//        每个项目分别的收入
        List<Double> proIncomeList = analysisMapper.gerProIncome(analysisVo);
//        员工成本
        List<Double> empCostList = analysisMapper.getEmpCost(analysisVo);
        System.out.println("proIncomeList:"+proIncomeList+"empCostList:"+empCostList);
//        利润
        List<Double> proProfitList = new ArrayList<>();
        for (int i = 0; i < proIncomeList.size(); i++) {
            proProfitList.add(proIncomeList.get(i)-empCostList.get(i));
        }
        System.out.println("proProfitList"+proProfitList);
        List<Integer> payBackList = new ArrayList<>();
        payBackList.add(60154);
        payBackList.add(80754);
        payBackList.add(45074);
//        利润率=利润/收入
        List<BigDecimal> profitMarginList = new ArrayList<>();
//        new BigDecimal((float)b * 100/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        for (int i = 0; i < proIncomeList.size(); i++) {
            if (proIncomeList.get(i) == null || proIncomeList.get(i) == 0){
                profitMarginList.add(new BigDecimal(0.00));
            }else {
                Double a = proIncomeList.get(i);
                Double b = proProfitList.get(i);
                profitMarginList.add(new BigDecimal(b*100/a).setScale(2,BigDecimal.ROUND_HALF_UP));
            }
        }
        System.out.println("profitMarginList"+profitMarginList);
        Map map = new HashMap<>();
        map.put("proNameList",proNameList);
        map.put("proIncomeList",proIncomeList);
        map.put("proProfitList",proProfitList);
        map.put("payBackList",payBackList);
        map.put("profitMarginList",profitMarginList);
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo<Object> getperforDeliver(AnalysisVo analysisVo) {
//        根据传过来的登录人邮箱查询所在的部门
        analysisVo.setProDept(dataScopeServiceImp.getDeptName(analysisVo.getInfoSaleCode()));
//        处理时间条件
        if (analysisVo.getMonthTime() != null){
            Date date = analysisVo.getMonthTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            analysisVo.setMonthTime(calendar.getTime());
        }else if (analysisVo.getMonthTime() == null && analysisVo.getQuarterTime() == null && analysisVo.getYearTime() == null){
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, -1);
            analysisVo.setMonthTime(calendar.getTime());
        }
        if (analysisVo.getQuarterTime() != null) {
            String[] temp = analysisVo.getQuarterTime().split("/");
            analysisVo.setYears(temp[0]);
            analysisVo.setSeason(temp[1]);
        }
//        查询项目名称
//        List<String> proNameList = analysisMapper.delProName(analysisVo);
//        获得项目收入和项目名称
        List<AnalysisVo> list = analysisMapper.getDeliverIncom(analysisVo);
        System.out.println("list"+list);
        List<String> proNameList = new ArrayList<>();
        List<Double> deliverIncom = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            proNameList.add(list.get(i).getProName());
            System.out.println(list.get(i).getProName());
            deliverIncom.add(list.get(i).getOutShouldTotal());
        }
//        项目成本
        List<Double> deliverCost = analysisMapper.getDeliverCost(analysisVo);
//        计算项目利润
        List<Double> proProfitList = new ArrayList<>();
        for (int i = 0; i < deliverIncom.size(); i++) {
            proProfitList.add(deliverIncom.get(i)-deliverCost.get(i));
        }
        System.out.println("proProfitList"+proProfitList);
        //        项目回款（假数据）
        List<Integer> payBackList = new ArrayList<>();
        payBackList.add(60154);
        payBackList.add(80754);
        payBackList.add(45074);
//        计算利润率
        List<BigDecimal> profitMarginList = new ArrayList<>();
        for (int i = 0; i < deliverIncom.size(); i++) {
            if (deliverIncom.get(i) == null || deliverIncom.get(i) == 0){
                profitMarginList.add(new BigDecimal(0.00));
            }else {
                Double a = deliverIncom.get(i);
                Double b = proProfitList.get(i);
                profitMarginList.add(new BigDecimal(b*100/a).setScale(2,BigDecimal.ROUND_HALF_UP));
            }
        }
        Map map = new HashMap<>();
        map.put("proNameList",proNameList);
        map.put("deliverIncom",deliverIncom);
        map.put("proProfitList",proProfitList);
        map.put("payBackList",payBackList);
        map.put("profitMarginList",profitMarginList);
        System.out.println(map);
        return ResponseVo.success(map);
    }


}
