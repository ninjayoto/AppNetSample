package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable {

    @SerializedName("min_id")
    @Expose
    private String minId;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("max_id")
    @Expose
    private String maxId;
    @SerializedName("more")
    @Expose
    private Boolean more;

    /**
     * No args constructor for use in serialization
     *
     */
    public Meta() {
    }

    /**
     *
     * @param more
     * @param code
     * @param maxId
     * @param minId
     */
    public Meta(String minId, Integer code, String maxId, Boolean more) {
        this.minId = minId;
        this.code = code;
        this.maxId = maxId;
        this.more = more;
    }

    /**
     *
     * @return
     *     The minId
     */
    public String getMinId() {
        return minId;
    }

    /**
     *
     * @param minId
     *     The min_id
     */
    public void setMinId(String minId) {
        this.minId = minId;
    }

    /**
     *
     * @return
     *     The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     *     The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     *     The maxId
     */
    public String getMaxId() {
        return maxId;
    }

    /**
     *
     * @param maxId
     *     The max_id
     */
    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    /**
     *
     * @return
     *     The more
     */
    public Boolean getMore() {
        return more;
    }

    /**
     *
     * @param more
     *     The more
     */
    public void setMore(Boolean more) {
        this.more = more;
    }


    protected Meta(Parcel in) {
        minId = in.readString();
        code = in.readByte() == 0x00 ? null : in.readInt();
        maxId = in.readString();
        byte moreVal = in.readByte();
        more = moreVal == 0x02 ? null : moreVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(minId);
        if (code == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(code);
        }
        dest.writeString(maxId);
        if (more == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (more ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };
}