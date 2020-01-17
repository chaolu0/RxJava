package com.shxy.rxjava;

public abstract class Observable<T> {

    abstract void subscribe(Observer<T> observer); // 订阅

    static <T> Observable<T> create(Source<T> source) {
        return new CreateObservable<T>(source);
    }


    <R> Observable<R> map(Function<? super T, R> function) { // 转换
        return new ObservableMap<T, R>(this, function);
    }

    Observable<T> subscribeOn(Scheduler scheduler) {
        return new ObservableSubscribeOn<T>(this, scheduler);
    }

    Observable<T> observOn(Scheduler scheduler) {
        return new ObservableObservOn<>(this, scheduler);
    }

    <R> Observable<R> flatMap(Function<? super T, Observable<R>> function) {
        return new ObservableFlatMap<T,R>(this, function);
    }
}
