package com.mvp.libin.mvp_example.biz;

import com.mvp.libin.mvp_example.bean.User;

/**
 * Created by libin on 16/11/8.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
