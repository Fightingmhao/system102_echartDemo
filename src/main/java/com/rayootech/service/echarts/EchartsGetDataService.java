package com.rayootech.service.echarts;

public interface EchartsGetDataService {

    String queryInterviewByCompany();


    String queryInterviewByDept(Integer deptId);

    String queryInterviewByHRorPro(String proName, String uName);

    String queryProInfoByUName(String uName);
}
