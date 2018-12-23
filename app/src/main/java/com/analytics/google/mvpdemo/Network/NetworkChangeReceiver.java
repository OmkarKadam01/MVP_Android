package com.analytics.google.mvpdemo.Network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.analytics.google.mvpdemo.App;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null)
            return;

        ConnectivityManager cm = (ConnectivityManager) App.getAppContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            NetworkDetails detail = new NetworkDetails();
            detail.setAvailable(true);
            NetworkChangeHandler.getHandler().notifyNetworkAvailble(detail);
        } else {
            NetworkDetails detail = new NetworkDetails();
            detail.setAvailable(false);
            NetworkChangeHandler.getHandler().notifyNetworkLost(detail);
        }
    }
}
