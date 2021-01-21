package com.rayootech.service.recruitment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rayootech.bean.Vo.StaffVo;
import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Staff;
import com.rayootech.mapper.recruitment.StaffMapper;
import com.rayootech.mapper.recruitment.StaffVoMapper;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.IStaffService;
import com.rayootech.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 15:41
 */
@Service
public class StaffServiceImpl implements IStaffService {
    @Autowired
    private StaffVoMapper staffVoMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private HttpServletRequest request;
    @Override
    public ResponseVo<Object> getStaff(Integer currentPage,Integer pageSize,StaffVo staffVo) {
        PageHelper.startPage(currentPage,pageSize);
        List<StaffVo> staffVoList = staffVoMapper.getStaff(staffVo);
        PageInfo pageInfo = new PageInfo(staffVoList);
        pageInfo.setList(staffVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object> getStaffList(Integer currentPage, Integer pageSize, StaffVo staffVo) {


        PageHelper.startPage(currentPage,pageSize);
        List<StaffVo> staffList = staffVoMapper.getStaffList(staffVo);
        PageInfo pageInfo = new PageInfo(staffList);
        pageInfo.setList(staffList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object> insertStaff(StaffVo staffVo) {
        Staff staffCode = staffMapper.findByStaffCode(staffVo.getStaffCode());
        if(staffCode != null){
            return ResponseVo.error(1,"人员编码已存在！");
        }
        Staff staff = new Staff();
        staff.setStaffCode(staffVo.getStaffCode());
        staff.setStaffId(staffVo.getTalksId());
        staff.setTalksId(staffVo.getTalksId());
        staff.setStaffName(staffVo.getStaffName());
        staff.setStaffSalary(staffVo.getTalksSalary());
        staff.setStaffTime(staffVo.getTalksTime());
        staff.setStaffState(staffVo.getTalksResult());
        staff.setStaffCost(staffVo.getStaffCost());
        staff.setStaffState(staffVo.getStaffState());
        staff.setStaffPost(staffVo.getCanPost());
        staff.setStaffCard(staffVo.getStaffCard());
        staff.setStaffPhone(staffVo.getCanPhone());
        staff.setStaffRuTime(staffVo.getTalksStaffTime());
        staff.setStaffComputer(staffVo.getStaffComputer());
        staff.setStaffIsOut(staffVo.getStaffIsOut());
        staff.setStaffOutNum(staffVo.getStaffOutNum());
        staff.setStaffCompany(staffVo.getStaffCompany());
        staff.setStaffComCost(staffVo.getStaffComCost());
        staff.setStaffProbation(staffVo.getStaffProbation());
        staff.setStaffCreateTime(new Date());
        staff.setStaffIp(staffVo.getStaffIp());
        int i = staffMapper.insertStaff(staff);
        if (i>0)return ResponseVo.success();
        return ResponseVo.error(1,"添加失败");
    }


    @Override
    public ResponseVo<Object> addStaff(TalksVo talksVo) {

        Staff staff = new Staff();
        staff.setStaffId(talksVo.getTalksId());
        staff.setTalksId(talksVo.getTalksId());
        staff.setStaffName(talksVo.getTalksName());
        staff.setStaffSalary(talksVo.getTalksSalary());
        staff.setStaffTime(talksVo.getTalksTime());
        staff.setStaffState(talksVo.getTalksResult());
        staff.setStaffCreateTime(new Date());
        staff.setStaffCost(talksVo.getStaffCost());
        IpUtil ipUtil = new IpUtil();
        staff.setStaffIp(ipUtil.getIpAddr(request));
        int i = staffMapper.insertStaff(staff);
        if (i>0)return ResponseVo.success();
        return ResponseVo.error(1,"添加失败");
    }

    @Override
    public ResponseVo<Object> gets(Integer currentPage, Integer pageSize, Staff staff) {

        PageHelper.startPage(currentPage,pageSize);
        List<Staff> staffList = staffMapper.gets(staff);
        PageInfo pageInfo = new PageInfo(staffList);
        pageInfo.setList(staffList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<Object>  getStaffById(Integer staffId) {
        return ResponseVo.success(staffVoMapper.getStaffById(staffId));
    }

    @Override
    public ResponseVo<Object> updateStaff(StaffVo staffVo) {

        Staff staff = new Staff();
        staff.setStaffCode(staffVo.getStaffCode());
        staff.setStaffId(staffVo.getStaffId());
        staff.setStaffState(staffVo.getStaffState());
        staff.setStaffOutReason(staffVo.getStaffOutReason());
        staff.setStaffOutTime(staffVo.getStaffOutTime());
        staff.setStaffInReview(staffVo.getStaffInReview());
        staff.setStaffCreateTime(new Date());
        staff.setStaffIp(staffVo.getStaffIp());
        int i = staffMapper.updateStaff(staff);
        if (i>0)return ResponseVo.success(0,"修改成功");
        return ResponseVo.error(1,"修改失败");
    }

    @Override
    public ResponseVo<Object> getTalksNameList(String talksName) {
        return ResponseVo.success(staffVoMapper.getTalksNameList(talksName));
    }

    @Override
    public ResponseVo<Object> getTalksName(String deptName) {
        return ResponseVo.success(staffVoMapper.getTalksName(deptName));
    }

    /**
     * 获取在职人员的姓名
     * @return
     */
    @Override
    public ResponseVo<Object> getStaffName(String canDept) {
        return ResponseVo.success(staffVoMapper.getStaffName(canDept));
    }


}
