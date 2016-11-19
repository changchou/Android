package com.jikexueyuan.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Administrator on 2015/11/10 0010.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("短信已经接收到了");

        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        Object[] pdus = (Object[]) bundle.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String from = message.getOriginatingAddress();//发送号码
            String content = message.getMessageBody();//发送内容
        }
    }
}
