package linkup.geese.io.linkup;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

public class ProfileActivity extends AppCompatActivity implements IDataLoadedCallable{

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.actionBar = getSupportActionBar();
        this.actionBar.hide();

        this.getSupportFragmentManager().beginTransaction().add(R.id.p_fragment_container, ProfileFragment.newInstance(getIntent().getStringExtra("userId"))).commit();

        Intent intent = getIntent();

        Cache cache = Cache.getInstance(this);
        cache.setUser(intent.getStringExtra("UID"), new User(intent.getStringExtra("UID"), intent.getStringExtra("name").split(" ")[0], intent.getStringExtra("name").split(" ")[1]));
        cache.commit();
    }

    public void goBack(View v) {
        finish();
    }

    @Override
    public void onFirebaseLoaded(User user) {

    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {

    }
}
