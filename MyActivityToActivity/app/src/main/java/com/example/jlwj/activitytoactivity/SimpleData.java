package com.example.jlwj.activitytoactivity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */

public class SimpleData implements Parcelable {

    String name;
    String phone;

    public SimpleData(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public SimpleData(Parcel src){
        name = src.readString();
        phone = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        @Override
        public SimpleData createFromParcel(Parcel source) {
            return new SimpleData(source);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);

    }
}
