package com.debesh.jobListing.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity annotaion is only for jpa for rdbms, for mongodb @document is used
@Document(collection = "jobposts")
public class JobPost {
    private String profile;
    private String desc;
    private int exp;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    private String[] techs;
}
