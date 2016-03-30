package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Entities implements Parcelable {

    @SerializedName("mentions")
    @Expose
    private List<Object> mentions = new ArrayList<Object>();
    @SerializedName("hashtags")
    @Expose
    private List<Object> hashtags = new ArrayList<Object>();
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Entities() {
    }

    /**
     *
     * @param links
     * @param hashtags
     * @param mentions
     */
    public Entities(List<Object> mentions, List<Object> hashtags, List<Link> links) {
        this.mentions = mentions;
        this.hashtags = hashtags;
        this.links = links;
    }

    /**
     *
     * @return
     *     The mentions
     */
    public List<Object> getMentions() {
        return mentions;
    }

    /**
     *
     * @param mentions
     *     The mentions
     */
    public void setMentions(List<Object> mentions) {
        this.mentions = mentions;
    }

    /**
     *
     * @return
     *     The hashtags
     */
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     *
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     *
     * @return
     *     The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }


    protected Entities(Parcel in) {
        if (in.readByte() == 0x01) {
            mentions = new ArrayList<Object>();
            in.readList(mentions, Object.class.getClassLoader());
        } else {
            mentions = null;
        }
        if (in.readByte() == 0x01) {
            hashtags = new ArrayList<Object>();
            in.readList(hashtags, Object.class.getClassLoader());
        } else {
            hashtags = null;
        }
        if (in.readByte() == 0x01) {
            links = new ArrayList<Link>();
            in.readList(links, Link.class.getClassLoader());
        } else {
            links = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mentions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mentions);
        }
        if (hashtags == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(hashtags);
        }
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Entities> CREATOR = new Parcelable.Creator<Entities>() {
        @Override
        public Entities createFromParcel(Parcel in) {
            return new Entities(in);
        }

        @Override
        public Entities[] newArray(int size) {
            return new Entities[size];
        }
    };
}