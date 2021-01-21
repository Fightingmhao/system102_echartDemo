package com.rayootech.service.deliver;

import com.rayootech.bean.Vo.AttendanceVo;
import com.rayootech.resultInfo.ResponseVo;

import java.text.ParseException;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:49
 */
public interface IAttendanceService {

    ResponseVo<Object> selectAttList(Integer currentPage, Integer pageSize, AttendanceVo attendanceVo);

    ResponseVo<Object> addAtt(AttendanceVo attendanceVo);

    ResponseVo<Object> getFormal(String staffName);

    ResponseVo<Object> getAttById(Integer attId);

    ResponseVo<Object> updateAtt(AttendanceVo attendanceVo) throws ParseException;

    ResponseVo<Object> getAttList(Integer currentPage, Integer pageSize, AttendanceVo attendanceVo);

}
