package linkup.geese.io.linkup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

public class DashboardActivity extends AppCompatActivity implements IDataLoadedCallable {

    private ActionBar supportActionBar;
    private ListView linksList;
    private RecyclerView recyclerView;
    private static LinksListAdapter adapter;
    Cache cache;

    ArrayList<Link> dataModel;
    private LinearLayoutManager mLayoutManager;
    private DashboarAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.supportActionBar = getSupportActionBar();
        this.supportActionBar.hide();

        cache = Cache.getInstance(this);
        dataModel = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.db_list) ;
        recyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        Integer[] images = {
            R.mipmap.girl1252995_1280,
            R.mipmap.girl1252995_12802,
            R.mipmap.girl1252995_12803
        };


        mAdapter = new DashboarAdapter(dataModel, images, this);
        recyclerView.setAdapter(mAdapter);



        cache.getUser("2");
//        linksList.setAdapter(adapter);

    }

    public void openProfile(String userId){
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }

    public void toProfile(View v) {
        SharedPreferences prefs = this.getSharedPreferences("linkup.geese.io", Context.MODE_PRIVATE);
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("userId", prefs.getString("linkup.geese.io.loggedin", "out"));
        startActivity(i);
    }

    @Override
    public void onFirebaseLoaded(User user) {
        cache.getLink(user.getLinks().keySet().iterator().next());

    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {
        dataModel.add(link);
        mAdapter.notifyDataSetChanged();
    }
}
