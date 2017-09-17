package linkup.geese.io.linkup.data;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

/**
 * Created by Azhng on 2017-09-16.
 */

@IgnoreExtraProperties
public class Link {

    private User candidate;
    private Long createdAt;
    private String matched;
    private User recruiter;

    public Link() {}

    public Link(User candidate, Long createdAt, String matched, User recruiter) {
        this.candidate = candidate;
        this.createdAt = createdAt;
        this.matched = matched;
        this.recruiter = recruiter;
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getMatched() {
        return matched;
    }

    public void setMatched(String matched) {
        this.matched = matched;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }

    //    private String mLinkedUserId = "";
//    private Double  mLatitude = -1D;
//    private Double  mLongitude = -1D;
//    private Double  mDate = 1D;
//    private String  mName = "testname";
//    private String  mKicker = "";
//    private String  mPercentage = "";
//
//    private Link() {}
//
//    public Link(User candidate, Double timestamp, Double matched, User recruiter) {
//        this.mLinkedUserId = candidate.getmUserId();
//        this.mLatitude = candidate.getmLocation().getmLatitude();
//        this.mLongitude = candidate.getmLocation().getmLongitude();
//        this.mDate = timestamp;
//        this.mName = candidate.getFirstName() + " " + candidate.getLastName();
//        this.mKicker = "lol";
//        this.mPercentage = "69%";
//    }
//
//    public String getmLinkedUserId() {
//        return mLinkedUserId;
//    }
//
//    public void setmLinkedUserId(String mLinkedUserId) {
//        this.mLinkedUserId = mLinkedUserId;
//    }
//
//    public Double getmLatitude() {
//        return mLatitude;
//    }
//
//    public void setmLatitude(Double mLatitude) {
//        this.mLatitude = mLatitude;
//    }
//
//    public Double getmLongitude() {
//        return mLongitude;
//    }
//
//    public void setmLongitude(Double mLongitude) {
//        this.mLongitude = mLongitude;
//    }
//
//    public Double getmDate() {
//        return mDate;
//    }
//
//    public void setmDate(Double mDate) {
//        this.mDate = mDate;
//    }
//
//    public String getmName() {
//        return mName;
//    }
//
//    public void setmName(String mName) {
//        this.mName = mName;
//    }
//
//    public String getmKicker() {
//        return mKicker;
//    }
//
//    public void setmKicker(String mKicker) {
//        this.mKicker = mKicker;
//    }
//
//    public String getmPercentage() {
//        return mPercentage;
//    }
//
//    public void setmPercentage(String mPercentage) {
//        this.mPercentage = mPercentage;
//    }
}
