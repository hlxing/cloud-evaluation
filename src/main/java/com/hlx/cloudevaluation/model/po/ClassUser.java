package com.hlx.cloudevaluation.model.po;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table class_user
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ClassUser {
    /**
     * Database Column Remarks:
     *   班级用户表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   班级id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.class_id
     *
     * @mbggenerated
     */
    private Integer classId;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   加入班级时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_create_at
     *
     * @mbggenerated
     */
    private Date cuCreateAt;

    /**
     * Database Column Remarks:
     *   更换时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_update_at
     *
     * @mbggenerated
     */
    private Date cuUpdateAt;

    /**
     * Database Column Remarks:
     *   退出班级时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_delete_at
     *
     * @mbggenerated
     */
    private Date cuDeleteAt;

    /**
     * Database Column Remarks:
     * github地址
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_github
     *
     * @mbggenerated
     */
    private String cuGithub;

    /**
     * Database Column Remarks:
     * blog地址
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_blog
     *
     * @mbggenerated
     */
    private String cuBlog;

    /**
     * Database Column Remarks:
     * 邮箱地址
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class_user.cu_email
     *
     * @mbggenerated
     */
    private String cuEmail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.id
     *
     * @return the value of class_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.id
     *
     * @param id the value for class_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.class_id
     *
     * @return the value of class_user.class_id
     *
     * @mbggenerated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.class_id
     *
     * @param classId the value for class_user.class_id
     *
     * @mbggenerated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.user_id
     *
     * @return the value of class_user.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.user_id
     *
     * @param userId the value for class_user.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_create_at
     *
     * @return the value of class_user.cu_create_at
     *
     * @mbggenerated
     */
    public Date getCuCreateAt() {
        return cuCreateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_create_at
     *
     * @param cuCreateAt the value for class_user.cu_create_at
     *
     * @mbggenerated
     */
    public void setCuCreateAt(Date cuCreateAt) {
        this.cuCreateAt = cuCreateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_update_at
     *
     * @return the value of class_user.cu_update_at
     *
     * @mbggenerated
     */
    public Date getCuUpdateAt() {
        return cuUpdateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_update_at
     *
     * @param cuUpdateAt the value for class_user.cu_update_at
     *
     * @mbggenerated
     */
    public void setCuUpdateAt(Date cuUpdateAt) {
        this.cuUpdateAt = cuUpdateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_delete_at
     *
     * @return the value of class_user.cu_delete_at
     *
     * @mbggenerated
     */
    public Date getCuDeleteAt() {
        return cuDeleteAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_delete_at
     *
     * @param cuDeleteAt the value for class_user.cu_delete_at
     *
     * @mbggenerated
     */
    public void setCuDeleteAt(Date cuDeleteAt) {
        this.cuDeleteAt = cuDeleteAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_github
     *
     * @return the value of class_user.cu_github
     * @mbggenerated
     */
    public String getCuGithub() {
        return cuGithub;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_github
     *
     * @param cuGithub the value for class_user.cu_github
     * @mbggenerated
     */
    public void setCuGithub(String cuGithub) {
        this.cuGithub = cuGithub == null ? null : cuGithub.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_blog
     *
     * @return the value of class_user.cu_blog
     * @mbggenerated
     */
    public String getCuBlog() {
        return cuBlog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_blog
     *
     * @param cuBlog the value for class_user.cu_blog
     * @mbggenerated
     */
    public void setCuBlog(String cuBlog) {
        this.cuBlog = cuBlog == null ? null : cuBlog.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class_user.cu_email
     *
     * @return the value of class_user.cu_email
     * @mbggenerated
     */
    public String getCuEmail() {
        return cuEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class_user.cu_email
     *
     * @param cuEmail the value for class_user.cu_email
     * @mbggenerated
     */
    public void setCuEmail(String cuEmail) {
        this.cuEmail = cuEmail == null ? null : cuEmail.trim();
    }
}