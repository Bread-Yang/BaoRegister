package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Provider implements Parcelable{

    private int ClinicID;
    private int ProviderID;
    private String ProviderName;
    private int ProviderSort;
    private int UpdatedBy;

    public Provider() {
    }

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    public int getProviderSort() {
        return ProviderSort;
    }

    public void setProviderSort(int providerSort) {
        ProviderSort = providerSort;
    }

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ClinicID);
        dest.writeInt(ProviderID);
        dest.writeString(ProviderName);
        dest.writeInt(ProviderSort);
        dest.writeInt(UpdatedBy);
    }

    protected Provider(Parcel in) {
        ClinicID = in.readInt();
        ProviderID = in.readInt();
        ProviderName = in.readString();
        ProviderSort = in.readInt();
        UpdatedBy = in.readInt();
    }

    public static final Creator<Provider> CREATOR = new Creator<Provider>() {
        @Override
        public Provider createFromParcel(Parcel in) {
            return new Provider(in);
        }

        @Override
        public Provider[] newArray(int size) {
            return new Provider[size];
        }
    };
}
