package com.shxy.rxjava;

public class Test {
    public static void main(String[] args) {
        Observable.create(new Source<String>() {
            @Override
            public void sub(Emitter<String> emitter) {
                emitter.onNext("RxJava");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onNext(String string) {
                System.out.println(string);
            }
        });

        Observable.create(new Source<Integer>() {
            @Override
            public void sub(Emitter<Integer> emitter) {
                emitter.onNext(100);
                System.out.println("subscribe on thread: " + Thread.currentThread().getName());
            }
        }).map(new Function<Number, CharSequence>() { // number super integer
            @Override
            public String apply(Number number) {
                return number.toString();
            }
        }).flatMap(new Function<CharSequence, Observable<Character>>() {
            @Override
            public Observable<Character> apply(CharSequence charSequence) {
                return new Observable<Character>() {
                    @Override
                    void subscribe(Observer<Character> observer) {
                        for (int i = 0; i < charSequence.length(); i++) {
                            observer.onNext(charSequence.charAt(i));
                        }
                    }
                };
            }
        }).subscribeOn(Schedulers.io())
                .observOn(Schedulers.io())
                .subscribe(new Observer<Character>() {
                    @Override
                    public void onNext(Character s) {
                        System.out.println(s);
                        System.out.println("observer on thread: " + Thread.currentThread().getName());
                    }
                });
    }
}
