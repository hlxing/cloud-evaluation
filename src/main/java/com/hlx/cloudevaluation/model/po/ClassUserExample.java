package com.hlx.cloudevaluation.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassUserExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_user
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_user
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class_user
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public ClassUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
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
     * This method corresponds to the database table class_user
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
     * This method corresponds to the database table class_user
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_user
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
     * This class corresponds to the database table class_user
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtIsNull() {
            addCriterion("cu_create_at is null");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtIsNotNull() {
            addCriterion("cu_create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtEqualTo(Date value) {
            addCriterion("cu_create_at =", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtNotEqualTo(Date value) {
            addCriterion("cu_create_at <>", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtGreaterThan(Date value) {
            addCriterion("cu_create_at >", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("cu_create_at >=", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtLessThan(Date value) {
            addCriterion("cu_create_at <", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("cu_create_at <=", value, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtIn(List<Date> values) {
            addCriterion("cu_create_at in", values, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtNotIn(List<Date> values) {
            addCriterion("cu_create_at not in", values, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtBetween(Date value1, Date value2) {
            addCriterion("cu_create_at between", value1, value2, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("cu_create_at not between", value1, value2, "cuCreateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtIsNull() {
            addCriterion("cu_update_at is null");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtIsNotNull() {
            addCriterion("cu_update_at is not null");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtEqualTo(Date value) {
            addCriterion("cu_update_at =", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtNotEqualTo(Date value) {
            addCriterion("cu_update_at <>", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtGreaterThan(Date value) {
            addCriterion("cu_update_at >", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("cu_update_at >=", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtLessThan(Date value) {
            addCriterion("cu_update_at <", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("cu_update_at <=", value, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtIn(List<Date> values) {
            addCriterion("cu_update_at in", values, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtNotIn(List<Date> values) {
            addCriterion("cu_update_at not in", values, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtBetween(Date value1, Date value2) {
            addCriterion("cu_update_at between", value1, value2, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("cu_update_at not between", value1, value2, "cuUpdateAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtIsNull() {
            addCriterion("cu_delete_at is null");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtIsNotNull() {
            addCriterion("cu_delete_at is not null");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtEqualTo(Date value) {
            addCriterion("cu_delete_at =", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtNotEqualTo(Date value) {
            addCriterion("cu_delete_at <>", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtGreaterThan(Date value) {
            addCriterion("cu_delete_at >", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtGreaterThanOrEqualTo(Date value) {
            addCriterion("cu_delete_at >=", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtLessThan(Date value) {
            addCriterion("cu_delete_at <", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtLessThanOrEqualTo(Date value) {
            addCriterion("cu_delete_at <=", value, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtIn(List<Date> values) {
            addCriterion("cu_delete_at in", values, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtNotIn(List<Date> values) {
            addCriterion("cu_delete_at not in", values, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtBetween(Date value1, Date value2) {
            addCriterion("cu_delete_at between", value1, value2, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuDeleteAtNotBetween(Date value1, Date value2) {
            addCriterion("cu_delete_at not between", value1, value2, "cuDeleteAt");
            return (Criteria) this;
        }

        public Criteria andCuGithubIsNull() {
            addCriterion("cu_github is null");
            return (Criteria) this;
        }

        public Criteria andCuGithubIsNotNull() {
            addCriterion("cu_github is not null");
            return (Criteria) this;
        }

        public Criteria andCuGithubEqualTo(String value) {
            addCriterion("cu_github =", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubNotEqualTo(String value) {
            addCriterion("cu_github <>", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubGreaterThan(String value) {
            addCriterion("cu_github >", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubGreaterThanOrEqualTo(String value) {
            addCriterion("cu_github >=", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubLessThan(String value) {
            addCriterion("cu_github <", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubLessThanOrEqualTo(String value) {
            addCriterion("cu_github <=", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubLike(String value) {
            addCriterion("cu_github like", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubNotLike(String value) {
            addCriterion("cu_github not like", value, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubIn(List<String> values) {
            addCriterion("cu_github in", values, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubNotIn(List<String> values) {
            addCriterion("cu_github not in", values, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubBetween(String value1, String value2) {
            addCriterion("cu_github between", value1, value2, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuGithubNotBetween(String value1, String value2) {
            addCriterion("cu_github not between", value1, value2, "cuGithub");
            return (Criteria) this;
        }

        public Criteria andCuBlogIsNull() {
            addCriterion("cu_blog is null");
            return (Criteria) this;
        }

        public Criteria andCuBlogIsNotNull() {
            addCriterion("cu_blog is not null");
            return (Criteria) this;
        }

        public Criteria andCuBlogEqualTo(String value) {
            addCriterion("cu_blog =", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogNotEqualTo(String value) {
            addCriterion("cu_blog <>", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogGreaterThan(String value) {
            addCriterion("cu_blog >", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogGreaterThanOrEqualTo(String value) {
            addCriterion("cu_blog >=", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogLessThan(String value) {
            addCriterion("cu_blog <", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogLessThanOrEqualTo(String value) {
            addCriterion("cu_blog <=", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogLike(String value) {
            addCriterion("cu_blog like", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogNotLike(String value) {
            addCriterion("cu_blog not like", value, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogIn(List<String> values) {
            addCriterion("cu_blog in", values, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogNotIn(List<String> values) {
            addCriterion("cu_blog not in", values, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogBetween(String value1, String value2) {
            addCriterion("cu_blog between", value1, value2, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuBlogNotBetween(String value1, String value2) {
            addCriterion("cu_blog not between", value1, value2, "cuBlog");
            return (Criteria) this;
        }

        public Criteria andCuEmailIsNull() {
            addCriterion("cu_email is null");
            return (Criteria) this;
        }

        public Criteria andCuEmailIsNotNull() {
            addCriterion("cu_email is not null");
            return (Criteria) this;
        }

        public Criteria andCuEmailEqualTo(String value) {
            addCriterion("cu_email =", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailNotEqualTo(String value) {
            addCriterion("cu_email <>", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailGreaterThan(String value) {
            addCriterion("cu_email >", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cu_email >=", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailLessThan(String value) {
            addCriterion("cu_email <", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailLessThanOrEqualTo(String value) {
            addCriterion("cu_email <=", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailLike(String value) {
            addCriterion("cu_email like", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailNotLike(String value) {
            addCriterion("cu_email not like", value, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailIn(List<String> values) {
            addCriterion("cu_email in", values, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailNotIn(List<String> values) {
            addCriterion("cu_email not in", values, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailBetween(String value1, String value2) {
            addCriterion("cu_email between", value1, value2, "cuEmail");
            return (Criteria) this;
        }

        public Criteria andCuEmailNotBetween(String value1, String value2) {
            addCriterion("cu_email not between", value1, value2, "cuEmail");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class_user
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
     * This class corresponds to the database table class_user
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