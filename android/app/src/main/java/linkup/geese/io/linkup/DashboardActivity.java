package linkup.geese.io.linkup;

import android.content.Intent;
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

//        linksList = (ListView) findViewById(R.id.db_list_view);
        recyclerView = (RecyclerView) findViewById(R.id.db_list) ;
//        adapter = new LinksListAdapter(dataModel, getApplicationContext());
        recyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DashboarAdapter(dataModel);
        recyclerView.setAdapter(mAdapter);



        cache.getUser("2");
//        linksList.setAdapter(adapter);

    }


    public void toProfile(View v) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    @Override
    public void onFirebaseLoaded(User user) {
        Log.d("yashyash", user.getLinks().keySet().iterator().next());
        cache.getLink(user.getLinks().keySet().iterator().next());

    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {
//        Log.d("fds", link.getCandidate().getFirstName());
//        Log.d("fds", "testcdstgcv" + link.getName());
        dataModel.add(link);
        mAdapter.notifyDataSetChanged();
        Log.e("FFFFF", ""+ mAdapter.getItemCount());
    }
}
