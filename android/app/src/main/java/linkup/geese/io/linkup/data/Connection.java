package linkup.geese.io.linkup.data;

import android.location.Location;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Azhng on 2017-09-16.
 */

@IgnoreExtraProperties
public class Connection {
    private Integer mConnectedUserId = -1;
    private Double  mLatitude = -1D;
    private Double  mLongitude = -1D;
    private Long    mDate = -1L;

    public Connection() {}

    public Connection(Integer mConnectedUserId, Double mLatitude, Double mLongitude, Long mDate) {
        this.mConnectedUserId = mConnectedUserId;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mDate = mDate;
    }

    public Integer getConnectedUserId() {
        return mConnectedUserId;
    }

    public void setConnectedUserId(Integer mConnectedUserId) {
        this.mConnectedUserId = mConnectedUserId;
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
