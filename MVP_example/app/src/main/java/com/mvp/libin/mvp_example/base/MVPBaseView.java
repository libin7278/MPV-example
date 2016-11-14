package com.mvp.libin.mvp_example.base;

/**
 * Created by libin on 16/11/10.
 */

public interface MVPBaseView<M> {
    //数据加载成功时显示
    public void showContent();

    //用于显示加载数据时的动画，比如进度条
    public void showLoading(boolean pullToRefresh);

    //当数据加载成功时，将数据进行赋值，在调用showContent之前进行调用
    public void setData(M data);

    // 加载数据，这个方法一般是放着Activity或者Fragment中进行调用的
    public void loadData(boolean pullToRefresh);

    //用于显示加载数据失败的内容
    public void showError(Throwable e, boolean pullToRefresh);
}
