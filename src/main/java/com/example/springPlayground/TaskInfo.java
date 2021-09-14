package com.example.springPlayground;

import org.springframework.web.bind.annotation.GetMapping;

public class TaskInfo {
    private String sortBy;
    private String owner;

    @GetMapping("/tasks")
    public String getTasks(TaskInfo taskInfo) {
        return String.format("sort-by is %s; owner is %s", taskInfo.getSortBy(), taskInfo.getOwner());
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}