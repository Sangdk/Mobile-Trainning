package com.rikkei.training.reactiveprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    //    private Disposable disposable;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //observable
        Observable<String> footballPlayerObservable = getFootballPlayerObservable();
//
//        //observer
//        Observer<String> footballPlayerObserver = getFootballPlayerObserver();

        DisposableObserver<String> mPlayersObserver = getMPlayerObserver();

        DisposableObserver<String> rPlayersObserver = getRPlayerObserver();

        //observer subscribing to observable
//        footballPlayerObservable
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(footballPlayerObserver);

        compositeDisposable.add(
                footballPlayerObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(new Predicate<String>() {
                            @Override
                            public boolean test(String s) throws Exception {
                                return s.toLowerCase().startsWith("m");
                            }
                        })
                        .subscribeWith(mPlayersObserver)
        );

        compositeDisposable.add(
                footballPlayerObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(new Predicate<String>() {
                            @Override
                            public boolean test(String s) throws Exception {
                                return s.toLowerCase().startsWith("r");
                            }
                        })
                        .map(new Function<String, String>() {
                            @Override
                            public String apply(String s) throws Exception {
                                return s.toUpperCase();
                            }
                        })
                        .subscribeWith(rPlayersObserver));


    }

    //    private Observer<String> getFootballPlayerObserver() {
//        return new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "on Subscriber");
//                disposable = d;
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "Name: " + s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "on Error: " + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "on Complete");
//            }
//        };
//    }
//
    private Observable<String> getFootballPlayerObservable() {
        return io.reactivex.Observable.just("Messi", "Ronaldo", "Modric", "Salah");
    }

    private DisposableObserver<String> getMPlayerObserver() {
        return new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "Name: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "on Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "on Complete");
            }
        };
    }

    private DisposableObserver<String> getRPlayerObserver() {
        return new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Log.d(TAG, "Name: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "on Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "on Complete");
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        disposable.dispose();
        compositeDisposable.clear();
    }
}
