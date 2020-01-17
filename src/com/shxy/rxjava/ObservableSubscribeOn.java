package com.shxy.rxjava;

public class ObservableSubscribeOn<T> extends Observable<T>{

    private Observable<T> source;
    private Scheduler scheduler;

    public ObservableSubscribeOn(Observable<T> source, Scheduler scheduler) {
        this.source = source;
        this.scheduler = scheduler;
    }

    @Override
    void subscribe(Observer<T> observer) {
        scheduler.postRunnable(()->{
            source.subscribe(new Observer<T>() {
                @Override
                public void onNext(T t) {
                    observer.onNext(t);
                }
            });
        });
    }
}
