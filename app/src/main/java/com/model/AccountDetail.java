package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_detail")
public class AccountDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String mobile;

    @ColumnInfo(defaultValue = "0")
    private boolean gender;

    @ColumnInfo
    private String address;

    @ColumnInfo(name = "create_date", defaultValue = "CURRENT_TIMESTAMP")
    private String createDate;

    public AccountDetail(int id, String name, String mobile, boolean gender, String address, String createDate) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.createDate = createDate;
    }

    public AccountDetail(String name, String mobile, boolean gender, String address, String createDate) {
        this.name = name;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.createDate = createDate;
    }

    public AccountDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "AccountDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
