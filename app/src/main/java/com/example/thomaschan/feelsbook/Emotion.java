package com.example.thomaschan.feelsbook;

import android.widget.EditText;
import android.widget.ImageButton;

public class Emotion {
    private String emotion;
    private String ID;
    private String count_id;
    private int counter = 0;



    public String getEmotion() {
        return this.emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setID(String Tag) {
        this.ID = Tag;
    }

    public String getID() {
        return this.ID;
    }

    public String getCount_id(){
        return this.count_id;
    }

    public void setCount_id(String Tag){
        this.count_id = Tag;
    }

    public void updateCounter(){
        this.counter += 1;
    }

    public int getCounter(){
        return this.counter;
    }


}
