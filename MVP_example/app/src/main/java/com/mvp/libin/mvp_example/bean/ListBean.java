package com.mvp.libin.mvp_example.bean;

/**
 * Created by libin on 16/11/9.
 */

public class ListBean {
    private String name;
    private String content;

    public ListBean(String s1, String s2) {
        name = s1;
        content= s2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
