package com.bcafinance.jecspringbootjpa.models;
/*
Created By IntelliJ IDEA 2022.2.3 (Ultimate Edition)
@Author Jett a.k.a. Jett Enrico Chandra
CTO
Created on 11/30/2022
@Last Modified 11/30/2022 1:50 PM
Version 1.0
*/

import com.bcafinance.jecspringbootjpa.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "MstWarehouses")
public class Warehouses implements Serializable {

    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WarehouseId")
    private Long id;

    @Length(message = ConstantMessage.WARNING_WAREHOUSE_ADDRESS_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_BLANK_ADDRESS)
    @Column(name = "WarehouseAddress", nullable = false,unique = true)
    private String address;

    @Length(message = ConstantMessage.WARNING_WAREHOUSE_SUPERVISOR_MAX_LENGTH)
    @NotEmpty(message = ConstantMessage.WARNING_BLANK_SUPERVISOR)
    @Column(name = "WarehouseSupervisor",length = 50 ,nullable = false)
    private String warehouseSpv;

    @Column(name = "WarehouseDescription", nullable = true)
    private String warehouseDesc;

    @Column(name = "CreatedBy",nullable = false)
    private String createdBy = "1";

    //    @Column(name = "CreatedDate",nullable = true, columnDefinition = "datetime2(7) DEFAULT GETDATE() ")
    @Column(name = "CreatedDate",nullable = false)
    private Date createdDate = new Date();//JANGAN GUNAKAN columnDefinition untuk set default kolom, langsung set di variabel nya saja.

    @Column(name = "ModifiedBy",nullable = true)
    private String modifiedBy ;

    @Column(name = "ModifiedDate",nullable = true)
    private Date modifiedDate;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive = true;
    @ManyToMany(mappedBy = "warehouses")
    @JsonBackReference
    private Set<Stores> storesList = new HashSet<Stores>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWarehouseSpv() {
        return warehouseSpv;
    }

    public void setWarehouseSpv(String warehouseSpv) {
        this.warehouseSpv = warehouseSpv;
    }

    public String getWarehouseDesc() {
        return warehouseDesc;
    }

    public void setWarehouseDesc(String warehouseDesc) {
        this.warehouseDesc = warehouseDesc;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Stores> getStoresList() {
        return storesList;
    }

    public void setStoresList(Set<Stores> storesList) {
        this.storesList = storesList;
    }
}