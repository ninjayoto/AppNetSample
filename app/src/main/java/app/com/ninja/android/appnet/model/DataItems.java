package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataItems implements Parcelable {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     * No args constructor for use in serialization
     *
     */
    public DataItems() {
    }

    /**
     *
     * @param data
     * @param meta
     */
    public DataItems(Meta meta, List<Datum> data) {
        this.meta = meta;
        this.data = data;
    }

    /**
     *
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     *
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     *
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }


    protected DataItems(Parcel in) {
        meta = (Meta) in.readValue(Meta.class.getClassLoader());
        if (in.readByte() == 0x01) {
            data = new ArrayList<Datum>();
            in.readList(data, Datum.class.getClassLoader());
        } else {
            data = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
        if (data == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(data);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DataItems> CREATOR = new Parcelable.Creator<DataItems>() {
        @Override
        public DataItems createFromParcel(Parcel in) {
            return new DataItems(in);
        }

        @Override
        public DataItems[] newArray(int size) {
            return new DataItems[size];
        }
    };
}