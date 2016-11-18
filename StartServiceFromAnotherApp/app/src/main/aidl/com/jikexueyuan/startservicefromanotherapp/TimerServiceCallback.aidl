// TimerServiceCallback.aidl
package com.jikexueyuan.startservicefromanotherapp;

// Declare any non-default types here with import statements

interface TimerServiceCallback {

    void onTimer(int numIndex);//回调函数
}
