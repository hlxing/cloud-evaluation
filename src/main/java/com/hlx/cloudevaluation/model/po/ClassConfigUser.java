package com.hlx.cloudevaluation.model.po;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table class_config_user
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ClassConfigUser {
    /**
     * Database Column Remarks:
     * 主键
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_config_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     * 班级d
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_config_user.class_id
     *
     * @mbggenerated
     */
    private Integer classId;

    /**
     * Database Column Remarks:
     * 用户id
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_config_user.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     * 配置名称
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_config_user.config_name
     *
     * @mbggenerated
     */
    private String configName;

    /**
     * Database Column Remarks:
     * 配置值
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_config_user.config_value
     *
     * @mbggenerated
     */
    private String configValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_config_user.id
     *
     * @return the value of class_config_user.id
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_config_user.id
     *
     * @param id the value for class_config_user.id
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_config_user.class_id
     *
     * @return the value of class_config_user.class_id
     * @mbggenerated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_config_user.class_id
     *
     * @param classId the value for class_config_user.class_id
     * @mbggenerated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_config_user.user_id
     *
     * @return the value of class_config_user.user_id
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_config_user.user_id
     *
     * @param userId the value for class_config_user.user_id
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_config_user.config_name
     *
     * @return the value of class_config_user.config_name
     * @mbggenerated
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_config_user.config_name
     *
     * @param configName the value for class_config_user.config_name
     * @mbggenerated
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_config_user.config_value
     *
     * @return the value of class_config_user.config_value
     * @mbggenerated
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_config_user.config_value
     *
     * @param configValue the value for class_config_user.config_value
     * @mbggenerated
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }
}