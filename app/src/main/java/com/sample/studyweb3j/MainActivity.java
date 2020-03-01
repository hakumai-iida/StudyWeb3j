package com.sample.studyweb3j;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    // テストクラスのインスタンス
    private TestWeb3 testWeb3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        // ECDSAアルゴリズムを利用するための設定
        Web3Helper.SetupBouncyCastle();

        // テストインスタンスの作成
        testWeb3 = new TestWeb3( this );

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 画面がタップされたらテストを実行する
        if( event.getAction() == MotionEvent.ACTION_DOWN ){
            testWeb3.test();
        }

        return super.onTouchEvent(event);
    }
}
