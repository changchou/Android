package com.jikexueyuan.startservicefromanotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class AppService extends Service {

    private RemoteCallbackList<TimerServiceCallback> callbackList = new RemoteCallbackList<>();//回调函数管道   列表

    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new IAppServiceRemoteBinder.Stub() {

            @Override
            public void setData(String data) throws RemoteException {
                AppService.this.data = data;
            }

            @Override
            public void registCallback(TimerServiceCallback callback) throws RemoteException {

                callbackList.register(callback);
                //注册的时候把对象放进去

            }

            @Override
            public void unRegistCallback(TimerServiceCallback callback) throws RemoteException {
                callbackList.unregister(callback);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("Service started");

        new Thread() {
            @Override
            public void run() {
                super.run();

                running = true;
//                while (running) {
//                    System.out.println(data);
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                for (numIndex = 0; running; numIndex++) {
                    System.out.println(numIndex);//后台显示便于观察
                    //回调处理
                    int count = callbackList.beginBroadcast();
                    while (count-- > 0) {
                        try {
                            callbackList.getBroadcastItem(count).onTimer(numIndex);//callbackList.getBroadcastItem(count)得到广播的项   onTimer回调函数
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }

                    callbackList.finishBroadcast();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("Service destroyed");
        running = false;
    }

    private String data = "默认数据";

    private boolean running = false;

    private int numIndex = 0;
}
