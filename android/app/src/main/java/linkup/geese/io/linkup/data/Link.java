package linkup.geese.io.linkup.data;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Azhng on 2017-09-16.
 */

@IgnoreExtraProperties
public class Link {
    private Integer mLinkedUserId = -1;
    private Double  mLatitude = -1D;
    private Double  mLongitude = -1D;
    private Long    mDate = -1L;

    public Link() {}

    public Link(Integer mLinkedUserId, Double mLatitude, Double mLongitude, Long mDate) {
        this.mLinkedUserId = mLinkedUserId;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mDate = mDate;
    }

    public Integer getLinkededUserId() {
        return mLinkedUserId;
    }

    public void setLinkedUserId(Integer mConnectedUserId) {
        this.mLinkedUserId = mConnectedUserId;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public Long getDate() {
        return mDate;
    }

    public void setDate(Long mDate) {
        this.mDate = mDate;
    }
}
