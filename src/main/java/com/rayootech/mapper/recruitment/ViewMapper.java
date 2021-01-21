package com.rayootech.mapper.recruitment;

import com.rayootech.bean.Vo.InterviewVo;
import com.rayootech.bean.Vo.ViewResultVo;
import com.rayootech.bean.recruitment.View;

import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/12/1 16:02
 */
public interface ViewMapper {

    public int insertView(View view);

    public View selectViewByCanId(Integer canId);

    public Integer selectViewIdByCanId(Integer canId);

    /**
     * 查询需要面试的候选人
     * @param interviewVo
     * @return
     */
    public List<InterviewVo> selectViewer(InterviewVo interviewVo);

    /**
     * 查询面试信息
     * @param viewResultVo
     * @return
     */
    public List<ViewResultVo> selectViewResult(ViewResultVo viewResultVo);

    /**
     * 通过ID查询面试信息
     * @param canId
     * @return
     */
    public ViewResultVo selectViewResultById(Integer canId);

    /**
     * 更新面试信息
     * @param view
     * @return
     */
    public int updateView(View view);

}
