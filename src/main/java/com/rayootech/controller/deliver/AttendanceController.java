package com.rayootech.controller.deliver;

import com.rayootech.bean.Vo.AttendanceVo;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.deliver.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/16 10:47
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
        @Autowired
        private IAttendanceService attendanceService;

        /**
         * 查询需要录入考勤的人员
         */
        @GetMapping("/selectAttList")
        public ResponseVo<Object> selectAttList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                AttendanceVo attendanceVo){
            return attendanceService.selectAttList(currentPage,pageSize,attendanceVo);
        }

        @GetMapping("/getAttList")
        public ResponseVo<Object> getAttList(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                                @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                AttendanceVo attendanceVo){
                return attendanceService.getAttList(currentPage,pageSize,attendanceVo);
        }


        /**
         * 新增出勤表
         */
        @PostMapping("/addAtt")
        public ResponseVo<Object> addAtt(@RequestBody AttendanceVo attendanceVo){
                System.out.println(attendanceVo+"***");
                return attendanceService.addAtt(attendanceVo);
        }

        /**
         * 查询在职人员的姓名、编码、项目名称、是否外协
         * @param staffName
         * @return
         */
        @GetMapping("/getFormal/{staffName}")
        public ResponseVo<Object> getFormal(@PathVariable String staffName){
                return attendanceService.getFormal(staffName);
        }

        /**
         * 获取出勤表详细信息
         */
        @GetMapping("/getAttById/{attId}")
        public ResponseVo<Object> getAttById(@PathVariable Integer attId){
                return attendanceService.getAttById(attId);
        }
        /**
         * 修改出勤表
         */
        @PostMapping("/updateAtt")
        public ResponseVo<Object> updateAtt(@RequestBody AttendanceVo attendanceVo) throws ParseException {
                return attendanceService.updateAtt(attendanceVo);
        }



}
