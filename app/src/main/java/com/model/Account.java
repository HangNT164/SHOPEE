package com.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "account")
public class Account {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private int id;

    @ForeignKey(entity = AccountDetail.class, parentColumns = {"id"}, childColumns = {"account_detail_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "account_detail_id")
    private int accountDetailID;

    @ForeignKey(entity = Role.class, parentColumns = {"id"}, childColumns = {"role_id"}, onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "role_id")
    private int roleID;

    @ColumnInfo
    private String email;

    @ColumnInfo
    private String password;

    public Account() {
    }

    public Account(int id, int accountDetailID, int roleID, String email, String password) {
        this.id = id;
        this.accountDetailID = accountDetailID;
        this.roleID = roleID;
        this.email = email;
        this.password = password;
    }

    public Account(int accountDetailID, int roleID, String email, String password) {
        this.accountDetailID = accountDetailID;
        this.roleID = roleID;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountDetailID() {
        return accountDetailID;
    }

    public void setAccountDetailID(int accountDetailID) {
        this.accountDetailID = accountDetailID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountDetailID=" + accountDetailID +
                ", roleID=" + roleID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
