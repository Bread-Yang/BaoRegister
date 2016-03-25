package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yoghourt on 1/13/16.
 */
public class ReturnRecord implements Parcelable {

    private int SaleID;

    private int SaleQuantity;

    public ReturnRecord() {

    }

    protected ReturnRecord(Parcel in) {
        SaleID = in.readInt();
        SaleQuantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(SaleID);
        dest.writeInt(SaleQuantity);
    }

    public static final Creator<ReturnRecord> CREATOR = new Creator<ReturnRecord>() {
        @Override
        public ReturnRecord createFromParcel(Parcel in) {
            return new ReturnRecord(in);
        }

        @Override
        public ReturnRecord[] newArray(int size) {
            return new ReturnRecord[size];
        }
    };

    public int getSaleID() {
        return SaleID;
    }

    public void setSaleID(int saleID) {
        SaleID = saleID;
    }

    public int getSaleQuantity() {
        return SaleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        SaleQuantity = saleQuantity;
    }


    @Override
    public int describeContents() {
        return 0;
    }
}
