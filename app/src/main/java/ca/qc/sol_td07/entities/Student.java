package ca.qc.sol_td07.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    public enum Grade {
        BEGINNER, INTERMEDIATE, ADVANCED
    }

    private int id;
    private String name;
    private Grade grade;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.grade == null ? -1 : this.grade.ordinal());
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        int tmpGrade = source.readInt();
        this.grade = tmpGrade == -1 ? null : Grade.values()[tmpGrade];
    }

    public Student() {
    }

    protected Student(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        int tmpGrade = in.readInt();
        this.grade = tmpGrade == -1 ? null : Grade.values()[tmpGrade];
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
