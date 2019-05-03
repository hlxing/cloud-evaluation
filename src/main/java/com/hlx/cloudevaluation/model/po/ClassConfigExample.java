package com.hlx.cloudevaluation.model.po;

import java.util.ArrayList;
import java.util.List;

public class ClassConfigExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_config
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_config
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_config
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public ClassConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
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
     * This method corresponds to the database table class_config
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
     * This method corresponds to the database table class_config
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_config
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
     * This class corresponds to the database table class_config
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

        public Criteria andClassConfigIdIsNull() {
            addCriterion("class_config_id is null");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdIsNotNull() {
            addCriterion("class_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdEqualTo(Integer value) {
            addCriterion("class_config_id =", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdNotEqualTo(Integer value) {
            addCriterion("class_config_id <>", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdGreaterThan(Integer value) {
            addCriterion("class_config_id >", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_config_id >=", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdLessThan(Integer value) {
            addCriterion("class_config_id <", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_config_id <=", value, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdIn(List<Integer> values) {
            addCriterion("class_config_id in", values, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdNotIn(List<Integer> values) {
            addCriterion("class_config_id not in", values, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("class_config_id between", value1, value2, "classConfigId");
            return (Criteria) this;
        }

        public Criteria andClassConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_config_id not between", value1, value2, "classConfigId");
            return (Criteria) this;
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

        public Criteria andClassConfigNameIsNull() {
            addCriterion("class_config_name is null");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameIsNotNull() {
            addCriterion("class_config_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameEqualTo(String value) {
            addCriterion("class_config_name =", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameNotEqualTo(String value) {
            addCriterion("class_config_name <>", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameGreaterThan(String value) {
            addCriterion("class_config_name >", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_config_name >=", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameLessThan(String value) {
            addCriterion("class_config_name <", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameLessThanOrEqualTo(String value) {
            addCriterion("class_config_name <=", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameLike(String value) {
            addCriterion("class_config_name like", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameNotLike(String value) {
            addCriterion("class_config_name not like", value, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameIn(List<String> values) {
            addCriterion("class_config_name in", values, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameNotIn(List<String> values) {
            addCriterion("class_config_name not in", values, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameBetween(String value1, String value2) {
            addCriterion("class_config_name between", value1, value2, "classConfigName");
            return (Criteria) this;
        }

        public Criteria andClassConfigNameNotBetween(String value1, String value2) {
            addCriterion("class_config_name not between", value1, value2, "classConfigName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class_config
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
     * This class corresponds to the database table class_config
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