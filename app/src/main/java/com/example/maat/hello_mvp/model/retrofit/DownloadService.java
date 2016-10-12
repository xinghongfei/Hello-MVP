package com.example.maat.hello_mvp.model.retrofit;

import android.os.Handler;

/**
 * Created by xinghongfei on 16/10/6.
 */

public class DownloadService {

    private DownloadListener mDownloadListener;
    private int t=0;
    private Handler mHandler=new Handler();

    public boolean downloadFile(String s) {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mDownloadListener != null) {
                        mDownloadListener.downloding(++t);
                    }
                mHandler.postDelayed(this,100);
                if (t==100){
                    mHandler.removeCallbacks(this);
                    mDownloadListener.finished();
                    t=0;

                }
            }
        },100);

        return true;
    }

    public boolean pause() {
        return true;
    }

    public boolean cancel() {
        return true;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        mDownloadListener = downloadListener;
    }

    public interface DownloadListener {
        void downloding(int t);

        void finished();

        void error(Exception e);
    }
}
