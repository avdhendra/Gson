package com.example.gson;

import java.util.ArrayList;

public class Result {
Integer total_count; //varibale name should match json key
Boolean incomplete_result;
ArrayList<GithubUser>items; //these name should be same as of api response
//if we write arraylist in place of items json cant mirror it to json file
    public Result() {

    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getIncomplete_result() {
        return incomplete_result;
    }

    public void setIncomplete_result(Boolean incomplete_result) {
        this.incomplete_result = incomplete_result;
    }

    public ArrayList<GithubUser> getItems() {
        return items;
    }

    public void setItems(ArrayList<GithubUser> items) {
        this.items = items;
    }
}
