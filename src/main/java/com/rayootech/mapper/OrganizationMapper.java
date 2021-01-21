package com.rayootech.mapper;


import com.rayootech.bean.Organization;


import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);




    int insertOrganizations(List<Organization> list);

    List<Organization> getAllOrganizations();


}