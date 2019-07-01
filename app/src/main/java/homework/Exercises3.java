package homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    private String data[] = {"12","23","34","45"};
    //private myBean beanlist[];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Exercises3.this, "当前位置" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Exercises3.this, MainActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void getT(View view) {
        Intent intent = new Intent(Exercises3.this, MainActivity.class);
        startActivity(intent);
        if(view instanceof  ImageView){
            Toast.makeText(Exercises3.this, view.getId()+"", Toast.LENGTH_LONG).show();
        }
        else if(view instanceof  TextView){
            Toast.makeText(Exercises3.this, ((TextView) view).getText()+"", Toast.LENGTH_LONG).show();
        }else{

        }
    }

    public static class ListViewAdapter extends BaseAdapter {
        private List<myBean> beanlist = new ArrayList<>();
        private Context mContext;

        public ListViewAdapter(Context context) {
            init();
            mContext = context;
        }

        public void init(){
            myBean bean0 = new myBean(R.drawable.icon0, "子鼠","你好","22:37");
            beanlist.add(bean0);
            myBean bean1= new myBean(R.drawable.icon1, "丑牛","你真好","21:27");
            beanlist.add(bean1);
            myBean bean2 = new myBean(R.drawable.icon2, "寅虎","你好个屁","1秒钟前");
            beanlist.add(bean2);
            myBean bean3 = new myBean(R.drawable.icon3, "卯兔","计算机组成","5天前");
            beanlist.add(bean3);
            myBean bean4 = new myBean(R.drawable.icon4, "辰龙","面向对象","一块钱");
            beanlist.add(bean4);
            myBean bean5 = new myBean(R.drawable.icon5, "巳蛇","编译原理","7月1日");
            beanlist.add(bean5);
            myBean bean6 = new myBean(R.drawable.icon6, "午马","软件工程","五分钟之后");
            beanlist.add(bean6);
            myBean bean7 = new myBean(R.drawable.icon7, "未羊","数学分析","一千年以后");
            beanlist.add(bean7);
            myBean bean8 = new myBean(R.drawable.icon8, "申猴","大学物理","十年之前");
            beanlist.add(bean8);
            myBean bean9 = new myBean(R.drawable.icon9, "酉鸡","Ouch","我不认识你");
            beanlist.add(bean9);
        }
        @Override public int getCount() {
            return beanlist.size();
        }

        @Override public Object getItem(int position) {
            return null;
        }

        @Override public long getItemId(int position) {
            return 0;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                view = inflater.inflate(R.layout.im_list_item, null);
                Log.d("ListViewAdapter",
                        "getView() called with: position = [" + position + "], convertView = [" + convertView + "], parent = [" +
                                parent + "]");
            } else {
                view = convertView;
            }
            ImageView iv = view.findViewById(R.id.iv_avatar);
            TextView tv1 = view.findViewById(R.id.tv_title);
            TextView tv2 = view.findViewById(R.id.tv_description);
            TextView tv3 = view.findViewById(R.id.tv_time);
            iv.setImageResource(beanlist.get(position).getImageID());
            tv1.setText(beanlist.get(position).getName());
            tv2.setText(beanlist.get(position).getMessage());
            tv3.setText(beanlist.get(position).getTime());
            return view;
        }
    }
    public static class myBean {
        private String name;
        private String message;
        private String time;
        private int ImageID;


        public myBean(int imageID, String name, String message, String time){
            this.ImageID = imageID;
            this.name = name;
            this.message = message;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getImageID() {
            return ImageID;
        }

        public void setImageID(int imageID) {
            ImageID = imageID;
        }


    }
}

