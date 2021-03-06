package com.hlx.cloudevaluation.model.po;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table team_score
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class TeamScore {
    /**
     * Database Column Remarks:
     *   团队得分表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_score.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   作业id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_score.task_id
     *
     * @mbggenerated
     */
    private Integer taskId;

    /**
     * Database Column Remarks:
     *   团队id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_score.team_id
     *
     * @mbggenerated
     */
    private Integer teamId;

    /**
     * Database Column Remarks:
     *   团队当次作业得分
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_score.team_score
     *
     * @mbggenerated
     */
    private Double teamScore;

    /**
     * Database Column Remarks:
     *   平均贡献度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column team_score.average_contribute
     *
     * @mbggenerated
     */
    private Double averageContribute;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_score.id
     *
     * @return the value of team_score.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_score.id
     *
     * @param id the value for team_score.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_score.task_id
     *
     * @return the value of team_score.task_id
     *
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_score.task_id
     *
     * @param taskId the value for team_score.task_id
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_score.team_id
     *
     * @return the value of team_score.team_id
     *
     * @mbggenerated
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_score.team_id
     *
     * @param teamId the value for team_score.team_id
     *
     * @mbggenerated
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_score.team_score
     *
     * @return the value of team_score.team_score
     *
     * @mbggenerated
     */
    public Double getTeamScore() {
        return teamScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_score.team_score
     *
     * @param teamScore the value for team_score.team_score
     *
     * @mbggenerated
     */
    public void setTeamScore(Double teamScore) {
        this.teamScore = teamScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column team_score.average_contribute
     *
     * @return the value of team_score.average_contribute
     * @mbggenerated
     */
    public Double getAverageContribute() {
        return averageContribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column team_score.average_contribute
     *
     * @param averageContribute the value for team_score.average_contribute
     * @mbggenerated
     */
    public void setAverageContribute(Double averageContribute) {
        this.averageContribute = averageContribute;
    }
}