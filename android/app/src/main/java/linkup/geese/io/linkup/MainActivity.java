package linkup.geese.io.linkup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        locationIntent.putExtra(KEY_USERID, 1);
        startService(locationIntent);

        Cache cache = Cache.getInstance(this);


        Map<String, Proficiency> skills1 = new HashMap<>();
        skills1.put("C++", Proficiency.HIGH);
        skills1.put("Web", Proficiency.LOW);

        Map<String, String> contact1 = new HashMap<>();
        contact1.put("Phone", "2232232233");
        contact1.put("Email", "archer@email.com");

        Map<String, Integer> link1 = new HashMap<>();


        Location location1 = new Location(43.4727625, -80.5401367, Calendar.getInstance().getTimeInMillis());
//
        cache.setUser("3", new User("3", "Mohit", "M", UserType.CANDIDATE, skills1, contact1, link1, location1));
        cache.commit();
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

//        cache.setLocation(0, new Location(32.232325D, 64.235, Calendar.getInstance().getTimeInMillis()));
        SharedPreferences prefs = this.getSharedPreferences("linkup.geese.io", Context.MODE_PRIVATE);
        String loggedIn = prefs.getString("linkup.geese.io.loggedin", "out");
        if (!loggedIn.equals("out")) {
            startActivity(new Intent(this, ProfileActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        }
    }


    @Override
    public void onFirebaseLoaded(User user) {
//        Toast.makeText(this, user.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
