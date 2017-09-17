package linkup.geese.io.linkup;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditProfile extends AppCompatActivity {

    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        this.supportActionBar = getSupportActionBar();
        this.supportActionBar.hide();
    }

    public void onSave() {
    }
}
