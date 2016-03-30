package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts implements Parcelable {

    @SerializedName("following")
    @Expose
    private Integer following;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("stars")
    @Expose
    private Integer stars;

    /**
     * No args constructor for use in serialization
     *
     */
    public Counts() {
    }

    /**
     *
     * @param followers
     * @param following
     * @param stars
     * @param posts
     */
    public Counts(Integer following, Integer posts, Integer followers, Integer stars) {
        this.following = following;
        this.posts = posts;
        this.followers = followers;
        this.stars = stars;
    }

    /**
     *
     * @return
     *     The following
     */
    public Integer getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     *     The following
     */
    public void setFollowing(Integer following) {
        this.following = following;
    }

    /**
     *
     * @return
     *     The posts
     */
    public Integer getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     *     The posts
     */
    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    /**
     *
     * @return
     *     The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     *     The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     *     The stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     *
     * @param stars
     *     The stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }


    protected Counts(Parcel in) {
        following = in.readByte() == 0x00 ? null : in.readInt();
        posts = in.readByte() == 0x00 ? null : in.readInt();
        followers = in.readByte() == 0x00 ? null : in.readInt();
        stars = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (following == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(following);
        }
        if (posts == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(posts);
        }
        if (followers == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(followers);
        }
        if (stars == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(stars);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Counts> CREATOR = new Parcelable.Creator<Counts>() {
        @Override
        public Counts createFromParcel(Parcel in) {
            return new Counts(in);
        }

        @Override
        public Counts[] newArray(int size) {
            return new Counts[size];
        }
    };
}