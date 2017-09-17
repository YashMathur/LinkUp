package linkup.geese.io.linkup;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity  {

    private FirebaseAuth mAuth;
    private static String TAG = "SignInActivity";

    private ActionBar actionBar;

    private SignInActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        this.actionBar = getSupportActionBar();
        this.actionBar.hide();
    }


    public void toDashBoard(View v) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }


}
