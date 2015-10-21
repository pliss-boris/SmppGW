package com.pb.SmppGatway.dao.persist.domain;

import javax.persistence.*;

/**
 * Created by Boris on 10/21/2015.
 */
@Entity
@Table(name = "FLOWS", schema = "SMS", catalog = "")
public class FlowsEntity {
    private long id;
    private String className;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

        FlowsEntity that = (FlowsEntity) o;

        if (id != that.id) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }
}
