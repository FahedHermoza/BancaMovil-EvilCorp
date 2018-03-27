package com.fahed.developer.evilcorpbank.Models;

public class Movement {

    private String detail;
    private String date;
    private int count;

    public Movement() {
    }

    public Movement(String detail, String date, int count) {
    super();
    this.detail = detail;
    this.date = date;
    this.count = count;
    }

    public String getDetail() {
    return detail;
    }

    public void setDetail(String detail) {
    this.detail = detail;
    }

    public String getDate() {
    return date;
    }

    public void setDate(String date) {
    this.date = date;
    }

    public int getCount() {
    return count;
    }

    public void setCount(int count) {
    this.count = count;
    }

}