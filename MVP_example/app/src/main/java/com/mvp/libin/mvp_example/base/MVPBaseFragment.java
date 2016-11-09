package com.mvp.libin.mvp_example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by libin on 16/11/8.
 */

public abstract class MVPBaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();

        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract T createPresenter();
}
