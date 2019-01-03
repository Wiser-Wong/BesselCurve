package com.wiser.beseelcurveanim.sbessel;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;

public class ControlPoint extends Point implements Parcelable {

    public float x;
    public float y;

    public ControlPoint() {
    }

    public ControlPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private ControlPoint(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }

    public static final Creator<ControlPoint> CREATOR = new Creator<ControlPoint>() {
        @Override
        public ControlPoint createFromParcel(Parcel in) {
            return new ControlPoint(in);
        }

        @Override
        public ControlPoint[] newArray(int size) {
            return new ControlPoint[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(x);
        dest.writeFloat(y);
    }
}
