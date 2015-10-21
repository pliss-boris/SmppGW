package com.pb.SmppGatway.dao.mem.domain;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by Boris on 10/19/2015.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "sms", schema = "", catalog = "")
@NamedQueries({
        @NamedQuery(name = "SmsEntity.all", query = "SELECT u FROM SmsEntity u")
})
public class SmsEntity {
    private String id;
    private String extId;
    private Integer ownerId;
    private String messageText;
    private Integer dataCoding;

    @Id
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "ext_id")
    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "owner_id")
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "message_text")
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "data_coding")
    public Integer getDataCoding() {
        return dataCoding;
    }

    public void setDataCoding(Integer dataCoding) {
        this.dataCoding = dataCoding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsEntity smsEntity = (SmsEntity) o;

        if (id != null ? !id.equals(smsEntity.id) : smsEntity.id != null) return false;
        if (extId != null ? !extId.equals(smsEntity.extId) : smsEntity.extId != null) return false;
        if (ownerId != null ? !ownerId.equals(smsEntity.ownerId) : smsEntity.ownerId != null) return false;
        if (messageText != null ? !messageText.equals(smsEntity.messageText) : smsEntity.messageText != null)
            return false;
        if (dataCoding != null ? !dataCoding.equals(smsEntity.dataCoding) : smsEntity.dataCoding != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (extId != null ? extId.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        result = 31 * result + (dataCoding != null ? dataCoding.hashCode() : 0);
        return result;
    }
}
