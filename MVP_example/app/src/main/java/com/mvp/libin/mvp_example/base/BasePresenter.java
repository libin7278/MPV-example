package com.mvp.libin.mvp_example.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by libin on 16/11/8.
 */

public class BasePresenter<T> {
    protected Reference<T> mViewRef;  //View接口类型的弱引用

    /**
     * 建立关联
     * @param view
     */
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 获取View
     * @return
     */
    protected T getView(){
        return mViewRef.get();
    }

    /**
     * 判断是否与View建立关联
     * @return
     */
    public boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解除关联
     */
    public void detechView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
