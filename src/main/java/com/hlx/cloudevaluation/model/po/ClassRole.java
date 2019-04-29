package com.hlx.cloudevaluation.model.po;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table class_role
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ClassRole {
    /**
     * Database Column Remarks:
     * 用户角色表
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_role.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     * 用户id
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_role.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     * 角色名
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_role.role_name
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * Database Column Remarks:
     * 用户角色所在班级
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_role.class_id
     *
     * @mbggenerated
     */
    private Integer classId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_role.id
     *
     * @return the value of class_role.id
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_role.id
     *
     * @param id the value for class_role.id
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_role.user_id
     *
     * @return the value of class_role.user_id
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_role.user_id
     *
     * @param userId the value for class_role.user_id
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_role.role_name
     *
     * @return the value of class_role.role_name
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_role.role_name
     *
     * @param roleName the value for class_role.role_name
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_role.class_id
     *
     * @return the value of class_role.class_id
     * @mbggenerated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_role.class_id
     *
     * @param classId the value for class_role.class_id
     * @mbggenerated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}