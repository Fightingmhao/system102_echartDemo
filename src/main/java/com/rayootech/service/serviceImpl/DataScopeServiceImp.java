package com.rayootech.service.serviceImpl;

import com.rayootech.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataScopeServiceImp {
    @Autowired
    private UserDtoMapper userDtoMapper;

    public String getDataScope(String canHremail) {
        //1、查询数据权限  1、全部数据权限，2、部门及以下，3、个人数据权限
        String scope = userDtoMapper.getDataScope(canHremail).get(0);

        switch (scope) {
            case "1":
                return null;
            case "2":
                List<String> list = userDtoMapper.getUserDataScope(canHremail);
                String usernameList = "";
                for (int i = 0; i < list.size(); i++) {
                    usernameList += ("'" + list.get(i) + "'");
                    if (i < list.size() - 1) {
                        usernameList += ",";
                    }
                }
                return usernameList;
            default:
                return "'" + canHremail + "'";
        }
    }

    public String getDeptype(String uname) {
        return userDtoMapper.getDeptype(uname);
    }

    public String getDeptName(String uname){
        return userDtoMapper.selectDeptNameByUserName(uname);
    }

    public String getDeptypeById(Integer deptId) {
        return userDtoMapper.getDeptypeByID(deptId);
    }

    /**
     * 查找小组中人员
     * @param uName
     * @return
     */
    public String getHRByGroup(String uName){
        List<String> list = userDtoMapper.getHRByGroup(uName);
        String usernameList = "";
        for (int i = 0; i < list.size(); i++) {
            usernameList += ("'" + list.get(i) + "'");
            if (i < list.size() - 1) {
                usernameList += ",";
            }
        }
        return usernameList;
    }


    public String getHREmail(String hrEmail) {
        String hrE = "'"+hrEmail+"'";
        return hrE;
    }

}
