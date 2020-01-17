package com.shxy.rxjava;

public class ObservableMap<T, R> extends Observable<R> {

    private Observable<T> source;
    private Function<? super T, R> function;

    public ObservableMap(Observable<T> source, Function<? super T, R> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    void subscribe(Observer<R> observer) {
        source.subscribe(new Observer<T>() {
            @Override
            public void onNext(T t) {
                observer.onNext(function.apply(t));
            }
        });
    }

}
