package com.example.comtesting.atomtry.utils;

import java.util.concurrent.Callable;

import javax.xml.transform.Transformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import retrofit2.Response;

/**
 * Created by atom on 2017/3/22.
 * Rxjava工具类
 */

public class RxjavaFactory {
    /**
     * 优雅的处理Rx的异常并返回
     * @param <T>
     */
    public static class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
        @Override
        public Observable<T> apply(Throwable throwable) throws Exception {
            return Observable.error(ExceptionUtils.handleException(throwable));
        }
    }

    /**
     * 简化的操作，发布者IO线程，订阅者UI线程
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> io_main_trasformer(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 单元测试的时候，利用RxJavaPlugins将io线程转换为trampoline
     * trampoline应该是立即执行的意思（待商榷），替代了Rx1的immediate。
     */
    public static void asyncToSync() {
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
//        RxAndroidPlugins.reset();
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
//            @Override
//            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
//                return Schedulers.trampoline();
//            }
//        });
    }



}
