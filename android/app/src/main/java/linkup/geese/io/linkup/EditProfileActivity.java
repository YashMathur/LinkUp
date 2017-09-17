package linkup.geese.io.linkup;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditProfileActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        actionBar = getSupportActionBar();
        actionBar.hide();
        userId = getIntent().getStringExtra("userId");
    }

    public void goBack(View v) {
        finish();
    }
}
