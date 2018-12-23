package com.analytics.google.mvpdemo.Network;

public interface NetworkChangeListener  {
    void onAvailable(NetworkDetails network);
    void onLost(NetworkDetails network);
}

