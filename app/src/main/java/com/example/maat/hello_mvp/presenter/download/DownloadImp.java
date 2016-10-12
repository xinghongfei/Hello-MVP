package com.example.maat.hello_mvp.presenter.download;

import com.example.maat.hello_mvp.model.retrofit.DownloadService;
import com.example.maat.hello_mvp.model.retrofit.InternetHelper;
import com.example.maat.hello_mvp.view.download.ViewInterface;

/**
 * Created by xinghongfei on 16/10/6.
 */

public class DownloadImp implements DownloadInterface{

    private ViewInterface mViewInterface;

    private DownloadService mDownloadService;

    public DownloadImp(ViewInterface viewInterface){
        mViewInterface = viewInterface;
        mDownloadService=new DownloadService();
    }

    @Override
    public void start(String file) {
        if (InternetHelper.isWifiConnected()){
            mDownloadService.setDownloadListener(new DownloadService.DownloadListener() {
                @Override
                public void downloding(int t) {
                    mViewInterface.downloading(t);
                }

                @Override
                public void finished() {
                    mViewInterface.completed();
                }

                @Override
                public void error(Exception e) {
                    mViewInterface.error(e);
                }
            });
            mViewInterface.start();
            mDownloadService.downloadFile(file);
        }

    }

    @Override
    public void pause() {
            mDownloadService.pause();
    }

    @Override
    public void cancel() {
        mDownloadService.cancel();
    }
}
