package com.mdground.yideguanregister.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Anamnesis implements Parcelable, Comparable<Anamnesis> {

    private int ClinicID;

    private int DoctorID;

    private int PatientID;

    private int OPID;

    private int VisitID;

    private String DiagnosisName;

    private boolean FirstVisit;

    private int FirstVisitID;

    private Date VisitTime;

    public int getClinicID() {
        return ClinicID;
    }

    public void setClinicID(int clinicID) {
        ClinicID = clinicID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public int getOPID() {
        return OPID;
    }

    public void setOPID(int OPID) {
        this.OPID = OPID;
    }

    public int getVisitID() {
        return VisitID;
    }

    public void setVisitID(int visitID) {
        VisitID = visitID;
    }

    public String getDiagnosisName() {
        return DiagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        DiagnosisName = diagnosisName;
    }

    public boolean isFirstVisit() {
        return FirstVisit;
    }

    public void setFirstVisit(boolean firstVisit) {
        FirstVisit = firstVisit;
    }

    public int getFirstVisitID() {
        return FirstVisitID;
    }

    public void setFirstVisitID(int firstVisitID) {
        FirstVisitID = firstVisitID;
    }

    public Date getVisitTime() {
        return VisitTime;
    }

    public void setVisitTime(Date visitTime) {
        VisitTime = visitTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ClinicID);
        dest.writeInt(this.DoctorID);
        dest.writeInt(this.PatientID);
        dest.writeInt(this.OPID);
        dest.writeInt(this.VisitID);
        dest.writeString(DiagnosisName);
        dest.writeInt(this.FirstVisit ? 1 : 0);
        dest.writeInt(this.FirstVisitID);
        dest.writeLong(VisitTime != null ? VisitTime.getTime() : -1);
    }

    public Anamnesis() {
    }

    protected Anamnesis(Parcel in) {
        this.ClinicID = in.readInt();
        this.DoctorID = in.readInt();
        this.PatientID = in.readInt();
        this.OPID = in.readInt();
        this.VisitID = in.readInt();
        this.DiagnosisName = in.readString();
        this.FirstVisit = in.readInt() == 1 ? true : false;
        this.FirstVisitID = in.readInt();
        this.VisitTime = new Date(in.readLong());
    }

    public static final Parcelable.Creator<Anamnesis> CREATOR = new Parcelable.Creator<Anamnesis>() {
        public Anamnesis createFromParcel(Parcel source) {
            return new Anamnesis(source);
        }

        public Anamnesis[] newArray(int size) {
            return new Anamnesis[size];
        }
    };

    @Override
    public int compareTo(Anamnesis another) {
        float discrepancy = another.getVisitTime().getTime() - this.getVisitTime().getTime();
        if (discrepancy == 0) {
            return 0;
        }
        if (discrepancy > 0) {
            return 1;
        }
        if (discrepancy < 0) {
            return -1;
        }
        return 0;
//        return (int) (another.getVisitTime().getTime() - this.getVisitTime().getTime());
    }
}
