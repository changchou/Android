package com.jikexueyuan.connectservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private TextView tvOut;
    private EditText etData;
    private MyService.Binder binder;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        etData = (EditText) findViewById(R.id.etData);
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);
        findViewById(R.id.btnSyncData).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                Intent i = new Intent(this, MyService.class);
                i.putExtra("data", etData.getText().toString());
                startService(i);
                break;
            case R.id.btnStopService:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.btnBindService:
              isBound=  bindService(new Intent(this, MyService.class), this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService:
                if (isBound) {
                    unbindService(this);
                    isBound = false;
                }

                break;
            case R.id.btnSyncData:
                if (binder != null) {
                    binder.setData(etData.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {//复写的bindService(new Intent(this, MyService.class), this, Context.BIND_AUTO_CREATE);里面的this
        binder = (MyService.Binder) service;
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle b = new Bundle();
                b.putString("data",data);
                msg.setData(b);
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            unbindService(this);
        }

    }


    private android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            tvOut.setText(msg.getData().getString("data"));
        }
    };



}
