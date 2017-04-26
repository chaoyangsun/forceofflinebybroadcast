package safeadmin.cs.com.forceofflinebybroadcast.reciver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import safeadmin.cs.com.forceofflinebybroadcast.activity.LoginActivity;
import safeadmin.cs.com.forceofflinebybroadcast.util.ActivityContainer;

public class ForceOfflineBroadcast extends BroadcastReceiver {
    public ForceOfflineBroadcast() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("强制下线")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //销毁所有开启的活动
                        ActivityContainer.finishAll();
                        //开启登录界面
                        LoginActivity.startActivity(context);
                    }
                })
                //强制弹框不能取消
                .setCancelable(false)
                .show();
    }
}
