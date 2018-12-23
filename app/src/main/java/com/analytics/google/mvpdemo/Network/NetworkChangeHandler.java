package com.analytics.google.mvpdemo.Network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetworkChangeHandler  {
    public static final NetworkChangeHandler handler = new NetworkChangeHandler();
    List<NetworkChangeListener> listeners = Collections.synchronizedList(new ArrayList<NetworkChangeListener>());
    public static NetworkChangeHandler getHandler() {
        return handler;
    }
    public void registerNetworkChangeListener(NetworkChangeListener listener) {
        synchronized (this) {
            listeners.add(listener);
        }
    }

    public void unregisterNetworkChangeListener(NetworkChangeListener listener) {
        synchronized (this) {
            listeners.remove(listener);
        }
    }
    public void notifyNetworkAvailble(NetworkDetails network) {
        synchronized (this) {
            for (int i = 0; i < listeners.size(); i++)
                listeners.get(i).onAvailable(network);
        }
    }

    public void notifyNetworkLost(NetworkDetails network) {
        synchronized (this) {
            for (int i = 0; i < listeners.size(); i++)
                listeners.get(i).onLost(network);
        }
    }
}
