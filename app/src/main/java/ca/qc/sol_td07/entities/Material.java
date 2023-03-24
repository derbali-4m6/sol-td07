package ca.qc.sol_td07.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Material implements Parcelable {
    private int id;
    private String name;
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.category);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        this.category = source.readString();
    }

    public Material() {
    }

    public Material(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    protected Material(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.category = in.readString();
    }

    public static final Parcelable.Creator<Material> CREATOR = new Parcelable.Creator<Material>() {
        @Override
        public Material createFromParcel(Parcel source) {
            return new Material(source);
        }

        @Override
        public Material[] newArray(int size) {
            return new Material[size];
        }
    };
}
