package com.sample.studyweb3j;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    //- 追加 テストクラスのインスタンス ----
    private TestWeb3 testWeb3;
    //--------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //- 追加 ECDSAアルゴリズムを利用するための設定 ----
        Web3Helper.SetupBouncyCastle();
        //-------------------------------------------------

        //- 追加 テストインスタンスの作成 -----------------
        testWeb3 = new TestWeb3( this );
        //-------------------------------------------------

        super.onCreate(savedInstanceState);
    }

    //- 追加 タッチイベント：押下されたらテスト処理を呼び出す -------
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if( event.getAction() == MotionEvent.ACTION_DOWN ){
            // ここでテストを呼び出す
            //Log.i( "StudyWeb3j", "@ DO SOMETHING!!" );

            // テストの呼び出し
            testWeb3.test();
        }

        return super.onTouchEvent(event);
    }
    //---------------------------------------------------------------
}
