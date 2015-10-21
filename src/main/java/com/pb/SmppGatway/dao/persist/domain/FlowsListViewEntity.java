package com.pb.SmppGatway.dao.persist.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Boris on 10/21/2015.
 */
@Entity
@Table(name = "FLOWS_LIST_VIEW", schema = "SMS", catalog = "")
public class FlowsListViewEntity {
    private long userId;
    private String className;

    @Basic
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CLASS_NAME")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowsListViewEntity that = (FlowsListViewEntity) o;

        if (userId != that.userId) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }
}
