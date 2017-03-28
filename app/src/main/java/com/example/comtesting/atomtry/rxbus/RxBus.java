package com.example.comtesting.atomtry.rxbus;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by atom on 2017/3/23.
 * 自定义事件总线eventbus
 */

public class RxBus {

    private static volatile RxBus instance;
    private final Subject<Object> subject;

    private RxBus() {
        //rxjava2里subject已经可以直接toSerialized(),使得线程安全
        subject = PublishSubject.create().toSerialized();
        //rxjava1 SerializedSubject是线程安全的
//        subject = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }
    //发送消息
    public void post(Object object) {
        subject.onNext(object);
    }

    private  <T> Observable<T> toObservable(final Class<T> type) {
        return subject.ofType(type);
    }

    public  <T> Disposable toDisposable(Class<T> type, Consumer<T> consumer) {
        return RxBus.getInstance()
                .toObservable(type)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }
}