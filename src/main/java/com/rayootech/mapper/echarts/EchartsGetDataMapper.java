package com.rayootech.mapper.echarts;

import com.rayootech.bean.Vo.echartsVo.ProInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EchartsGetDataMapper {

    int getArgeeNum();

    int getInterViewNum();

    int getJoinInterNum();

    int getPassedInterViewNum();

    int getTalkResultNum();

    int getJobNum();

    int getArgeeNumByPro(String proName, String uName);

    int getInterViewNumByPro(String proName, String uName);

    int getJoinInterNumByPro(String proName, String uName);

    int getPassedInterViewNumByPro(String proName, String uName);

    int getTalkResultNumByPro(String proName, String uName);

    int getJobNumByPro(String proName, String uName);

    List<String> getDeptPeo(Integer deptId);
    
    int getArgeeNumByDept(String usernameList);

    int getInterViewNumByDept(String usernameList);

    int getJoinInterNumByDept(String usernameList);

    int getPassedInterViewNumByDept(String usernameList);

    int getTalkResultNumByDept(String usernameList);

    int getJobNumByDept(String usernameList);


    List<ProInfoVo> getProNameInfo();

    int getArgeeNumByDli(Integer deptId);

    int getInterViewNumByDli(Integer deptId);

    int getJoinInterNumByDli(Integer deptId);

    int getPassedInterViewNumByDli(Integer deptId);

    int getTalkResultNumByDli(Integer deptId);

    int getJobNumByDli(Integer deptId);
}
