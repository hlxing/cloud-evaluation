package com.hlx.cloudevaluation.mapper;

import com.hlx.cloudevaluation.model.po.ClassConfigUser;
import com.hlx.cloudevaluation.model.po.ClassConfigUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassConfigUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int countByExample(ClassConfigUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int deleteByExample(ClassConfigUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int insert(ClassConfigUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int insertSelective(ClassConfigUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    List<ClassConfigUser> selectByExample(ClassConfigUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    ClassConfigUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClassConfigUser record, @Param("example") ClassConfigUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClassConfigUser record, @Param("example") ClassConfigUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClassConfigUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClassConfigUser record);
}