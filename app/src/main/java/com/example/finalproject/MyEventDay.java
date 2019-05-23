package com.example.finalproject;

import android.os.Parcel;
import android.os.Parcelable;

import com.applandeo.materialcalendarview.EventDay;
import java.util.Calendar;

class MyEventDay extends EventDay implements Parcelable {
    private String mNote;
    private String mIssueName; //alterar para tipo Issue?
    private double mHourLog; //qtd hora logada

    MyEventDay(Calendar day, int imageResource, String note, String issueName/*, double hourLog*/) {
        super(day, imageResource);
        mNote = note;
        mIssueName = issueName;
        //mHourLog = hourLog;
    }

    String getNote() {
        return mNote;
    }

    String getIssueName() {
        return mIssueName;
    }

    /*
    String getHourLog(){
        return mHourLog;
    }
    */

    private MyEventDay(Parcel in) {
        super((Calendar) in.readSerializable(), in.readInt());
        mNote = in.readString();
        mIssueName = in.readString();
        //mHourLog = in.readDouble();
    }

    public static final Creator<MyEventDay> CREATOR = new Creator<MyEventDay>() {
        @Override
        public MyEventDay createFromParcel(Parcel in) {
            return new MyEventDay(in);
        }

        @Override
        public MyEventDay[] newArray(int size) {
            return new MyEventDay[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(getCalendar());
        parcel.writeInt(getImageResource());
        parcel.writeString(mNote);
        parcel.writeString(mIssueName);
        //parcel.writeDouble(mHourLog);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
