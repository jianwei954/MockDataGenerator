package com.jw.mockdata.generator.dto.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDbInsdateIsNull() {
            addCriterion("DB_INSDATE is null");
            return (Criteria) this;
        }

        public Criteria andDbInsdateIsNotNull() {
            addCriterion("DB_INSDATE is not null");
            return (Criteria) this;
        }

        public Criteria andDbInsdateEqualTo(Date value) {
            addCriterionForJDBCDate("DB_INSDATE =", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DB_INSDATE <>", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateGreaterThan(Date value) {
            addCriterionForJDBCDate("DB_INSDATE >", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DB_INSDATE >=", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateLessThan(Date value) {
            addCriterionForJDBCDate("DB_INSDATE <", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DB_INSDATE <=", value, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateIn(List<Date> values) {
            addCriterionForJDBCDate("DB_INSDATE in", values, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DB_INSDATE not in", values, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DB_INSDATE between", value1, value2, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andDbInsdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DB_INSDATE not between", value1, value2, "dbInsdate");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNull() {
            addCriterion("LOGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLogtypeIsNotNull() {
            addCriterion("LOGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLogtypeEqualTo(BigDecimal value) {
            addCriterion("LOGTYPE =", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotEqualTo(BigDecimal value) {
            addCriterion("LOGTYPE <>", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThan(BigDecimal value) {
            addCriterion("LOGTYPE >", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGTYPE >=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThan(BigDecimal value) {
            addCriterion("LOGTYPE <", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGTYPE <=", value, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeIn(List<BigDecimal> values) {
            addCriterion("LOGTYPE in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotIn(List<BigDecimal> values) {
            addCriterion("LOGTYPE not in", values, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGTYPE between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andLogtypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGTYPE not between", value1, value2, "logtype");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andUseripIsNull() {
            addCriterion("USERIP is null");
            return (Criteria) this;
        }

        public Criteria andUseripIsNotNull() {
            addCriterion("USERIP is not null");
            return (Criteria) this;
        }

        public Criteria andUseripEqualTo(String value) {
            addCriterion("USERIP =", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotEqualTo(String value) {
            addCriterion("USERIP <>", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThan(String value) {
            addCriterion("USERIP >", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThanOrEqualTo(String value) {
            addCriterion("USERIP >=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThan(String value) {
            addCriterion("USERIP <", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThanOrEqualTo(String value) {
            addCriterion("USERIP <=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLike(String value) {
            addCriterion("USERIP like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotLike(String value) {
            addCriterion("USERIP not like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripIn(List<String> values) {
            addCriterion("USERIP in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotIn(List<String> values) {
            addCriterion("USERIP not in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripBetween(String value1, String value2) {
            addCriterion("USERIP between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotBetween(String value1, String value2) {
            addCriterion("USERIP not between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andQuerydurationIsNull() {
            addCriterion("QUERYDURATION is null");
            return (Criteria) this;
        }

        public Criteria andQuerydurationIsNotNull() {
            addCriterion("QUERYDURATION is not null");
            return (Criteria) this;
        }

        public Criteria andQuerydurationEqualTo(BigDecimal value) {
            addCriterion("QUERYDURATION =", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationNotEqualTo(BigDecimal value) {
            addCriterion("QUERYDURATION <>", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationGreaterThan(BigDecimal value) {
            addCriterion("QUERYDURATION >", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUERYDURATION >=", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationLessThan(BigDecimal value) {
            addCriterion("QUERYDURATION <", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUERYDURATION <=", value, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationIn(List<BigDecimal> values) {
            addCriterion("QUERYDURATION in", values, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationNotIn(List<BigDecimal> values) {
            addCriterion("QUERYDURATION not in", values, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUERYDURATION between", value1, value2, "queryduration");
            return (Criteria) this;
        }

        public Criteria andQuerydurationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUERYDURATION not between", value1, value2, "queryduration");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("KEY is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("KEY is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("KEY =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("KEY <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("KEY >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("KEY >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("KEY <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("KEY <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("KEY like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("KEY not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("KEY in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("KEY not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("KEY between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("KEY not between", value1, value2, "key");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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