package ca.qc.sol_td07.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Materials implements Parcelable {
    private List<Material> materials;

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.materials);
    }

    public void readFromParcel(Parcel source) {
        this.materials = source.createTypedArrayList(Material.CREATOR);
    }

    public Materials() {
    }

    protected Materials(Parcel in) {
        this.materials = in.createTypedArrayList(Material.CREATOR);
    }

    public static final Parcelable.Creator<Materials> CREATOR = new Parcelable.Creator<Materials>() {
        @Override
        public Materials createFromParcel(Parcel source) {
            return new Materials(source);
        }

        @Override
        public Materials[] newArray(int size) {
            return new Materials[size];
        }
    };
}