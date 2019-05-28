package com.jw.mockdata.generator.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSysLogExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Long value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Long value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Long value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Long value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Long value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Long value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Long> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Long> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Long value1, Long value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Long value1, Long value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFCtimeIsNull() {
            addCriterion("f_ctime is null");
            return (Criteria) this;
        }

        public Criteria andFCtimeIsNotNull() {
            addCriterion("f_ctime is not null");
            return (Criteria) this;
        }

        public Criteria andFCtimeEqualTo(Date value) {
            addCriterion("f_ctime =", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeNotEqualTo(Date value) {
            addCriterion("f_ctime <>", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeGreaterThan(Date value) {
            addCriterion("f_ctime >", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_ctime >=", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeLessThan(Date value) {
            addCriterion("f_ctime <", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeLessThanOrEqualTo(Date value) {
            addCriterion("f_ctime <=", value, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeIn(List<Date> values) {
            addCriterion("f_ctime in", values, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeNotIn(List<Date> values) {
            addCriterion("f_ctime not in", values, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeBetween(Date value1, Date value2) {
            addCriterion("f_ctime between", value1, value2, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFCtimeNotBetween(Date value1, Date value2) {
            addCriterion("f_ctime not between", value1, value2, "fCtime");
            return (Criteria) this;
        }

        public Criteria andFLoginnameIsNull() {
            addCriterion("f_loginname is null");
            return (Criteria) this;
        }

        public Criteria andFLoginnameIsNotNull() {
            addCriterion("f_loginname is not null");
            return (Criteria) this;
        }

        public Criteria andFLoginnameEqualTo(String value) {
            addCriterion("f_loginname =", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameNotEqualTo(String value) {
            addCriterion("f_loginname <>", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameGreaterThan(String value) {
            addCriterion("f_loginname >", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("f_loginname >=", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameLessThan(String value) {
            addCriterion("f_loginname <", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameLessThanOrEqualTo(String value) {
            addCriterion("f_loginname <=", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameLike(String value) {
            addCriterion("f_loginname like", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameNotLike(String value) {
            addCriterion("f_loginname not like", value, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameIn(List<String> values) {
            addCriterion("f_loginname in", values, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameNotIn(List<String> values) {
            addCriterion("f_loginname not in", values, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameBetween(String value1, String value2) {
            addCriterion("f_loginname between", value1, value2, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLoginnameNotBetween(String value1, String value2) {
            addCriterion("f_loginname not between", value1, value2, "fLoginname");
            return (Criteria) this;
        }

        public Criteria andFLogtypeIsNull() {
            addCriterion("f_logtype is null");
            return (Criteria) this;
        }

        public Criteria andFLogtypeIsNotNull() {
            addCriterion("f_logtype is not null");
            return (Criteria) this;
        }

        public Criteria andFLogtypeEqualTo(Integer value) {
            addCriterion("f_logtype =", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeNotEqualTo(Integer value) {
            addCriterion("f_logtype <>", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeGreaterThan(Integer value) {
            addCriterion("f_logtype >", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_logtype >=", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeLessThan(Integer value) {
            addCriterion("f_logtype <", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeLessThanOrEqualTo(Integer value) {
            addCriterion("f_logtype <=", value, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeIn(List<Integer> values) {
            addCriterion("f_logtype in", values, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeNotIn(List<Integer> values) {
            addCriterion("f_logtype not in", values, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeBetween(Integer value1, Integer value2) {
            addCriterion("f_logtype between", value1, value2, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFLogtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("f_logtype not between", value1, value2, "fLogtype");
            return (Criteria) this;
        }

        public Criteria andFContentIsNull() {
            addCriterion("f_content is null");
            return (Criteria) this;
        }

        public Criteria andFContentIsNotNull() {
            addCriterion("f_content is not null");
            return (Criteria) this;
        }

        public Criteria andFContentEqualTo(String value) {
            addCriterion("f_content =", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotEqualTo(String value) {
            addCriterion("f_content <>", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentGreaterThan(String value) {
            addCriterion("f_content >", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentGreaterThanOrEqualTo(String value) {
            addCriterion("f_content >=", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLessThan(String value) {
            addCriterion("f_content <", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLessThanOrEqualTo(String value) {
            addCriterion("f_content <=", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentLike(String value) {
            addCriterion("f_content like", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotLike(String value) {
            addCriterion("f_content not like", value, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentIn(List<String> values) {
            addCriterion("f_content in", values, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotIn(List<String> values) {
            addCriterion("f_content not in", values, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentBetween(String value1, String value2) {
            addCriterion("f_content between", value1, value2, "fContent");
            return (Criteria) this;
        }

        public Criteria andFContentNotBetween(String value1, String value2) {
            addCriterion("f_content not between", value1, value2, "fContent");
            return (Criteria) this;
        }

        public Criteria andFIpIsNull() {
            addCriterion("f_ip is null");
            return (Criteria) this;
        }

        public Criteria andFIpIsNotNull() {
            addCriterion("f_ip is not null");
            return (Criteria) this;
        }

        public Criteria andFIpEqualTo(String value) {
            addCriterion("f_ip =", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotEqualTo(String value) {
            addCriterion("f_ip <>", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpGreaterThan(String value) {
            addCriterion("f_ip >", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpGreaterThanOrEqualTo(String value) {
            addCriterion("f_ip >=", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLessThan(String value) {
            addCriterion("f_ip <", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLessThanOrEqualTo(String value) {
            addCriterion("f_ip <=", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpLike(String value) {
            addCriterion("f_ip like", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotLike(String value) {
            addCriterion("f_ip not like", value, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpIn(List<String> values) {
            addCriterion("f_ip in", values, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotIn(List<String> values) {
            addCriterion("f_ip not in", values, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpBetween(String value1, String value2) {
            addCriterion("f_ip between", value1, value2, "fIp");
            return (Criteria) this;
        }

        public Criteria andFIpNotBetween(String value1, String value2) {
            addCriterion("f_ip not between", value1, value2, "fIp");
            return (Criteria) this;
        }

        public Criteria andFRmkIsNull() {
            addCriterion("f_rmk is null");
            return (Criteria) this;
        }

        public Criteria andFRmkIsNotNull() {
            addCriterion("f_rmk is not null");
            return (Criteria) this;
        }

        public Criteria andFRmkEqualTo(String value) {
            addCriterion("f_rmk =", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkNotEqualTo(String value) {
            addCriterion("f_rmk <>", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkGreaterThan(String value) {
            addCriterion("f_rmk >", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkGreaterThanOrEqualTo(String value) {
            addCriterion("f_rmk >=", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkLessThan(String value) {
            addCriterion("f_rmk <", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkLessThanOrEqualTo(String value) {
            addCriterion("f_rmk <=", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkLike(String value) {
            addCriterion("f_rmk like", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkNotLike(String value) {
            addCriterion("f_rmk not like", value, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkIn(List<String> values) {
            addCriterion("f_rmk in", values, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkNotIn(List<String> values) {
            addCriterion("f_rmk not in", values, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkBetween(String value1, String value2) {
            addCriterion("f_rmk between", value1, value2, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFRmkNotBetween(String value1, String value2) {
            addCriterion("f_rmk not between", value1, value2, "fRmk");
            return (Criteria) this;
        }

        public Criteria andFDurationIsNull() {
            addCriterion("f_duration is null");
            return (Criteria) this;
        }

        public Criteria andFDurationIsNotNull() {
            addCriterion("f_duration is not null");
            return (Criteria) this;
        }

        public Criteria andFDurationEqualTo(Integer value) {
            addCriterion("f_duration =", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationNotEqualTo(Integer value) {
            addCriterion("f_duration <>", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationGreaterThan(Integer value) {
            addCriterion("f_duration >", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_duration >=", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationLessThan(Integer value) {
            addCriterion("f_duration <", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationLessThanOrEqualTo(Integer value) {
            addCriterion("f_duration <=", value, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationIn(List<Integer> values) {
            addCriterion("f_duration in", values, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationNotIn(List<Integer> values) {
            addCriterion("f_duration not in", values, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationBetween(Integer value1, Integer value2) {
            addCriterion("f_duration between", value1, value2, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("f_duration not between", value1, value2, "fDuration");
            return (Criteria) this;
        }

        public Criteria andFKeyIsNull() {
            addCriterion("f_key is null");
            return (Criteria) this;
        }

        public Criteria andFKeyIsNotNull() {
            addCriterion("f_key is not null");
            return (Criteria) this;
        }

        public Criteria andFKeyEqualTo(String value) {
            addCriterion("f_key =", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyNotEqualTo(String value) {
            addCriterion("f_key <>", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyGreaterThan(String value) {
            addCriterion("f_key >", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyGreaterThanOrEqualTo(String value) {
            addCriterion("f_key >=", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyLessThan(String value) {
            addCriterion("f_key <", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyLessThanOrEqualTo(String value) {
            addCriterion("f_key <=", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyLike(String value) {
            addCriterion("f_key like", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyNotLike(String value) {
            addCriterion("f_key not like", value, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyIn(List<String> values) {
            addCriterion("f_key in", values, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyNotIn(List<String> values) {
            addCriterion("f_key not in", values, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyBetween(String value1, String value2) {
            addCriterion("f_key between", value1, value2, "fKey");
            return (Criteria) this;
        }

        public Criteria andFKeyNotBetween(String value1, String value2) {
            addCriterion("f_key not between", value1, value2, "fKey");
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