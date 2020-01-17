package com.shxy.rxjava;

public interface Emitter<T> { // 向订阅者发送结果

    void onNext(T t);
}
