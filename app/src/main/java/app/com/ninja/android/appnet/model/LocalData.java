package app.com.ninja.android.appnet.model;

import io.realm.RealmObject;

/**
 */
public class LocalData extends RealmObject{
    private String localUserName;
    private String localUserAvata;
    private String localPost;

    public LocalData(String localUserName, String localUserAvata, String localPost) {
        this.localUserName = localUserName;
        this.localUserAvata = localUserAvata;
        this.localPost = localPost;
    }

    public LocalData() {
    }

    public String getLocalUserName() {
        return localUserName;
    }

    public void setLocalUserName(String localUserName) {
        this.localUserName = localUserName;
    }

    public String getLocalUserAvata() {
        return localUserAvata;
    }

    public void setLocalUserAvata(String localUserAvata) {
        this.localUserAvata = localUserAvata;
    }

    public String getLocalPost() {
        return localPost;
    }

    public void setLocalPost(String localPost) {
        this.localPost = localPost;
    }

}

