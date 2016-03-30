package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("len")
    @Expose
    private Integer len;

    /**
     * No args constructor for use in serialization
     *
     */
    public Link() {
    }

    /**
     *
     * @param text
     * @param len
     * @param url
     * @param pos
     */
    public Link(String url, String text, Integer pos, Integer len) {
        this.url = url;
        this.text = text;
        this.pos = pos;
        this.len = len;
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
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     *     The pos
     */
    public Integer getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     *     The pos
     */
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     *     The len
     */
    public Integer getLen() {
        return len;
    }

    /**
     *
     * @param len
     *     The len
     */
    public void setLen(Integer len) {
        this.len = len;
    }


    protected Link(Parcel in) {
        url = in.readString();
        text = in.readString();
        pos = in.readByte() == 0x00 ? null : in.readInt();
        len = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(text);
        if (pos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(pos);
        }
        if (len == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(len);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };
}