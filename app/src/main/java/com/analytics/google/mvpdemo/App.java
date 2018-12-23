package com.analytics.google.mvpdemo;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;

import com.analytics.google.mvpdemo.Network.NetworkChangeCallback;

public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        registerConnectivityNetworkMonitorForAPI21AndUp();

    }
    public static Context getAppContext(){

        return context;

    }

    private void registerConnectivityNetworkMonitorForAPI21AndUp() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();

        connectivityManager.registerNetworkCallback(builder.build(), new NetworkChangeCallback());

    }
}
