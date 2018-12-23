package com.analytics.google.mvpdemo.Network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class NetworkChangeCallback extends ConnectivityManager.NetworkCallback {
    @Override
    public void onAvailable(Network network) {
        super.onAvailable(network);
        NetworkDetails detail = new NetworkDetails();
        detail.setAvailable(true);
        NetworkChangeHandler.getHandler().notifyNetworkAvailble(detail);
        Log.e("Android","Available");
    }

    @Override
    public void onLost(Network network) {
        super.onLost(network);
        NetworkDetails detail = new NetworkDetails();
        detail.setAvailable(true);
        NetworkChangeHandler.getHandler().notifyNetworkLost(detail);
        Log.e("Android","Lost");
    }
}
