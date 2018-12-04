package com.thereza.roompersistencedbexample.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by theReza on 7/4/2018.
 */

@Entity
public class UserDbModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "image",typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public UserDbModel(String name, String phone, String email, String address, byte[] image) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }
}
