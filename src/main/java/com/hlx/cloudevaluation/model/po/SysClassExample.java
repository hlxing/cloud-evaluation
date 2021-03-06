package com.hlx.cloudevaluation.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysClassExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public SysClassExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenIsNull() {
            addCriterion("class_stu_token is null");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenIsNotNull() {
            addCriterion("class_stu_token is not null");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenEqualTo(String value) {
            addCriterion("class_stu_token =", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenNotEqualTo(String value) {
            addCriterion("class_stu_token <>", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenGreaterThan(String value) {
            addCriterion("class_stu_token >", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenGreaterThanOrEqualTo(String value) {
            addCriterion("class_stu_token >=", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenLessThan(String value) {
            addCriterion("class_stu_token <", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenLessThanOrEqualTo(String value) {
            addCriterion("class_stu_token <=", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenLike(String value) {
            addCriterion("class_stu_token like", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenNotLike(String value) {
            addCriterion("class_stu_token not like", value, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenIn(List<String> values) {
            addCriterion("class_stu_token in", values, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenNotIn(List<String> values) {
            addCriterion("class_stu_token not in", values, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenBetween(String value1, String value2) {
            addCriterion("class_stu_token between", value1, value2, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassStuTokenNotBetween(String value1, String value2) {
            addCriterion("class_stu_token not between", value1, value2, "classStuToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenIsNull() {
            addCriterion("class_assistant_token is null");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenIsNotNull() {
            addCriterion("class_assistant_token is not null");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenEqualTo(String value) {
            addCriterion("class_assistant_token =", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenNotEqualTo(String value) {
            addCriterion("class_assistant_token <>", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenGreaterThan(String value) {
            addCriterion("class_assistant_token >", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenGreaterThanOrEqualTo(String value) {
            addCriterion("class_assistant_token >=", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenLessThan(String value) {
            addCriterion("class_assistant_token <", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenLessThanOrEqualTo(String value) {
            addCriterion("class_assistant_token <=", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenLike(String value) {
            addCriterion("class_assistant_token like", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenNotLike(String value) {
            addCriterion("class_assistant_token not like", value, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenIn(List<String> values) {
            addCriterion("class_assistant_token in", values, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenNotIn(List<String> values) {
            addCriterion("class_assistant_token not in", values, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenBetween(String value1, String value2) {
            addCriterion("class_assistant_token between", value1, value2, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassAssistantTokenNotBetween(String value1, String value2) {
            addCriterion("class_assistant_token not between", value1, value2, "classAssistantToken");
            return (Criteria) this;
        }

        public Criteria andClassCreatorIsNull() {
            addCriterion("class_creator is null");
            return (Criteria) this;
        }

        public Criteria andClassCreatorIsNotNull() {
            addCriterion("class_creator is not null");
            return (Criteria) this;
        }

        public Criteria andClassCreatorEqualTo(Integer value) {
            addCriterion("class_creator =", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorNotEqualTo(Integer value) {
            addCriterion("class_creator <>", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorGreaterThan(Integer value) {
            addCriterion("class_creator >", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_creator >=", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorLessThan(Integer value) {
            addCriterion("class_creator <", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("class_creator <=", value, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorIn(List<Integer> values) {
            addCriterion("class_creator in", values, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorNotIn(List<Integer> values) {
            addCriterion("class_creator not in", values, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorBetween(Integer value1, Integer value2) {
            addCriterion("class_creator between", value1, value2, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("class_creator not between", value1, value2, "classCreator");
            return (Criteria) this;
        }

        public Criteria andClassExistIsNull() {
            addCriterion("class_exist is null");
            return (Criteria) this;
        }

        public Criteria andClassExistIsNotNull() {
            addCriterion("class_exist is not null");
            return (Criteria) this;
        }

        public Criteria andClassExistEqualTo(Boolean value) {
            addCriterion("class_exist =", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistNotEqualTo(Boolean value) {
            addCriterion("class_exist <>", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistGreaterThan(Boolean value) {
            addCriterion("class_exist >", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("class_exist >=", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistLessThan(Boolean value) {
            addCriterion("class_exist <", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistLessThanOrEqualTo(Boolean value) {
            addCriterion("class_exist <=", value, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistIn(List<Boolean> values) {
            addCriterion("class_exist in", values, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistNotIn(List<Boolean> values) {
            addCriterion("class_exist not in", values, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistBetween(Boolean value1, Boolean value2) {
            addCriterion("class_exist between", value1, value2, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassExistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("class_exist not between", value1, value2, "classExist");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtIsNull() {
            addCriterion("class_create_at is null");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtIsNotNull() {
            addCriterion("class_create_at is not null");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtEqualTo(Date value) {
            addCriterion("class_create_at =", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtNotEqualTo(Date value) {
            addCriterion("class_create_at <>", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtGreaterThan(Date value) {
            addCriterion("class_create_at >", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("class_create_at >=", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtLessThan(Date value) {
            addCriterion("class_create_at <", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("class_create_at <=", value, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtIn(List<Date> values) {
            addCriterion("class_create_at in", values, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtNotIn(List<Date> values) {
            addCriterion("class_create_at not in", values, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtBetween(Date value1, Date value2) {
            addCriterion("class_create_at between", value1, value2, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("class_create_at not between", value1, value2, "classCreateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtIsNull() {
            addCriterion("class_update_at is null");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtIsNotNull() {
            addCriterion("class_update_at is not null");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtEqualTo(Date value) {
            addCriterion("class_update_at =", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtNotEqualTo(Date value) {
            addCriterion("class_update_at <>", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtGreaterThan(Date value) {
            addCriterion("class_update_at >", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("class_update_at >=", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtLessThan(Date value) {
            addCriterion("class_update_at <", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("class_update_at <=", value, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtIn(List<Date> values) {
            addCriterion("class_update_at in", values, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtNotIn(List<Date> values) {
            addCriterion("class_update_at not in", values, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtBetween(Date value1, Date value2) {
            addCriterion("class_update_at between", value1, value2, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("class_update_at not between", value1, value2, "classUpdateAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtIsNull() {
            addCriterion("class_delete_at is null");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtIsNotNull() {
            addCriterion("class_delete_at is not null");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtEqualTo(Date value) {
            addCriterion("class_delete_at =", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtNotEqualTo(Date value) {
            addCriterion("class_delete_at <>", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtGreaterThan(Date value) {
            addCriterion("class_delete_at >", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtGreaterThanOrEqualTo(Date value) {
            addCriterion("class_delete_at >=", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtLessThan(Date value) {
            addCriterion("class_delete_at <", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtLessThanOrEqualTo(Date value) {
            addCriterion("class_delete_at <=", value, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtIn(List<Date> values) {
            addCriterion("class_delete_at in", values, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtNotIn(List<Date> values) {
            addCriterion("class_delete_at not in", values, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtBetween(Date value1, Date value2) {
            addCriterion("class_delete_at between", value1, value2, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassDeleteAtNotBetween(Date value1, Date value2) {
            addCriterion("class_delete_at not between", value1, value2, "classDeleteAt");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditIsNull() {
            addCriterion("class_team_edit is null");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditIsNotNull() {
            addCriterion("class_team_edit is not null");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditEqualTo(Boolean value) {
            addCriterion("class_team_edit =", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditNotEqualTo(Boolean value) {
            addCriterion("class_team_edit <>", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditGreaterThan(Boolean value) {
            addCriterion("class_team_edit >", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("class_team_edit >=", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditLessThan(Boolean value) {
            addCriterion("class_team_edit <", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditLessThanOrEqualTo(Boolean value) {
            addCriterion("class_team_edit <=", value, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditIn(List<Boolean> values) {
            addCriterion("class_team_edit in", values, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditNotIn(List<Boolean> values) {
            addCriterion("class_team_edit not in", values, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditBetween(Boolean value1, Boolean value2) {
            addCriterion("class_team_edit between", value1, value2, "classTeamEdit");
            return (Criteria) this;
        }

        public Criteria andClassTeamEditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("class_team_edit not between", value1, value2, "classTeamEdit");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_class
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_class
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}