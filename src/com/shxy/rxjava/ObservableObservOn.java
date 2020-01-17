package com.shxy.rxjava;

public class ObservableObservOn<T> extends Observable<T>{

    private Observable<T> source;
    private Scheduler scheduler;

    public ObservableObservOn(Observable<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    void subscribe(Observer<T> observer) {
        source.subscribe(new Observer<T>() {
            @Override
            public void onNext(T t) {
                scheduler.postRunnable(()->{
                    observer.onNext(t);
                });
            }
        });
    }
}
