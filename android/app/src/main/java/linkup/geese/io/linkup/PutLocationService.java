package linkup.geese.io.linkup;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by yash on 2017-09-16.
 */

public class PutLocationService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String userId = intent.getStringExtra(MainActivity.KEY_USERID);

        return Service.START_NOT_STICKY;
    }
}
