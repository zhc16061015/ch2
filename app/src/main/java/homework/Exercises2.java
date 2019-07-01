package homework;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.exercise2,null);
        TextView tv1 = findViewById(R.id.textviewup);
        tv1.setText("总view数为:"+getViewCount(view));
    }

    public static int getViewCount(View view) {
        int num = 0;
        if(view==null){
            return 0;
        }
        if (view instanceof ViewGroup) {
            num++;
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View vw1 = ((ViewGroup) view).getChildAt(i);
                if (vw1 instanceof ViewGroup) {
                    num += getViewCount(vw1);
                } else {
                    num++;
                }
            }
        }
        return num;
    }
}
