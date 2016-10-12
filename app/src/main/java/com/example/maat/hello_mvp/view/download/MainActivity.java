package com.example.maat.hello_mvp.view.download;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.maat.hello_mvp.R;
import com.example.maat.hello_mvp.presenter.download.DownloadImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewInterface{

    @BindView(R.id.start_button)
    Button mStartButton;
    @BindView(R.id.number_progress_bar)
    NumberProgressBar mNumberProgressBar;
    DownloadImp mDownloadImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDownloadImp=new DownloadImp(this);
    }

    @OnClick(R.id.start_button)
    public void onClick() {
        mDownloadImp.start("url");
    }

    @Override
    public void start() {
        mNumberProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void downloading(int t) {
        mNumberProgressBar.setProgress(t);

    }

    @Override
    public void error(Exception e) {
        mNumberProgressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void completed() {
        mNumberProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this,"下载完成",Toast.LENGTH_LONG).show();
    }
}
