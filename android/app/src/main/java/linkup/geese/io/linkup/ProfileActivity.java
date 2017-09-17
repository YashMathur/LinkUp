package linkup.geese.io.linkup;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.actionBar = getSupportActionBar();
        this.actionBar.hide();
        this.getSupportFragmentManager().beginTransaction().add(R.id.p_fragment_container, ProfileFragment.newInstance(getIntent().getStringExtra("userId"))).commit();
    }

    public void goBack(View v) {
        finish();
    }

}
