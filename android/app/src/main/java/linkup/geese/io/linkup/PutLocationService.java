package linkup.geese.io.linkup;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.User;

/**
 * Created by yash on 2017-09-16.
 */

public class PutLocationService extends Service implements IDataLoadedCallable {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Integer userId = intent.getIntExtra(MainActivity.KEY_USERID, -1);

        Cache cache = Cache.getInstance(this);

        cache.getUser(userId);

        return Service.START_NOT_STICKY;
    }

    @Override
    public void onFirebaseLoaded(User user) {
//        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
