package com.mvp.libin.mvp_example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.libin.mvp_example.base.MVPBaseActivity;
import com.mvp.libin.mvp_example.bean.User;
import com.mvp.libin.mvp_example.presenter.UserLoginPresenterB;
import com.mvp.libin.mvp_example.view.IViewUserLogin;

/**
 * Created by libin on 16/11/9.
 */

public class ActivityBUserLogin extends MVPBaseActivity<IViewUserLogin,UserLoginPresenterB>implements IViewUserLogin {
    private EditText et_usernam,et_userpassword;
    private ProgressBar pb;
    private Button btn_login,btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById();

        //登录
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });

        //清除
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clear();
            }
        });

    }

    @Override
    protected UserLoginPresenterB createPresenter() {
        return new UserLoginPresenterB(this);
    }

    private void findViewById() {
        et_userpassword = (EditText) findViewById(R.id.et_userpassword);
        et_usernam = (EditText) findViewById(R.id.et_usernam);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        pb = (ProgressBar) findViewById(R.id.pb);
    }

    @Override
    public String getUserName() {
        return et_usernam.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_userpassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        et_usernam.setText("");
    }

    @Override
    public void clearPassword() {
        et_userpassword.setText("");
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showFailedError() {
        Toast.makeText(this, " login failed ", Toast.LENGTH_SHORT).show();
    }
}
