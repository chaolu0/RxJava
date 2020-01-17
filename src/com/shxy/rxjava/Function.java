package com.shxy.rxjava;

public interface Function<T,R> { // T->R
    R apply(T t);
}
