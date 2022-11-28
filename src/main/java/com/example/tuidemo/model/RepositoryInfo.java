package com.example.tuidemo.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class RepositoryInfo {


    @ApiModelProperty(notes = "Repository Name", example = "myRepo")
    String repoName;
    @ApiModelProperty(notes = "Name of repository owner", example = "sampleUser")
    String ownerName;
    @ApiModelProperty(notes = "List of repository branches")
    List<Branch> branchList;

    public RepositoryInfo(String repoName, String ownerName, List<Branch> branchList) {
        this.repoName = repoName;
        this.ownerName = ownerName;
        this.branchList = branchList;
    }

    public RepositoryInfo(String repoName, List<Branch> branchList) {
        this.repoName = repoName;
        this.branchList = branchList;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}
