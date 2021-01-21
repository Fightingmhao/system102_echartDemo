package com.rayootech.service;

import com.rayootech.bean.District;

import java.util.List;

/**
 * Created by FightingHao on 2020/12/15
 */
public interface IDistrictService {

    List<District> selectDistrictList(District district);

//    List<TreeSelect02> buildDistrictTreeSelect(List<District> districts);
}
