package linkup.geese.io.linkup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

public class MainActivity extends AppCompatActivity implements IDataLoadedCallable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Map<String, Link> arr = new HashMap<>();
        User newUser = new User(1, "Archer", "Zhang", "some@email.com", arr);
        Cache cache = Cache.getInstance(this);
        cache.setUser(1, newUser);
        cache.commit();
        cache.getUser(1);
        cache.setUser(1, new User(1, "Archer", "Zhang", "someother@email.com", arr));
        cache.commit();
        cache.getUser(1);
        cache.setUser(2, new User(2, "Lawrence", "Pan", "lpan@email.com", arr));
        cache.commit();

        Map<String, Link> arr1 = new HashMap<>();

        arr1.put("_0", new Link(1, 3.23232323243, 24.3225432, Calendar.getInstance().getTimeInMillis()));

        Map<String, Link> arr2 = new HashMap<>();

        arr2.put("_1", new Link(2, 3.23232323243, 24.3225432, Calendar.getInstance().getTimeInMillis()));


        cache.setUser(1, new User(1, "Archer", "Zhang", "someother@email.com", arr1));
        cache.setUser(2, new User(2, "Lawrence", "Pan", "lpan@email.com", arr2));

        cache.commit();

        cache.getUser(2);

    }


    @Override
    public void onFirebaseLoaded(User user) {
//        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
