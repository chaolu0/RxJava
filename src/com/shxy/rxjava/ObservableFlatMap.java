package com.shxy.rxjava;

public class ObservableFlatMap<T,R> extends Observable<R> {

    private Observable<T> source;
    private Function<? super T,Observable<R>> function;

    public ObservableFlatMap(Observable<T> source, Function<? super T, Observable<R>> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    void subscribe(Observer<R> observer) {
        source.subscribe(new Observer<T>() {
            @Override
            public void onNext(T t) {
                function.apply(t).subscribe(new Observer<R>() {
                    @Override
                    public void onNext(R r) {
                        observer.onNext(r);
                    }
                });
            }
        });
    }
}
