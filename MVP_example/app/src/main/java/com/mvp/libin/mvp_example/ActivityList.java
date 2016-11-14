package com.mvp.libin.mvp_example;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ProgressBar;

import com.mvp.libin.mvp_example.base.MVPBaseActivity;
import com.mvp.libin.mvp_example.presenter.ListViewPresenter;
import com.mvp.libin.mvp_example.view.IViewList;

import static com.mvp.libin.mvp_example.R.id.contentView;
import static com.mvp.libin.mvp_example.R.id.recyclerView;

/**
 * Created by libin on 16/11/11.
 */

public class ActivityList extends MVPBaseActivity<IViewList,ListViewPresenter> implements IViewList {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        contentView = (SwipeRefreshLayout) findViewById(R.id.contentView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        contentView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
        loadData(false);
    }

    @Override
    protected ListViewPresenter createPresenter() {
        return new ListViewPresenter();
    }


    @Override
    public void showContent() {

    }

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {

    }
}
