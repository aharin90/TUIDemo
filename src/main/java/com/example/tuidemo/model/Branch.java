package com.example.tuidemo.model;

import io.swagger.annotations.ApiModelProperty;

public class Branch {
    @ApiModelProperty(notes = "BranchName", example = "myRepo")
    private String name;
    @ApiModelProperty(notes = "SHA code of last commit in branch")
    private String sha;


    public Branch(String name, String sha) {
        this.name = name;
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", sha='" + sha + '\'' +
                '}';
    }
}
