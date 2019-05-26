package com.hlx.cloudevaluation.mapper;

import com.hlx.cloudevaluation.model.po.UserScore;
import com.hlx.cloudevaluation.model.po.UserScoreExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int countByExample(UserScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int deleteByExample(UserScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int insert(UserScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int insertSelective(UserScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    List<UserScore> selectByExample(UserScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    UserScore selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserScore record, @Param("example") UserScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserScore record, @Param("example") UserScoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_score
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserScore record);
}