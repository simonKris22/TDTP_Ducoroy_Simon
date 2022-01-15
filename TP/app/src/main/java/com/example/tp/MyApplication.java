package com.example.tp;

import android.app.Application;

public class MyApplication extends Application {

    private int lg;

    public int getLg() {
        return lg;
    }

    public void setLg(int lg) {
        this.lg = lg;
    }
}
