package com.shxy.rxjava;

public interface Observer<T> {

    void onNext(T t); // 被订阅者回调这个方法
}
