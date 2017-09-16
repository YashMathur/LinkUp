package linkup.geese.io.linkup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.Location;
import linkup.geese.io.linkup.data.Proficiency;
import linkup.geese.io.linkup.data.User;
import linkup.geese.io.linkup.data.UserType;

public class MainActivity extends AppCompatActivity implements IDataLoadedCallable {

    public final static String KEY_USERID = "KEY_USERID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent locationIntent = new Intent(this, PutLocationService.class);
        locationIntent.putExtra(KEY_USERID, "yash");
        startService(locationIntent);

        Cache cache = Cache.getInstance(this);

        Map<String, Link> link1 = new HashMap<>();

        link1.put("_1", new Link(1, 3.23232323243, 24.3225432, Calendar.getInstance().getTimeInMillis()));

        Map<String, Link> link2 = new HashMap<>();

        link2.put("_0", new Link(0, 3.23232323243, 24.3225432, Calendar.getInstance().getTimeInMillis()));

//
//        Map<String, Proficiency> mSkills,
//        Map<String, String> mContacts,
//        Map<String, Link> mLinks,
//        Location mLocation) {

//        Map<String, Proficiency> skills1 = new HashMap<>();
//        skills1.put("C++", Proficiency.HIGH);
//        skills1.put("Web", Proficiency.LOW);
//
//        Map<String, String> contact1 = new HashMap<>();
//        contact1.put("Phone", "2232232233");
//        contact1.put("Email", "archer@email.com");
//
//        Location location1 = new Location(32.232325D, 64.235, 1, Calendar.getInstance().getTimeInMillis());
//
//        cache.setUser(0, new User(0, "Archer", "Zhang", UserType.CANDIDATE, skills1, contact1, link1, location1));
//
//
//
//        Map<String, Proficiency> skills2 = new HashMap<>();
//        skills2.put("Android", Proficiency.HIGH);
//        skills2.put("Web", Proficiency.LOW);
//
//        Map<String, String> contact2 = new HashMap<>();
//        contact2.put("Phone", "2662232233");
//        contact2.put("Email", "lpan@email.com");
//
//        Location location2 = new Location(32.232325D, 64.235, 1, Calendar.getInstance().getTimeInMillis());
//
//        cache.setUser(1, new User(1, "Lawrence", "Pan", UserType.RECRUITER, skills2, contact2, link2, location2));
//
//        cache.commit();
//
//        cache.getUser(0);

        cache.setLocation(0, new Location(32.232325D, 64.235, 25, Calendar.getInstance().getTimeInMillis()));


    }


    @Override
    public void onFirebaseLoaded(User user) {
//        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
