package com.mvp.libin.mvp_example.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by libin on 16/11/8.
 */

public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends Activity{
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter(); //创建Presenter

        mPresenter.attachView((V) this); //View与Presenter建立关联
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detechView();  //解除关联
    }

    protected abstract T createPresenter();
}

//====================================================》知识点
/**
 *MVPBasePresenter包含两个泛型参数,第一个是View接口类型,第二个是Presenter具体实现类型。
 *
 * 在OnDestory中,则会解除与Activity的关联,避免内存泄漏。
 */

/**
 * 在OnDestory中解除了与View的的关联为什么还要用弱引用?
 * 答:并不是每次Activity的OnDestory都会被调用到,这是双重保险管。
 */

/**
 *  Java泛型中的标记符含义：
 *  E - Element (在集合中使用，因为集合中存放的是元素)
 *  T - Type（Java 类）
 *  K - Key（键）
 *  V - Value（值）
 *  N - Number（数值类型）
 */

