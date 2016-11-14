package com.mvp.libin.mvp_example.model;

import android.os.Handler;
import android.os.Looper;

import com.mvp.libin.mvp_example.bean.ListBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by libin on 16/11/10.
 */

public class ListModle {
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static Random random = new Random();

    public static void loadNews(final boolean pullToRefresh, final OnListListener<List<ListBean>> listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<ListBean> list = new ArrayList<ListBean>();
                ListBean news1 = new ListBean("标题1", "描述描述描述描述描述描述描述描述描述描述描述描述1");
                ListBean news2 = new ListBean("标题2", "描述描述描述描述描述描述描述描述描述描述描述描述2");
                ListBean news3 = new ListBean("标题3", "描述描述描述描述描述描述描述描述描述描述描述描述3");
                ListBean news4 = new ListBean("标题4", "描述描述描述描述描述描述描述描述描述描述描述描述4");
                ListBean news5 = new ListBean("标题5", "描述描述描述描述描述描述描述描述描述描述描述描述5");
                ListBean news6 = new ListBean("标题6", "描述描述描述描述描述描述描述描述描述描述描述描述6");

                list.add(news1);
                list.add(news2);
                list.add(news3);
                list.add(news4);
                list.add(news5);

                if (pullToRefresh) {
                    list.add(news6);
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null) {
                            listener.onFailure(1);
                            int i = random.nextInt(100);
                            if (i % 2 == 0) {
                                listener.onSuccess(list);
                            } else {
                                listener.onFailure(1000);
                            }
                        }

                    }
                });
            }
        }).start();

    }
}
