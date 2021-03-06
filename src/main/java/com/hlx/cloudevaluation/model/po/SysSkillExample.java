package com.hlx.cloudevaluation.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSkillExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public SysSkillExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
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
     * This method corresponds to the database table sys_skill
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
     * This method corresponds to the database table sys_skill
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_skill
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
     * This class corresponds to the database table sys_skill
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

        public Criteria andSkillIdIsNull() {
            addCriterion("skill_id is null");
            return (Criteria) this;
        }

        public Criteria andSkillIdIsNotNull() {
            addCriterion("skill_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkillIdEqualTo(Integer value) {
            addCriterion("skill_id =", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotEqualTo(Integer value) {
            addCriterion("skill_id <>", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdGreaterThan(Integer value) {
            addCriterion("skill_id >", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("skill_id >=", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdLessThan(Integer value) {
            addCriterion("skill_id <", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdLessThanOrEqualTo(Integer value) {
            addCriterion("skill_id <=", value, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdIn(List<Integer> values) {
            addCriterion("skill_id in", values, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotIn(List<Integer> values) {
            addCriterion("skill_id not in", values, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdBetween(Integer value1, Integer value2) {
            addCriterion("skill_id between", value1, value2, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("skill_id not between", value1, value2, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillNameIsNull() {
            addCriterion("skill_name is null");
            return (Criteria) this;
        }

        public Criteria andSkillNameIsNotNull() {
            addCriterion("skill_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkillNameEqualTo(String value) {
            addCriterion("skill_name =", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotEqualTo(String value) {
            addCriterion("skill_name <>", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThan(String value) {
            addCriterion("skill_name >", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThanOrEqualTo(String value) {
            addCriterion("skill_name >=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThan(String value) {
            addCriterion("skill_name <", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThanOrEqualTo(String value) {
            addCriterion("skill_name <=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLike(String value) {
            addCriterion("skill_name like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotLike(String value) {
            addCriterion("skill_name not like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameIn(List<String> values) {
            addCriterion("skill_name in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotIn(List<String> values) {
            addCriterion("skill_name not in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameBetween(String value1, String value2) {
            addCriterion("skill_name between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotBetween(String value1, String value2) {
            addCriterion("skill_name not between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorIsNull() {
            addCriterion("skill_creator is null");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorIsNotNull() {
            addCriterion("skill_creator is not null");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorEqualTo(Integer value) {
            addCriterion("skill_creator =", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorNotEqualTo(Integer value) {
            addCriterion("skill_creator <>", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorGreaterThan(Integer value) {
            addCriterion("skill_creator >", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("skill_creator >=", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorLessThan(Integer value) {
            addCriterion("skill_creator <", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("skill_creator <=", value, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorIn(List<Integer> values) {
            addCriterion("skill_creator in", values, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorNotIn(List<Integer> values) {
            addCriterion("skill_creator not in", values, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorBetween(Integer value1, Integer value2) {
            addCriterion("skill_creator between", value1, value2, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("skill_creator not between", value1, value2, "skillCreator");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtIsNull() {
            addCriterion("skill_create_at is null");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtIsNotNull() {
            addCriterion("skill_create_at is not null");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtEqualTo(Date value) {
            addCriterion("skill_create_at =", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtNotEqualTo(Date value) {
            addCriterion("skill_create_at <>", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtGreaterThan(Date value) {
            addCriterion("skill_create_at >", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("skill_create_at >=", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtLessThan(Date value) {
            addCriterion("skill_create_at <", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("skill_create_at <=", value, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtIn(List<Date> values) {
            addCriterion("skill_create_at in", values, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtNotIn(List<Date> values) {
            addCriterion("skill_create_at not in", values, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtBetween(Date value1, Date value2) {
            addCriterion("skill_create_at between", value1, value2, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("skill_create_at not between", value1, value2, "skillCreateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtIsNull() {
            addCriterion("skill_update_at is null");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtIsNotNull() {
            addCriterion("skill_update_at is not null");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtEqualTo(Date value) {
            addCriterion("skill_update_at =", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtNotEqualTo(Date value) {
            addCriterion("skill_update_at <>", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtGreaterThan(Date value) {
            addCriterion("skill_update_at >", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("skill_update_at >=", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtLessThan(Date value) {
            addCriterion("skill_update_at <", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("skill_update_at <=", value, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtIn(List<Date> values) {
            addCriterion("skill_update_at in", values, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtNotIn(List<Date> values) {
            addCriterion("skill_update_at not in", values, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtBetween(Date value1, Date value2) {
            addCriterion("skill_update_at between", value1, value2, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("skill_update_at not between", value1, value2, "skillUpdateAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtIsNull() {
            addCriterion("skill_delete_at is null");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtIsNotNull() {
            addCriterion("skill_delete_at is not null");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtEqualTo(Date value) {
            addCriterion("skill_delete_at =", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtNotEqualTo(Date value) {
            addCriterion("skill_delete_at <>", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtGreaterThan(Date value) {
            addCriterion("skill_delete_at >", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtGreaterThanOrEqualTo(Date value) {
            addCriterion("skill_delete_at >=", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtLessThan(Date value) {
            addCriterion("skill_delete_at <", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtLessThanOrEqualTo(Date value) {
            addCriterion("skill_delete_at <=", value, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtIn(List<Date> values) {
            addCriterion("skill_delete_at in", values, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtNotIn(List<Date> values) {
            addCriterion("skill_delete_at not in", values, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtBetween(Date value1, Date value2) {
            addCriterion("skill_delete_at between", value1, value2, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillDeleteAtNotBetween(Date value1, Date value2) {
            addCriterion("skill_delete_at not between", value1, value2, "skillDeleteAt");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIsNull() {
            addCriterion("skill_type is null");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIsNotNull() {
            addCriterion("skill_type is not null");
            return (Criteria) this;
        }

        public Criteria andSkillTypeEqualTo(String value) {
            addCriterion("skill_type =", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotEqualTo(String value) {
            addCriterion("skill_type <>", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeGreaterThan(String value) {
            addCriterion("skill_type >", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("skill_type >=", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLessThan(String value) {
            addCriterion("skill_type <", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLessThanOrEqualTo(String value) {
            addCriterion("skill_type <=", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLike(String value) {
            addCriterion("skill_type like", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotLike(String value) {
            addCriterion("skill_type not like", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIn(List<String> values) {
            addCriterion("skill_type in", values, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotIn(List<String> values) {
            addCriterion("skill_type not in", values, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeBetween(String value1, String value2) {
            addCriterion("skill_type between", value1, value2, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotBetween(String value1, String value2) {
            addCriterion("skill_type not between", value1, value2, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameIsNull() {
            addCriterion("skill_short_name is null");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameIsNotNull() {
            addCriterion("skill_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameEqualTo(String value) {
            addCriterion("skill_short_name =", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameNotEqualTo(String value) {
            addCriterion("skill_short_name <>", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameGreaterThan(String value) {
            addCriterion("skill_short_name >", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("skill_short_name >=", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameLessThan(String value) {
            addCriterion("skill_short_name <", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameLessThanOrEqualTo(String value) {
            addCriterion("skill_short_name <=", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameLike(String value) {
            addCriterion("skill_short_name like", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameNotLike(String value) {
            addCriterion("skill_short_name not like", value, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameIn(List<String> values) {
            addCriterion("skill_short_name in", values, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameNotIn(List<String> values) {
            addCriterion("skill_short_name not in", values, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameBetween(String value1, String value2) {
            addCriterion("skill_short_name between", value1, value2, "skillShortName");
            return (Criteria) this;
        }

        public Criteria andSkillShortNameNotBetween(String value1, String value2) {
            addCriterion("skill_short_name not between", value1, value2, "skillShortName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_skill
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
     * This class corresponds to the database table sys_skill
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