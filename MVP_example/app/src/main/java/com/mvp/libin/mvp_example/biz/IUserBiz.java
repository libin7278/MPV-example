package com.mvp.libin.mvp_example.biz;

/**
 * Created by libin on 16/11/8.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
