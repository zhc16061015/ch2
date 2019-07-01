package homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise1);
        System.out.println("onCreate ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy ");
    }

}
