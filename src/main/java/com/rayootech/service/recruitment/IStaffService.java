package com.rayootech.service.recruitment;

import com.rayootech.bean.Vo.StaffVo;
import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Staff;
import com.rayootech.resultInfo.ResponseVo;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 15:39
 */
public interface IStaffService {
    ResponseVo<Object> getStaff(Integer currentPage, Integer pageSize, StaffVo staffVo);

    ResponseVo<Object> getStaffList(Integer currentPage, Integer pageSize, StaffVo staff);

    ResponseVo<Object> insertStaff(StaffVo staffVo);

    ResponseVo<Object> addStaff(TalksVo talksVo);

    ResponseVo<Object> gets(Integer currentPage, Integer pageSize, Staff staff);

    ResponseVo<Object>  getStaffById(Integer staffId);

    ResponseVo<Object> updateStaff(StaffVo staffVo);

    ResponseVo<Object> getTalksNameList(String talksName);

    ResponseVo<Object> getTalksName(String deptName);

    ResponseVo<Object> getStaffName(String canDept);

}
