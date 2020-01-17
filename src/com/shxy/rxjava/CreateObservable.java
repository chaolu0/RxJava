package com.shxy.rxjava;

public class CreateObservable<T> extends Observable<T>{

    private Source<T> source;

    public CreateObservable(Source<T> source) {
        this.source = source;
    }

    @Override
    void subscribe(Observer<T> observer) {
        Emitter<T> emitter = new InnerEmitter(observer);
        source.sub(emitter);
    }

    class InnerEmitter implements Emitter<T> {

        Observer<T> observer;

        public InnerEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            observer.onNext(t);
        }
    }
}
