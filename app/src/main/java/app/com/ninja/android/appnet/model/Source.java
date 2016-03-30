package app.com.ninja.android.appnet.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source implements Parcelable {

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("client_id")
    @Expose
    private String clientId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Source() {
    }

    /**
     *
     * @param name
     * @param link
     * @param clientId
     */
    public Source(String link, String name, String clientId) {
        this.link = link;
        this.name = name;
        this.clientId = clientId;
    }

    /**
     *
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
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
     *     The clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     *
     * @param clientId
     *     The client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    protected Source(Parcel in) {
        link = in.readString();
        name = in.readString();
        clientId = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(link);
        dest.writeString(name);
        dest.writeString(clientId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Source> CREATOR = new Parcelable.Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };
}