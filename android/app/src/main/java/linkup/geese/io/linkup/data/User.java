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
    private UserType mType = null;
    private Map<String, Proficiency> mSkills = null;
    private Map<String, String> mContacts = null;
    private Map<String, Integer> mLinks = null;
    private Location          mLocation = null;

    public User() { }

    public User(Integer mUserId,
                String mFirstName,
                String mLastName,
                UserType mType,
                Map<String, Proficiency> mSkills,
                Map<String, String> mContacts,
                Map<String, Integer> mLinks,
                Location mLocation) {
        this.mUserId = mUserId;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mType  = mType;
        this.mSkills = mSkills;
        this.mContacts = mContacts;
        this.mLinks = mLinks;
        this.mLocation = mLocation;
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

    public Map<String, Integer> getLinks() {
        return mLinks;
    }

    public void setLinks(Map<String, Integer> mLinks) {
        this.mLinks = mLinks;
    }

    public UserType getmType() {
        return mType;
    }

    public void setmType(UserType mType) {
        this.mType = mType;
    }

    public Map<String, Proficiency> getmSkills() {
        return mSkills;
    }

    public void setmSkills(Map<String, Proficiency> mSkills) {
        this.mSkills = mSkills;
    }

    public Map<String, String> getmContacts() {
        return mContacts;
    }

    public void setmContacts(Map<String, String> mContacts) {
        this.mContacts = mContacts;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setmLocation(Location mLocation) {
        this.mLocation = mLocation;
    }
}
