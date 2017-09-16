package linkup.geese.io.linkup.data;

/**
 * Created by Azhng on 2017-09-16.
 */

public class Location {

    private Double mLongitude;
    private Double mLatitude;
    private Long    mTimestamp;

    public Location() { }

    public Location(Double mLongitude, Double mLatitude, Long mTimestamp) {
        this.mLongitude = mLongitude;
        this.mLatitude = mLatitude;
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

    public Long getmTimestamp() {
        return mTimestamp;
    }

    public void setmTimestamp(Long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }
}
