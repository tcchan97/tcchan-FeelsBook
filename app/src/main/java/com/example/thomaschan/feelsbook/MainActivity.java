package com.example.thomaschan.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText message;


    private TextView BT1C;
    private TextView BT2C;
    private TextView BT3C;
    private TextView BT4C;
    private TextView BT5C;
    private TextView BT6C;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T:'HH:mm:ss", Locale.CANADA);


    private ListView lv;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private Emotion_list emotionArray;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BT1C = (TextView) findViewById(R.id.sad_counter);
        BT2C = (TextView) findViewById(R.id.love_counter);
        BT3C = (TextView) findViewById(R.id.surprise_counter);
        BT4C = (TextView) findViewById(R.id.anger_counter);
        BT5C = (TextView) findViewById(R.id.fear_counter);
        BT6C = (TextView) findViewById(R.id.joy_counter);


        lv = (ListView) findViewById(R.id.emotion_list);
        message = (EditText) findViewById(R.id.comment);

        emotionArray = new Emotion_list();

        arrayList = new ArrayList<String>();


        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                Object o = lv.getItemAtPosition(position);
               // String message = (String)o;
                Intent container = new Intent(getApplicationContext(),PopActivity.class);
                container.putExtra("emotion_ob", emotionArray);
                startActivity(container);
            }
        });


    }

    public void addEmotion(View view){
        Emotion emotion = new Emotion();
        String name = view.getTag().toString();
        emotion.setEmotion(name);

        emotionArray.addEmotion(emotion);
        //BT2C.setText(emotion.getEmotion());

        if (emotion.getEmotion().equals("Sad")){
            emotionArray.update_counter("Sad");
            BT1C.setText(emotionArray.get_counter("Sad").toString());
        }
        else if (emotion.getEmotion().equals("Love")){
            emotionArray.update_counter("Love");
            BT2C.setText(emotionArray.get_counter("Love").toString());
        }
        else if(emotion.getEmotion().equals("Surprise")){
            emotionArray.update_counter("Surprise");
            BT3C.setText(emotionArray.get_counter("Surprise").toString());
        }
        else if(emotion.getEmotion().equals("Anger")){
            emotionArray.update_counter("Anger");
            BT4C.setText(emotionArray.get_counter("Anger").toString());
        }
        else if(emotion.getEmotion().equals("Fear")){
            emotionArray.update_counter("Fear");
            BT5C.setText(emotionArray.get_counter("Fear").toString());
        }
        else if(emotion.getEmotion().equals("Joy")){
            emotionArray.update_counter("Joy");
            BT6C.setText(emotionArray.get_counter("Joy").toString());
        }

        emotion.setMesssage(message.getText().toString());
        String result = "Emotion: "+(emotion.getEmotion()) + "\nComment: "+ (emotion.getMesssage())
                + "\nDate: "+(sdf.format(emotion.getDate()));
        arrayList.add(0,result);
        adapter.notifyDataSetChanged();
        message.setText(null);


    }


    /*
    public void onBtnClick(View view){


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emotion = view.getTag().toString();

                /*
                emotion_t.updateCounter();
                int CID = emotion_t.getCounter();
                String SCID = String.valueOf(CID);
                counter_t.setText(SCID);
                String result = "Emotion: "+(emotion_t.getEmotion()) + "\nComment: "+ (message.getText().toString())
                        + "\nDate: " + sdf.format(new Date());
                arrayList.add(0,result);
                adapter.notifyDataSetChanged();
                message.setText(null);

            }
        });


    } */

}
