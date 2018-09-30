package com.example.thomaschan.feelsbook;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Calendar;
import java.util.Date;


public class Emotion implements Parcelable {
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


    public void setMesssage(String messsage){
        this.messsage = messsage;
    }

    public String getMesssage(){
        return this.messsage;
    }

    public Integer getDay() {
        return this.R_time.get(Calendar.DAY_OF_MONTH);
    }

    public Integer getMonth() {
        return this.R_time.get(Calendar.MONTH);
    }
    public Integer getYear() {
        return this.R_time.get(Calendar.YEAR);
}
    public Integer getHour(){
        return this.R_time.get(Calendar.HOUR_OF_DAY);
    }

    public Integer getMinute(){
        return this.R_time.get(Calendar.MINUTE);
    }


    public Date getDate(){
        return this.R_time.getTime();
    }
    public void setDate(int year, int month, int day, int hour, int minute){
        this.R_time.set(year,month,day,hour,minute);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.emotion);
        dest.writeString(this.ID);
        dest.writeSerializable(this.R_time);
        dest.writeString(this.messsage);
    }

    protected Emotion(Parcel in) {
        this.emotion = in.readString();
        this.ID = in.readString();
        this.R_time = (Calendar) in.readSerializable();
        this.messsage = in.readString();
    }

    public static final Parcelable.Creator<Emotion> CREATOR = new Parcelable.Creator<Emotion>() {
        @Override
        public Emotion createFromParcel(Parcel source) {
            return new Emotion(source);
        }

        @Override
        public Emotion[] newArray(int size) {
            return new Emotion[size];
        }
    };
}
