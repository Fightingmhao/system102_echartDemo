package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.StaffVo;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 15:43
 */
public interface StaffVoMapper {
    List<StaffVo> getStaff(StaffVo staffvo);

    List<StaffVo> getStaffList(StaffVo staffvo);

    StaffVo getStaffById(Integer staffId);

    StaffVo getTalksNameList(String talksName);

    List<String> getTalksName(String deptName);

    List<String> getStaffName(String canDept);
}
