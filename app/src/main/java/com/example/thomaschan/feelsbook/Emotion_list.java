package com.example.thomaschan.feelsbook;


import android.os.Parcel;
import android.os.Parcelable;


import java.util.ArrayList;

public class Emotion_list {

    private ArrayList<Emotion> EmotionArray;
    private Integer count_sad = 0;
    private Integer count_joy = 0;
    private Integer count_fear = 0;
    private Integer count_anger = 0;
    private Integer count_surprise = 0;
    private Integer count_love = 0;


    public Emotion_list(){
        EmotionArray = new ArrayList<Emotion>();
    }


    public void addEmotion(Emotion emotion){
        EmotionArray.add(0, emotion);
    }

    public void removeEmotion(int index){
        this.EmotionArray.remove(index);
    }

    public Emotion getEmotion(int index){
        return this.EmotionArray.get(index);
    }

    public void updateEmotion(int index, Emotion emotion){
        EmotionArray.set(index,emotion);
    }

    public void update_counter(int value,String emotion){
        if (emotion.equals("Sad")) {
            if ((this.count_sad - 1) >= -1) {
                this.count_sad += value;
                System.out.println(count_sad);
            }
        }
        else if (emotion.equals("Love")) {
            if ((this.count_love - 1) >= -1) {
                this.count_love += value;
            }
        }
        else if (emotion.equals("Surprise")) {
            if ((this.count_surprise-1) >= -1) {
                this.count_surprise += value;
            }
        }
        else if (emotion.equals("Anger")) {
            if ((this.count_anger-1) >= -1) {
                this.count_anger += value;
            }
        }
        else if (emotion.equals("Fear")) {
            if ((this.count_fear -1) >= -1) {
                this.count_fear += value;
            }
        }
        else if (emotion.equals("Joy")) {
            if ((this.count_joy-1) >= -1) {
                this.count_joy += value;
            }
        }

    }
    public Integer get_counter(String emotion_r){
        if (emotion_r.equals("Sad")){
            return this.count_sad;
        }
        else if (emotion_r.equals("Love")){
            return this.count_love;
        }
        else if (emotion_r.equals("Surprise")){
            return this.count_surprise;
        }
        else if (emotion_r.equals("Anger")){
            return this.count_anger;
        }
        else if (emotion_r.equals("Fear")){
            return this.count_fear;
        }
        else {
            return this.count_joy;
        }

    }

}