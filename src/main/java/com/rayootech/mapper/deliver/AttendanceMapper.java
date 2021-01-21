package com.rayootech.mapper.deliver;

import com.rayootech.bean.Vo.AttendanceVo;
import com.rayootech.bean.deliver.Attendance;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:53
 */
public interface AttendanceMapper {

    List<AttendanceVo> selsectAttList(AttendanceVo attendanceVo);

    int addAtt(Attendance attendance);

    List<AttendanceVo> getFormal(String staffName);

    AttendanceVo getAttById(Integer attId);

    int updateAtt(Attendance attendance);

    List<AttendanceVo> getAttList(AttendanceVo attendanceVo);

    List<String> selectAttimeById(Integer attId);
}
