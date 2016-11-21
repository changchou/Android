package com.jikexueyuan.lockscreen;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DevicePolicyManager devicePolicyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        findViewById(R.id.btnLockScreen).setOnClickListener(this);
        findViewById(R.id.btnRegDeviceAdmin).setOnClickListener(this);
        findViewById(R.id.btnUnRegDeviceAdmin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegDeviceAdmin:
            //注册成为系统组件
            Intent i = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            i.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,new ComponentName(this,DeviceManagerBC.class));
            startActivity(i);
            break;
            case R.id.btnLockScreen:
                //锁屏
                devicePolicyManager.lockNow();
                break;
            case R.id.btnUnRegDeviceAdmin:
                //取消系统组件权限
                devicePolicyManager.removeActiveAdmin(new ComponentName(this,DeviceManagerBC.class));
                break;
        }
    }
}
