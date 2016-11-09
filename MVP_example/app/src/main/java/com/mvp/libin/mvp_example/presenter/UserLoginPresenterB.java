package com.mvp.libin.mvp_example.presenter;

import android.os.Handler;

import com.mvp.libin.mvp_example.base.BasePresenter;
import com.mvp.libin.mvp_example.bean.User;
import com.mvp.libin.mvp_example.biz.IUserBiz;
import com.mvp.libin.mvp_example.biz.OnLoginListener;
import com.mvp.libin.mvp_example.biz.UserBiz;
import com.mvp.libin.mvp_example.view.IUserLoginView;

/**
 * Created by libin on 16/11/9.
 */

public class UserLoginPresenterB extends BasePresenter<IUserLoginView> {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenterB(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener()
        {
            @Override
            public void loginSuccess(final User user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
