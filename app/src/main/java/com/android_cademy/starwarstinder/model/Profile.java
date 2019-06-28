package com.android_cademy.starwarstinder.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Profile {

    @PrimaryKey
    @NonNull
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String imageUrl;

    @SerializedName("age")
    @Expose
    private Integer age;

    @SerializedName("location")
    @Expose
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}