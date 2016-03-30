package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoverImage implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("height")
    @Expose
    private Integer height;

    /**
     * No args constructor for use in serialization
     *
     */
    public CoverImage() {
    }

    /**
     *
     * @param height
     * @param isDefault
     * @param width
     * @param url
     */
    public CoverImage(String url, Integer width, Boolean isDefault, Integer height) {
        this.url = url;
        this.width = width;
        this.isDefault = isDefault;
        this.height = height;
    }

    /**
     *
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     *     The isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *
     * @param isDefault
     *     The is_default
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }


    protected CoverImage(Parcel in) {
        url = in.readString();
        width = in.readByte() == 0x00 ? null : in.readInt();
        byte isDefaultVal = in.readByte();
        isDefault = isDefaultVal == 0x02 ? null : isDefaultVal != 0x00;
        height = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        if (width == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(width);
        }
        if (isDefault == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isDefault ? 0x01 : 0x00));
        }
        if (height == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(height);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CoverImage> CREATOR = new Parcelable.Creator<CoverImage>() {
        @Override
        public CoverImage createFromParcel(Parcel in) {
            return new CoverImage(in);
        }

        @Override
        public CoverImage[] newArray(int size) {
            return new CoverImage[size];
        }
    };
}