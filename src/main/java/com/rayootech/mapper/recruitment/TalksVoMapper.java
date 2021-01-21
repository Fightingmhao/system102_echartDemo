package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.TalksVo;
import com.rayootech.bean.recruitment.Talks;

import java.util.List;

/**
 * @version 1.0
 * @author:anxue
 * @date 2020/12/2 12:36
 */
public interface TalksVoMapper {

    List<Talks> selectTalksList(TalksVo talksVo);

    List<TalksVo> select();


}
