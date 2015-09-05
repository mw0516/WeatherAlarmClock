package com.kaku.weac.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kaku.weac.service.GuardMasterService;
import com.kaku.weac.util.LogUtil;

/**
 * 接收手机启动广播
 *
 * @author 咖枯
 * @version 1.0 2015
 */
public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i("BootBroadcastReceiver", "onReceive ");
        Intent i = new Intent(context, GuardMasterService.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(i);

    }

}