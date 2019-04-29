package com.hlx.cloudevaluation.mapper;

import com.hlx.cloudevaluation.model.po.SysSkill;
import com.hlx.cloudevaluation.model.po.SysSkillExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysSkillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int countByExample(SysSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int deleteByExample(SysSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer skillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int insert(SysSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int insertSelective(SysSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    List<SysSkill> selectByExample(SysSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    SysSkill selectByPrimaryKey(Integer skillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSkill record, @Param("example") SysSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSkill record, @Param("example") SysSkillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSkill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSkill record);
}