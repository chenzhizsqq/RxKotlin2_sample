package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //そばの数
        val list = listOf(1, 2, 3, 4) //→listも拡張されたRxKotlinのインターフェースのため、ReactiveX仕様のメソッドを持つ

        list.toObservable()
            .subscribeBy(
                onNext = {
                    Log.e(TAG, "onNext begin !!!", )
                    //受け取ったデータを出力する（掛け声を変える）
                    if(it%2 != 0) {
                        Log.e(TAG,it.toString() + "杯目食べました！はい、ドンドン〜");
                    } else {
                        Log.e(TAG,it.toString() + "杯目食べました！はい、じゃんじゃん〜");
                    }
                },
                onError =  { it.printStackTrace() },
                onComplete = { Log.e(TAG,"あなたはお椀を閉じました！")}
            )

    }
}