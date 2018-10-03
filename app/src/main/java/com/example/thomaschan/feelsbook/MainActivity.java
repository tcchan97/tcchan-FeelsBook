package com.example.thomaschan.feelsbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private EditText message;

    //Created Buttons
    private TextView BT1C;
    private TextView BT2C;
    private TextView BT3C;
    private TextView BT4C;
    private TextView BT5C;
    private TextView BT6C;

    //Format used for the date
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T:'HH:mm:ss", Locale.CANADA);

    //Creating Arrays and Listviews
    private ListView lv;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private Emotion_list emotionArray;
    private Integer returnpostion;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the counters on screen
        BT1C = findViewById(R.id.sad_counter);
        BT2C = findViewById(R.id.love_counter);
        BT3C = findViewById(R.id.surprise_counter);
        BT4C = findViewById(R.id.anger_counter);
        BT5C = findViewById(R.id.fear_counter);
        BT6C = findViewById(R.id.joy_counter);

        //Initialize the Listview and message
        lv = findViewById(R.id.emotion_list);
        message = findViewById(R.id.comment);

        //Load the data from gson and set the emotion counter
        loadData();
        setemotioncount();

        //Create an adapter for the Listview
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //When an Item on the List view is clicked
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                returnpostion = position;
                //Create a new popup window and pass the emotion array into the next screen using Intent
                Intent container = new Intent(getApplicationContext(),PopActivity.class);
                container.putExtra("transfer_data", emotionArray.getEmotion(position));
                startActivityForResult(container,1);
            }


        });
        //When an item is clicked and held for a while it will remove the item in the Emotion array
        //and Listview array
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                arrayList.remove(position);
                emotionArray.update_counter(-1, (emotionArray.getEmotion(position).getEmotion()));
                emotionArray.removeEmotion(position);
                adapter.notifyDataSetChanged();
                setemotioncount();
                saveData();
                return true;
            }
        });

    }

    //Private function that will save the data when called
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson =  new Gson();
        Gson gson2 = new Gson();
        //Store arrayList and Emotion list into json
        String json = gson.toJson(arrayList);
        String json2 = gson.toJson(emotionArray);
        editor.putString("emotion array", json2);
        editor.putString("array list", json);
        editor.apply();
    }
    //Private function to load the data when called
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json2  = sharedPreferences.getString("emotion array", null);
        String json = sharedPreferences.getString("array list", null);
        Type type2 = new TypeToken<Emotion_list>(){}.getType();
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        //return data back into the arrays
        arrayList = gson.fromJson(json, type);
        emotionArray = gson.fromJson(json2,type2);

        if (arrayList == null){
            arrayList = new ArrayList<String>();
        }
        if (emotionArray == null){
            emotionArray = new Emotion_list();
        }
    }
    //This will update the counters when called
    public void setemotioncount(){
        BT1C.setText(emotionArray.get_counter("Sad").toString());
        BT2C.setText(emotionArray.get_counter("Love").toString());
        BT3C.setText(emotionArray.get_counter("Surprise").toString());
        BT4C.setText(emotionArray.get_counter("Anger").toString());
        BT5C.setText(emotionArray.get_counter("Fear").toString());
        BT6C.setText(emotionArray.get_counter("Joy").toString());
    }

    //When either of the 6 emotions are clicked it will create an Emotion Object for them and add them into the
    //Emotion array and List view array to display on screen.
    public void addEmotion(View view){
        Emotion emotion = new Emotion();
        String name = view.getTag().toString();
        emotion.setEmotion(name);
        emotionArray.addEmotion(emotion);

        //Updates the counters for each emotion and update the counters on screen
        emotionArray.update_counter(1,name);
        setemotioncount();

        emotion.setMesssage(message.getText().toString());
        //Create a string to deploy into the listview
        String result = "Emotion: "+(emotion.getEmotion()) + "\nComment: "+ (emotion.getMesssage())
                + "\nDate: "+(sdf.format(emotion.getDate()));
        arrayList.add(0,result);
        //Notify that the screen needed updating to display the information
        adapter.notifyDataSetChanged();
        message.setText(null);
        saveData();



    }
    //Return the values from the popup activity and update the information in the list view.
    //This is when the users is done editing a emotions history  and the screen needs to update with the new
    //information
        public void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode,resultCode,data);
            if (requestCode == 1){
                if (resultCode == RESULT_OK){
                    Emotion newEmotion = data.getParcelableExtra("return_data");
                    String result = "Emotion: "+(newEmotion.getEmotion()) + "\nComment: "+ (newEmotion.getMesssage())
                            + "\nDate: "+(sdf.format(newEmotion.getDate()));
                    arrayList.set(returnpostion,result);
                    emotionArray.updateEmotion(returnpostion,newEmotion);
                    adapter.notifyDataSetChanged();
                    saveData();

                }
            }
        }


}
