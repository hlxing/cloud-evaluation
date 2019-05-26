package com.hlx.cloudevaluation.mapper;

import com.hlx.cloudevaluation.model.po.SkillScore;
import com.hlx.cloudevaluation.model.po.SkillScoreExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SkillScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int countByExample(SkillScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int deleteByExample(SkillScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int insert(SkillScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int insertSelective(SkillScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    List<SkillScore> selectByExample(SkillScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    SkillScore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SkillScore record, @Param("example") SkillScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SkillScore record, @Param("example") SkillScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SkillScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skill_score
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SkillScore record);
}