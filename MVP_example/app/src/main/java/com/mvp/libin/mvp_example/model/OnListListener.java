package com.mvp.libin.mvp_example.model;

import com.mvp.libin.mvp_example.bean.ListBean;

/**
 * Created by libin on 16/11/10.
 */

public interface OnListListener<T> {
    void onSuccess(T t);

    void onFailure(int code);
}
