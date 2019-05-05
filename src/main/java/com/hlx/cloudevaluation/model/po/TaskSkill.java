package com.hlx.cloudevaluation.model.po;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table task_skill
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class TaskSkill {
    /**
     * Database Column Remarks:
     * 作业中维度表
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_skill.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     * 作业id
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_skill.task_id
     *
     * @mbggenerated
     */
    private Integer taskId;

    /**
     * Database Column Remarks:
     * 能力id
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_skill.skill_id
     *
     * @mbggenerated
     */
    private Integer skillId;

    /**
     * Database Column Remarks:
     * 维度满分
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_skill.skill_number
     *
     * @mbggenerated
     */
    private Double skillNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_skill.id
     *
     * @return the value of task_skill.id
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_skill.id
     *
     * @param id the value for task_skill.id
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_skill.task_id
     *
     * @return the value of task_skill.task_id
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_skill.task_id
     *
     * @param taskId the value for task_skill.task_id
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_skill.skill_id
     *
     * @return the value of task_skill.skill_id
     * @mbggenerated
     */
    public Integer getSkillId() {
        return skillId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_skill.skill_id
     *
     * @param skillId the value for task_skill.skill_id
     * @mbggenerated
     */
    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_skill.skill_number
     *
     * @return the value of task_skill.skill_number
     * @mbggenerated
     */
    public Double getSkillNumber() {
        return skillNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_skill.skill_number
     *
     * @param skillNumber the value for task_skill.skill_number
     * @mbggenerated
     */
    public void setSkillNumber(Double skillNumber) {
        this.skillNumber = skillNumber;
    }
}