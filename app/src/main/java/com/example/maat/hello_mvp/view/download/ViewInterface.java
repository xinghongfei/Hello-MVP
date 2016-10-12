package com.example.maat.hello_mvp.view.download;

/**
 * Created by xinghongfei on 16/10/6.
 */

public interface ViewInterface {
    void start();
    void downloading(int t);
    void error(Exception e);
    void completed();
}
