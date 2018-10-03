package com.example.thomaschan.feelsbook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class PopActivity extends AppCompatActivity implements Serializable, Parcelable {

    private TextView popmsg;
    private TextView popDate;
    private TextView popTime;
    private Integer popDay;
    private Integer popMonth;
    private Integer popYear;
    private Integer popMinutes;
    private Integer popHours;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private TimePickerDialog.OnTimeSetListener monTimeSetListener;
    private SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
    private SimpleDateFormat sdftime = new SimpleDateFormat("HH:mm:ss", Locale.CANADA);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Create the popup window with set dimension
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.8),(int)(height*0.5));

        // Set the location of where the window appears
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        //Find the Id for the time, date, and message
        popTime = findViewById(R.id.Whole_time);
        popDate = findViewById(R.id.whole_date);
        popmsg = findViewById(R.id.message_msg);

        //Get the data thats transfered from Intent
        Emotion E_data = getIntent().getParcelableExtra("transfer_data");
        //Set the text for Date, Time, and message for the user to change
        popDate.setText(sdfdate.format(E_data.getDate()));
        popTime.setText(sdftime.format(E_data.getDate()));
        popmsg.setText(E_data.getMesssage());

        //Gets the Data broken up into specific dates.
        popYear = E_data.getYear();
        popMonth = E_data.getMonth();
        popDay = E_data.getDay();
        popHours = E_data.getHour();
        popMinutes = E_data.getMinute();


        //date widget that opens up when the date is clicked
        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                popYear = year;
                popMonth = month;
                popDay = day;
                month  = month +1;
                String date = year + "-" + month + "-"+ day;
                popDate.setText(date);
            }
        };
        //Time widget that opens up when the time is clicked
        monTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int Hour, int minute) {
                popHours = Hour;
                popMinutes = minute;
                String time = Hour +":"+ minute;

                popTime.setText(time);

            }
        };

        getWindow().setAttributes(params);





    }
    //Creates an Date widget for the view
    public void change_date(View view){
        Emotion E_data = getIntent().getParcelableExtra("transfer_data");
        DatePickerDialog dialog = new DatePickerDialog(
                PopActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDataSetListener,E_data.getYear(),E_data.getMonth(),E_data.getDay());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    //Creates an Time wiget for the view
    public void change_time(View view){
        Emotion E_data = getIntent().getParcelableExtra("transfer_data");
        TimePickerDialog dialog = new TimePickerDialog(
                PopActivity.this,
                monTimeSetListener,
                E_data.getHour(),
                E_data.getMinute(),
                DateFormat.is24HourFormat(this)
                );
        dialog.show();
    }


    //Save the results from when the user updates a emotions history in the list. Then
    //It will return this data back to the main activity to update the list view or emotion history.
    public void saveResults(View view){
        Emotion E_data = getIntent().getParcelableExtra("transfer_data");
        popmsg = findViewById(R.id.message_msg);
        E_data.setMesssage(popmsg.getText().toString());
        E_data.setDate(popYear,popMonth,popDay,popHours,popMinutes);

        Intent container = new Intent();
        container.putExtra("return_data",E_data);
        setResult(RESULT_OK,container);
        finish();
    }

    //All of this was created by the parcelable function addin inorder to make an emotion and
    //parcelable object.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.popDay);
        dest.writeValue(this.popMonth);
        dest.writeValue(this.popYear);
        dest.writeValue(this.popMinutes);
        dest.writeValue(this.popHours);
        dest.writeSerializable(this.sdfdate);
        dest.writeSerializable(this.sdftime);
    }

    public PopActivity() {
    }

    protected PopActivity(Parcel in) {
        this.popDay = (Integer) in.readValue(Integer.class.getClassLoader());
        this.popMonth = (Integer) in.readValue(Integer.class.getClassLoader());
        this.popYear = (Integer) in.readValue(Integer.class.getClassLoader());
        this.popMinutes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.popHours = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sdfdate = (SimpleDateFormat) in.readSerializable();
        this.sdftime = (SimpleDateFormat) in.readSerializable();
    }

    public static final Parcelable.Creator<PopActivity> CREATOR = new Parcelable.Creator<PopActivity>() {
        @Override
        public PopActivity createFromParcel(Parcel source) {
            return new PopActivity(source);
        }

        @Override
        public PopActivity[] newArray(int size) {
            return new PopActivity[size];
        }
    };
}
