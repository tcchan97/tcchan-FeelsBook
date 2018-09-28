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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageButton BT1;
    ImageButton BT2;
    ImageButton BT3;
    ImageButton BT4;
    ImageButton BT5;
    ImageButton BT6;
    EditText message;


    TextView BT1C;
    TextView BT2C;
    TextView BT3C;
    TextView BT4C;
    TextView BT5C;
    TextView BT6C;

    Sad Sad_C =  new Sad();
    Love Love_C = new Love();
    Surprise Surprise_C = new Surprise();
    Anger Anger_C = new Anger();
    Fear Fear_C = new Fear();
    Joy Joy_C = new Joy();


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T:'HH:mm:ss", Locale.CANADA);



    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BT1 = (ImageButton) findViewById(R.id.sad_bt);
        BT2 = (ImageButton) findViewById(R.id.love_bt);
        BT3 = (ImageButton) findViewById(R.id.surprised_bt);
        BT4 = (ImageButton) findViewById(R.id.angry_bt);
        BT5 = (ImageButton) findViewById(R.id.fear_bt);
        BT6 = (ImageButton) findViewById(R.id.joy_bt);

        BT1C = (TextView) findViewById(R.id.sad_counter);
        BT2C = (TextView) findViewById(R.id.love_counter);
        BT3C = (TextView) findViewById(R.id.surprise_counter);
        BT4C = (TextView) findViewById(R.id.anger_counter);
        BT5C = (TextView) findViewById(R.id.fear_counter);
        BT6C = (TextView) findViewById(R.id.joy_counter);


        lv = (ListView) findViewById(R.id.emotion_list);
        message = (EditText) findViewById(R.id.comment);


        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        onBtnClick(BT1,Sad_C,BT1C);
        onBtnClick(BT2,Love_C,BT2C);
        onBtnClick(BT3,Surprise_C,BT3C);
        onBtnClick(BT4,Anger_C,BT4C);
        onBtnClick(BT5,Fear_C,BT5C);
        onBtnClick(BT6,Joy_C,BT6C);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                Object o = lv.getItemAtPosition(position);
                String message = (String)o;
                Intent container = new Intent(getApplicationContext(),PopActivity.class);
                container.putExtra("text_ms",message);
                startActivity(container);
            }
        });


    }

    public void onBtnClick(ImageButton button, final Emotion emotion_t, final TextView counter_t){


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


    }

}
