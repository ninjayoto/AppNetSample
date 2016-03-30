package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @SerializedName("cover_image")
    @Expose
    private CoverImage coverImage;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("counts")
    @Expose
    private Counts counts;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param id
     * @param timezone
     * @param avatarImage
     * @param username
     * @param canonicalUrl
     * @param createdAt
     * @param locale
     * @param name
     * @param counts
     * @param type
     * @param coverImage
     */
    public User(String username, AvatarImage avatarImage, String name, String locale, String createdAt, String canonicalUrl, CoverImage coverImage, String timezone, Counts counts, String type, String id) {
        this.username = username;
        this.avatarImage = avatarImage;
        this.name = name;
        this.locale = locale;
        this.createdAt = createdAt;
        this.canonicalUrl = canonicalUrl;
        this.coverImage = coverImage;
        this.timezone = timezone;
        this.counts = counts;
        this.type = type;
        this.id = id;
    }

    /**
     *
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     *     The avatarImage
     */
    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    /**
     *
     * @param avatarImage
     *     The avatar_image
     */
    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     *     The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     *     The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     *
     * @param canonicalUrl
     *     The canonical_url
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     *
     * @return
     *     The coverImage
     */
    public CoverImage getCoverImage() {
        return coverImage;
    }

    /**
     *
     * @param coverImage
     *     The cover_image
     */
    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    /**
     *
     * @return
     *     The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     *     The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     *     The counts
     */
    public Counts getCounts() {
        return counts;
    }

    /**
     *
     * @param counts
     *     The counts
     */
    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }


    protected User(Parcel in) {
        username = in.readString();
        avatarImage = (AvatarImage) in.readValue(AvatarImage.class.getClassLoader());
        name = in.readString();
        locale = in.readString();
        createdAt = in.readString();
        canonicalUrl = in.readString();
        coverImage = (CoverImage) in.readValue(CoverImage.class.getClassLoader());
        timezone = in.readString();
        counts = (Counts) in.readValue(Counts.class.getClassLoader());
        type = in.readString();
        id = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeValue(avatarImage);
        dest.writeString(name);
        dest.writeString(locale);
        dest.writeString(createdAt);
        dest.writeString(canonicalUrl);
        dest.writeValue(coverImage);
        dest.writeString(timezone);
        dest.writeValue(counts);
        dest.writeString(type);
        dest.writeString(id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}