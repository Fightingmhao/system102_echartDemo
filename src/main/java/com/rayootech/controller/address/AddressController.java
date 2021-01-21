package com.rayootech.controller.address;

import com.rayootech.bean.District;
import com.rayootech.resultInfo.ResponseVo;
import com.rayootech.service.IDistrictService;
import com.rayootech.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by FightingHao on 2020/12/15
 */

@RestController
@RequestMapping("address")
public class AddressController {



    @Autowired
    private IOrganizationService organizationService;

    @Autowired
    private IDistrictService districtService;

//    /**
//     * 获取地址下拉树列表
//     */
//    @GetMapping("/treeselect")
//    public ResponseVo<Object> treeselect(District district)
//    {
//        List<District> districts = districtService.selectDistrictList(district);
//        List<TreeSelect02> list = districtService.buildDistrictTreeSelect(districts);
//        return ResponseVo.success(list);
//    }



    /**
     * 获取地址列表
     */
    @GetMapping("/list")
    public ResponseVo<Object> list(District district)
    {
        List<District> districts = districtService.selectDistrictList(district);
        return ResponseVo.success(districts);
    }
}
