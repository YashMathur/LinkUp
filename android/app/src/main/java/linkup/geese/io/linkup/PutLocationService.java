package linkup.geese.io.linkup;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

/**
 * Created by yash on 2017-09-16.
 */

public class PutLocationService extends Service implements IDataLoadedCallable, LocationListener {

    linkup.geese.io.linkup.data.Location currentLocation = null;
    int userId;

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            currentLocation = new linkup.geese.io.linkup.data.Location(location.getLongitude(), location.getLatitude(), java.util.Calendar.getInstance().getTimeInMillis());
            Log.d("new location", currentLocation.getmLatitude().toString());
            Cache cache = Cache.getInstance(PutLocationService.this);

            cache.setLocation(userId, currentLocation);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        userId = intent.getIntExtra(MainActivity.KEY_USERID, -1);

        LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Log.d("put location", "started");
        Log.d("last known", mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).toString());
        currentLocation = new linkup.geese.io.linkup.data.Location(mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude(), mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude(), mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getTime());
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "Cannot access location", Toast.LENGTH_LONG).show();
            return Service.START_NOT_STICKY;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20,
                1, mLocationListener);

        Cache cache = Cache.getInstance(this);

        cache.setLocation(userId, currentLocation);

        return Service.START_NOT_STICKY;
    }

    @Override
    public void onFirebaseLoaded(User user) {
//        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
