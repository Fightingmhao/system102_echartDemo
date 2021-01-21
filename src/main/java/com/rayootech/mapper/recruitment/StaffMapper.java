package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.StaffVo;
import com.rayootech.bean.recruitment.Staff;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 16:42
 */
public interface StaffMapper {

    int insertStaff(Staff staff);

    List<Staff> gets(Staff staff);
//
    Staff getStaffById(Integer staffId);

    int updateStaff(Staff staff);

    Staff findByStaffCode(String staffCode);
}
