package com.bytedance.component.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Switch switch1 = findViewById(R.id.switch1);
        final TextView tv1 = findViewById(R.id.text_center);
        final ImageView iv1 = findViewById(R.id.image1);

        RadioGroup rg = findViewById(R.id.rgSex);
        final RadioButton happy = findViewById(R.id.happy);
        final RadioButton sad = findViewById(R.id.sad);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String msg = "";
                if(happy.getId()==checkedId){
                    msg = "今天的心情："+happy.getText().toString();
                    Log.d("MainActivity","radio-happy");
                }
                if(sad.getId()==checkedId){
                    msg = "今天的心情："+sad.getText().toString();
                    Log.d("MainActivity","radio-sad");
                }
                tv1.setText(msg);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("you are good too!");
                Log.d("MainActivity","text-good");
            }

        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    iv1.setImageResource(R.drawable.hany);
                    Log.d("MainActivity","image-hany");
                }else{
                    iv1.setImageResource(R.drawable.rubbish);
                    Log.d("MainActivity","image-rubbish");
                }
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("ouch!");
                Log.d("MainActivity","image-click-quick");
            }

        });
    }
}
