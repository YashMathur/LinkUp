package linkup.geese.io.linkup.data;

/**
 * Created by Azhng on 2017-09-16.
 */

public class Location {

    private Double mLongitude;
    private Double mLatitude;
    private Integer mLocationId;
    private Long    mTimestamp;

    public Location(Double mLongitude, Double mLatitude, Integer mLocationId, Long mTimestamp) {
        this.mLongitude = mLongitude;
        this.mLatitude = mLatitude;
        this.mLocationId = mLocationId;
        this.mTimestamp = mTimestamp;
    }

    public Double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public Double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public Integer getmLocationId() {
        return mLocationId;
    }

    public void setmLocationId(Integer mLocationId) {
        this.mLocationId = mLocationId;
    }

    public Long getmTimestamp() {
        return mTimestamp;
    }

    public void setmTimestamp(Long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }
}
