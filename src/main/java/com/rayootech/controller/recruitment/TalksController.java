package com.rayootech.controller.recruitment;

import com.rayootech.bean.Vo.TalksResultVo;
import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Talks;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.recruitment.ITalksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/1 13:57
 */
@RestController
@RequestMapping("/talks")
public class TalksController {

    @Autowired
    private ITalksService talksService;

    @GetMapping("/getTalks")
    public ResponseVo<Object> list(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                   TalksVo talksVo){
        return talksService.selectTalksList(currentPage,pageSize,talksVo);
    }

    @PostMapping("/addTalks")
    public ResponseVo<Object> add(@RequestBody TalksVo talksVo ) {
        return talksService.insertTalks(talksVo);
    }


       @GetMapping("/getTalksByid")
    public ResponseVo<Object> getTalksById(@RequestParam Long talksId){

        return talksService.getTalksById(talksId);
    }

    /**
     * 查询谈判结果
     * @param currentPage
     * @param talksResultVo
     * @return
     */
    @GetMapping("/resultList")
    public ResponseVo<Object> getTalksResult(@RequestParam(value = "currentPage",defaultValue = "1")Integer currentPage,
                                             @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,TalksResultVo talksResultVo){
        return talksService.selectTalksResult(currentPage,pageSize,talksResultVo);

    }

    /**
     * 通过ID查询谈判结果
     * @param talksId
     * @return
     */
    @GetMapping("/talksresultById/{talksId}")
    public ResponseVo<Object> getTalksResultById(@PathVariable Integer talksId){
        return talksService.selectTalksResultById(talksId);
    }

    /**
     * 更新谈判结果
     * @param talks
     * @return
     */
    @PutMapping("/updateTalks")
    public ResponseVo<Object> updateTalks(@RequestBody Talks talks){
        return talksService.updateTalks(talks);
    }



}
