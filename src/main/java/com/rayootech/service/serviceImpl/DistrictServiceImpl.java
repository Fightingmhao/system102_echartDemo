package com.rayootech.service.serviceImpl;

import com.rayootech.bean.District;
import com.rayootech.mapper.DistrictMapper;
import com.rayootech.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by FightingHao on 2020/12/15
 */
@Service
public class DistrictServiceImpl implements IDistrictService {


    @Autowired
    DistrictMapper districtMapper;

    @Override
    public List<District> selectDistrictList(District district) {
        return districtMapper.selectDistrictList(district);
    }

//    @Override
//    public List<TreeSelect02> buildDistrictTreeSelect(List<District> districts) {
//        List<TreeSelect02> selects = new ArrayList<>();
//        //生成菜单树
//        for (District district:districts) {
//            if (district.getParentId() == 0){
//                selects.add(new TreeSelect02(buildDistrictTree(districts,district)));
//            }
//        }
//        return selects;
//    }
//
//
//    /**
//     * 生成菜单递归树
//     * @param districts
//     * @param district
//     * @return
//     */
//    District buildDistrictTree(List<District> districts,District district){
//        Boolean flag = false;
//        for (District district1:districts) {
//
//            if (district.getId() == district1.getParentId()){
//                //判断有无子层
//                flag = true;
//                buildDistrictTree(districts,district1);
//            }
//
//            if (district.getChildren() == null){
//                district.setChildren(new ArrayList<District>());
//            }
//            if(flag){
//                district.getChildren().add(district1);
//                flag = false;
//            }
//
//        }
//        return district;
//    }


}
