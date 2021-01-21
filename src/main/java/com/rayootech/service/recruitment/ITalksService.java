package com.rayootech.service.recruitment;


import com.rayootech.bean.Vo.TalksResultVo;
import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Talks;
import com.rayootech.resultInfo.ResponseVo;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/1 13:58
 */
public interface ITalksService {


    ResponseVo<Object> selectTalksList(Integer currentPage, Integer pageSize, TalksVo talksVo);

    List<TalksVo> select();

    ResponseVo<Object> insertTalks(TalksVo talksVo);

    ResponseVo<Object> getTalksById(Long talksId);

    /**
     * 更新谈判结果
     * @param talks
     * @return
     */
    ResponseVo<Object> updateTalks(Talks talks);

    ResponseVo<Object> getOffer();

    /**
     * 查询谈判结果
     * @param talksResultVo
     * @return
     */
    ResponseVo<Object> selectTalksResult(Integer currentPage, Integer pageSize,TalksResultVo talksResultVo);

    /**
     * 通过ID查询谈判结果
     * @param talksId
     * @return
     */
    ResponseVo<Object> selectTalksResultById(Integer talksId);
}
