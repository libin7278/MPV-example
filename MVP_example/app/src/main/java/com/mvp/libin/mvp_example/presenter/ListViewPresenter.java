package com.mvp.libin.mvp_example.presenter;

import com.mvp.libin.mvp_example.base.BasePresenter;
import com.mvp.libin.mvp_example.bean.ListBean;
import com.mvp.libin.mvp_example.model.ListModle;
import com.mvp.libin.mvp_example.model.OnListListener;
import com.mvp.libin.mvp_example.view.IViewList;

import java.util.List;

/**
 * Created by libin on 16/11/9.
 */

public class ListViewPresenter extends BasePresenter<IViewList> {
    public void loadNews(final boolean pullToRefresh) {
        if (isViewAttach()) {
            getView().showLoading(pullToRefresh);
        }
        OnListListener<List<ListBean>> listener=new OnListListener<List<ListBean>>() {
            @Override
            public void onSuccess(List<ListBean> news) {
                if (isViewAttach()) {
                    getView().setData(news);
                    getView().showContent();
                }
            }
            @Override
            public void onFailure(int code) {
                if (isViewAttach()) {
                    getView().showError(new Exception("msg:"+code), pullToRefresh);
                }
            }
        };

        ListModle.loadNews(pullToRefresh,listener);
    }
}
