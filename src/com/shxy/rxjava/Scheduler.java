package com.shxy.rxjava;

public interface Scheduler {

    void postRunnable(Runnable runnable);
}
