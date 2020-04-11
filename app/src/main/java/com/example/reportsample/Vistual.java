package com.example.reportsample;

public class Vistual {

    private String name;
    private String pageName;

    public Vistual(String name, String pageName) {
        this.name = name;
        this.pageName = pageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
