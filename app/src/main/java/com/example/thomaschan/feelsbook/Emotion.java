package com.example.thomaschan.feelsbook;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Emotion {
    private String emotion;
    private String ID;
    private Calendar R_time;
    private String messsage;


    public Emotion(){
        this.R_time = Calendar.getInstance();
        this.R_time.setTime(new Date());


    }



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

    public void setMesssage(String messsage){
        this.messsage = messsage;
    }

    public String getMesssage(){
        return this.messsage;
    }


    public Date getDate(){
        return this.R_time.getTime();
    }
    public void setDate(int year, int month, int day, int hour, int minute, int second){
        this.R_time.set(year,month,day,hour,minute,second);
    }


}
