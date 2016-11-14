package com.mvp.libin.mvp_example.model;

import com.mvp.libin.mvp_example.bean.User;

/**
 * Created by libin on 16/11/8.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
