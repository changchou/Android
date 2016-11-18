// IAppServiceRemoteBinder.aidl
package com.jikexueyuan.startservicefromanotherapp;

// Declare any non-default types here with import statements
import com.jikexueyuan.startservicefromanotherapp.TimerServiceCallback;

interface IAppServiceRemoteBinder {
//自动生成的代码  在4学习aidl回调函数时直接删除了
//
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

    void setData(String data);

    void registCallback(TimerServiceCallback callback);//注册回调函数    新建了一个aidl  TimerServiceCallback
    void unRegistCallback(TimerServiceCallback callback);//解除回调函数
}
