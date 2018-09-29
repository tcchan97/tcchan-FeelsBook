package com.example.thomaschan.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.StringTokenizer;

public class PopActivity extends AppCompatActivity {

    private TextView popmsg;
    private TextView popdate;
    //private Emotion_list classob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.5));


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        popmsg = (TextView) findViewById(R.id.message_msg);
        popdate = (TextView) findViewById(R.id.message_date);
        Intent emotion_c = getIntent();
        //Emotion_list emotionArray = (Emotion_list) emotion_c.getSerializableExtra("emotion_ob");
        //popmsg.setText((emotionArray.getEmotion(0).getEmotion()));
        /*
        if (num_element.equals("6")) {
            popmsg.setText(newtext[3]);
            popdate.setText(newtext[5]);
        }
        else{
            popmsg.setText(null);
            popdate.setText(newtext[4]);
        }
        */
        getWindow().setAttributes(params);


    }
}
