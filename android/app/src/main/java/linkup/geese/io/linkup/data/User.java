package linkup.geese.io.linkup.data;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Map;

/**
 * Created by Azhng on 2017-09-16.
 */

@IgnoreExtraProperties
public class User {

    private Integer mUserId = -1;
    private String  mFirstName = "";
    private String  mLastName = "";
    private String  mEmail = "";
    private Map<String, Link> mLinks;

    public User() { }

    public User(Integer mUserId, String mFirstName, String mLastName, String mEmail, Map<String, Link> mLinks) {
        this.mUserId = mUserId;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mLinks = mLinks;
    }

    public Integer getmUserId() {
        return mUserId;
    }

    public void setUserId(Integer mUserId) {
        this.mUserId = mUserId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Map<String, Link> getLinks() {
        return mLinks;
    }

    public void setLinks(Map<String, Link> mLinks) {
        this.mLinks = mLinks;
    }
}
