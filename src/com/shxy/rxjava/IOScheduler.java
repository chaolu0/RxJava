package com.shxy.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOScheduler implements Scheduler{

    ExecutorService threadPool = Executors.newCachedThreadPool();

    @Override
    public void postRunnable(Runnable runnable) {
        threadPool.submit(runnable);
    }
}
