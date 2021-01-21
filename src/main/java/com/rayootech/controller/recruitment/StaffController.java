package com.rayootech.controller.recruitment;

import com.rayootech.bean.Vo.StaffVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 15:38
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;


    @GetMapping("/getStaff")
    public ResponseVo<Object> getStaff(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                       @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                       StaffVo staffVo
                                       ){

        return staffService.getStaff(currentPage,pageSize,staffVo);
    }


    @GetMapping("/getStaffList")
    public ResponseVo<Object> getStaffList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                       @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                           StaffVo staffVo){
        return staffService.getStaffList(currentPage,pageSize,staffVo);

    }

   @PostMapping("/addStaff")
    public ResponseVo<Object> insertStaff(@RequestBody StaffVo staffVo){

        return staffService.insertStaff(staffVo);
   }

   @GetMapping("/getStaffById")
    public ResponseVo<Object>  getStaffById(@RequestParam Integer staffId){
        return staffService.getStaffById(staffId);
   }

   @PutMapping("/updateStaff")
    public ResponseVo<Object> updateStaff(@RequestBody StaffVo staffVo){
        return staffService.updateStaff(staffVo);
   }

    /**
     * 根据候选人名字获得薪资等信息
     * @param staffName
     * @return
     */
   @GetMapping("/getTalksNameList/{staffName}")
    public ResponseVo<Object> getTalksNameList(@PathVariable String staffName){

        return staffService.getTalksNameList(staffName);
   }

   @PostMapping("/getTalksName/{deptName}")
    public ResponseVo<Object> getTalksName(@PathVariable String deptName){
       return staffService.getTalksName(deptName);
   }

    /**
     * 获取在职人员的姓名
     * @return
     */
    @GetMapping("/getStaffName/{canDept}")
    public ResponseVo<Object> getStaffName(@PathVariable String canDept){
        return staffService.getStaffName(canDept);
    }
}
