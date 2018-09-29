package com.example.thomaschan.feelsbook;

import java.io.Serializable;
import java.util.ArrayList;

public class Emotion_list implements Serializable {

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

    public Emotion getEmotion(int index){
        return EmotionArray.get(index);
    }

    public void update_counter(String emotion){
        if (emotion.equals("Sad")){
            this.count_sad += 1;
        }
        else if (emotion.equals("Love")){
            this.count_love += 1;
        }
        else if (emotion.equals("Surprise")){
            this.count_surprise += 1;
        }
        else if (emotion.equals("Anger")){
            this.count_anger += 1;
        }
        else if (emotion.equals("Fear")){
            this.count_fear += 1;
        }
        else if (emotion.equals("Joy")){
            this.count_joy += 1;
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
