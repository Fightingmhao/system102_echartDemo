package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.TalksResultVo;
import com.rayootech.bean.recruitment.Talks;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/1 13:57
 */
public interface TalksMapper {


    List<Talks> getTalksById(Long talksId);

    int insertTalks(Talks talks);

    /**
     * 更新谈判结果
     * @param talks
     * @return
     */
    int updateTalks(Talks talks);

    List<Talks> getOffer();

    /**
     * 通过Hr邮箱查询谈判结果
     * @param talksResultVo
     * @return
     */
    List<TalksResultVo> selectTalksResult(TalksResultVo talksResultVo);

    /**
     * 通过ID查询谈判结果
     * @param talksId
     * @return
     */
    TalksResultVo selectTalksResultById(Integer talksId);
}
