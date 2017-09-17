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

        SharedPreferences prefs = this.getSharedPreferences("linkup.geese.io", Context.MODE_PRIVATE);
        String loggedIn = prefs.getString("linkup.geese.io.loggedin", "out");
        if (!loggedIn.equals("out")) {
            Intent locationIntent = new Intent(this, PutLocationService.class);
            locationIntent.putExtra(KEY_USERID, loggedIn);
            startService(locationIntent);
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        }
    }


    @Override
    public void onFirebaseLoaded(User user) {

    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {

    }
}
