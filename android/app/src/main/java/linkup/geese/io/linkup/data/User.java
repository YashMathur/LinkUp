package linkup.geese.io.linkup.data;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 * Created by Azhng on 2017-09-16.
 */

@IgnoreExtraProperties
public class User {

    private Integer mUserId = -1;
    private String  mFirstName = "";
    private String  mLastName = "";
    private String  mEmail = "";
    private List<Connection> mConnections;

    public User() { }

    public User(Integer mUserId, String mFirstName, String mLastName, String mEmail, List<Connection> mConnections) {
        this.mUserId = mUserId;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mConnections = mConnections;
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

    public List<Connection> getConnections() {
        return mConnections;
    }

    public void setConnections(List<Connection> mConnections) {
        this.mConnections = mConnections;
    }
}
