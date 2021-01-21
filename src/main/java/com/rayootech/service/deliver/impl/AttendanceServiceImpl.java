package com.rayootech.service.deliver.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.AttendanceVo;
import com.rayootech.bean.deliver.Attendance;
import com.rayootech.mapper.deliver.AttendanceMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:52
 */
@Service
public class AttendanceServiceImpl implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private HttpServletRequest request;



    @Override
    public ResponseVo<Object> selectAttList(Integer currentPage, Integer pageSize, AttendanceVo attendanceVo) {
        if(attendanceVo.getAttTime() == null){
            attendanceVo.setAttTime(new Date());
        }else {
            Date date = attendanceVo.getAttTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            attendanceVo.setAttTime(calendar.getTime());

        }
        PageHelper.startPage(currentPage, pageSize);
        List<AttendanceVo> list = attendanceMapper.selsectAttList(attendanceVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object> addAtt(AttendanceVo attendanceVo) {
        Attendance attendance = new Attendance();
        attendance.setStaffId(attendanceVo.getStaffId());
        attendance.setAttRealday(attendanceVo.getAttRealday());
        attendance.setAttLegalday(attendanceVo.getAttLegalday());
        attendance.setAttTestday(attendanceVo.getAttTestday());
        attendance.setAttFormalday(attendanceVo.getAttFormalday());
        attendance.setAttTestask(attendanceVo.getAttTestask());
        attendance.setAttFormalask(attendanceVo.getAttFormalask());
        attendance.setAttTypask(attendanceVo.getAttTypask());
        attendance.setAttState(attendanceVo.getAttState());
        Date date = attendanceVo.getAttTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        attendanceVo.setAttTime(calendar.getTime());

        attendance.setAttTime(attendanceVo.getAttTime());
        attendance.setAttCreattime(new Date());
//        IpUtil ipUtil = new IpUtil();
        attendance.setAttIp(attendanceVo.getAttIp());
        int i = attendanceMapper.addAtt(attendance);
        if (i>0)return ResponseVo.success(0,"添加成功");

        return ResponseVo.error(1,"添加失败");
    }

    @Override
    public ResponseVo<Object> getFormal(String staffName) {
        return ResponseVo.success(attendanceMapper.getFormal(staffName));
    }

    @Override
    public ResponseVo<Object> getAttById(Integer attId) {
        return ResponseVo.success(attendanceMapper.getAttById(attId));
    }

    @Override
    public ResponseVo<Object> updateAtt(AttendanceVo attendanceVo) {
        Attendance attendance = new Attendance();
        attendance.setAttId(attendanceVo.getAttId());
        attendance.setAttRealday(attendanceVo.getAttRealday());
        attendance.setAttLegalday(attendanceVo.getAttLegalday());
        attendance.setAttTestday(attendanceVo.getAttTestday());
        attendance.setAttFormalday(attendanceVo.getAttFormalday());
        attendance.setAttTestask(attendanceVo.getAttTestask());
        attendance.setAttFormalask(attendanceVo.getAttFormalask());
        attendance.setAttTypask(attendanceVo.getAttTypask());
        attendance.setAttState(attendanceVo.getAttState());
        Date date = attendanceVo.getAttTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        attendanceVo.setAttTime(calendar.getTime());
        attendance.setAttTime(attendanceVo.getAttTime());
        attendance.setAttCreattime(new Date());
        attendance.setAttIp(attendanceVo.getAttIp());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(attendanceVo.getAttTime());
        List<String> list = attendanceMapper.selectAttimeById(attendanceVo.getStaffId());
        int k=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(dateString)){
                k++;
            }
        }
        if (k>0){
            return ResponseVo.error(2,"本月已经添加过考勤");
        } else {
            int i = attendanceMapper.updateAtt(attendance);
            if (i > 0) return ResponseVo.success(0, "修改成功");
            return ResponseVo.error(1, "修改失败");
        }
    }

    @Override
    public ResponseVo<Object> getAttList(Integer currentPage, Integer pageSize, AttendanceVo attendanceVo) {
        if (attendanceVo.getAttTime() != null) {
        Date date = attendanceVo.getAttTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        attendanceVo.setAttTime(calendar.getTime());
        }

        PageHelper.startPage(currentPage, pageSize);
        List<AttendanceVo> list = attendanceMapper.getAttList(attendanceVo);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return ResponseVo.success(pageInfo);
    }
}
