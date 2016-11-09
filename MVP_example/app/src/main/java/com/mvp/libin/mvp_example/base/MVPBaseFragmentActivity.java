package com.mvp.libin.mvp_example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by libin on 16/11/8.
 */

public abstract class MVPBaseFragmentActivity<V,T extends BasePresenter<V>> extends FragmentActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();

        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.detechView();
    }

    protected abstract T createPresenter();
}
