package com.srs.backend.model;

import com.srs.backend.constant.AbstractConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Persistable implements Serializable, Cloneable {
    public Persistable() {
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = AbstractConstant.ID_COLUMN_NAME)
    private Long id = AbstractConstant.ID_UNSAVED_VALUE;

//    @Version
//    @Column(name = AbstractConstant.VERSION_COLUMN_NAME)
//    private long version = 0;
//    @Version
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = AbstractConstant.VERSION_COLUMN_NAME)
//    private Date version= new Date();;

//    @Type(type = "org.hibernate.type.NumericBooleanType")
//    @Column(name = AbstractConstant.ACTIVE_COLUMN_NAME, nullable = true)
//    private boolean active = true;

//    @JsonIgnore
//    @CreatedBy
//    @Column(name = AbstractConstant.CREATED_BY_COLUMN_NAME, updatable = true)
//    private String createdBy;
//
//    @JsonIgnore
//    @LastModifiedBy
//    @Column(name = AbstractConstant.LAST_UPDATED_BY_COLUMN_NAME)
//    private String lastUpdatedBy;
//
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @CreatedDate
    @Column(name = AbstractConstant.CREATION_DATE_COLUMN_NAME, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();
//
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
//    @LastModifiedDate
//    @Column(name = AbstractConstant.LAST_UPDATED_DATE_COLUMN_NAME)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastUpdateDate;
//
//    public Persistable(long id) {
//        this.id = id;
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//
////    public long getVersion() {
////        return version;
////    }
////
////    public void setVersion(long version) {
////        this.version = version;
////    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getLastUpdatedBy() {
//        return lastUpdatedBy;
//    }
//
//    public void setLastUpdatedBy(String lastUpdatedBy) {
//        this.lastUpdatedBy = lastUpdatedBy;
//    }
//
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
//
//    public Date getLastUpdateDate() {
//        return lastUpdateDate;
//    }
//
//    public void setLastUpdateDate(Date lastUpdateDate) {
//        this.lastUpdateDate = lastUpdateDate;
//    }
}