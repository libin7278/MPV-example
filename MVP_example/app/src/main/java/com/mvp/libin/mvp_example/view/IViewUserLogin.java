package com.mvp.libin.mvp_example.view;

import com.mvp.libin.mvp_example.bean.User;

/**
 * Created by libin on 16/11/8.
 */

public interface IViewUserLogin {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
