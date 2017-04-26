package safeadmin.cs.com.forceofflinebybroadcast.activity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import safeadmin.cs.com.forceofflinebybroadcast.reciver.ForceOfflineBroadcast;
import safeadmin.cs.com.forceofflinebybroadcast.util.ActivityContainer;
import safeadmin.cs.com.forceofflinebybroadcast.util.RCode;

/**
 * Created by charming-yin on 2017/4/26.
 */
public class BaseActivity extends AppCompatActivity {

    ForceOfflineBroadcast forceOfflineBroadcast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityContainer.addActivity(this);
    }

    /**
     * 动态注册
     */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RCode.customAction);
        forceOfflineBroadcast = new ForceOfflineBroadcast();
        registerReceiver(forceOfflineBroadcast , intentFilter);
    }

    /**
     * 保证处于栈顶的活动 才能接收到广播
     */
    @Override
    protected void onPause() {
        super.onPause();
        if(forceOfflineBroadcast != null) {
            unregisterReceiver(forceOfflineBroadcast);
            forceOfflineBroadcast = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityContainer.deleteActivity(this);
    }
}
