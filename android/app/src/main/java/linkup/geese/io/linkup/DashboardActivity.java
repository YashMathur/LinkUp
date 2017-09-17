package linkup.geese.io.linkup;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.supportActionBar = getSupportActionBar();
        this.supportActionBar.hide();

    }


    public void toProfile(View v) {
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
