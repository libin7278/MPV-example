package com.mvp.libin.mvp_example.model;

/**
 * Created by libin on 16/11/8.
 */

public interface IUserModel {
    public void login(String username, String password, OnLoginListener loginListener);
}
