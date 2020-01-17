package com.shxy.rxjava;

public interface Source<T> {

    void sub(Emitter<T> emitter); // 调用这个方法说明被订阅了，应该通过emitter.onNext将结果发送给订阅者
}
