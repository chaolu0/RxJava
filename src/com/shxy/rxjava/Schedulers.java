package com.shxy.rxjava;

public class Schedulers {

    static Scheduler io(){
        return new IOScheduler();
    }
}
