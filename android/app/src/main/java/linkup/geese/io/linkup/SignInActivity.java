package linkup.geese.io.linkup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity  {

    private FirebaseAuth mAuth;
    private static String TAG = "SignInActivity";

    private ActionBar actionBar;
    private ConstraintLayout signinButton;
    private EditText usernameField;
    private EditText passwordField;

    private CallbackManager mCallbackManager;

    private SignInActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        this.actionBar = getSupportActionBar();
        this.actionBar.hide();

        this.usernameField = (EditText) findViewById(R.id.si_email);
        this.passwordField = (EditText) findViewById(R.id.si_password);

        this.signinButton = (ConstraintLayout) findViewById(R.id.si_signin_fb);

        mAuth = FirebaseAuth.getInstance();

        mCallbackManager = CallbackManager.Factory.create();
        final LoginButton loginButton = (LoginButton) findViewById(R.id.facebook_login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                Log.e(loginResult.getRecentlyGrantedPermissions().toArray()[0].toString(), loginResult.getRecentlyGrantedPermissions().toArray()[1].toString());
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });

        this.signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "check");
                loginButton.performClick();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success");

                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Toast.makeText(SignInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
    }

    public void signOut() {
        mAuth.signOut();
        LoginManager.getInstance().logOut();

        updateUI(null);
    }

    private void updateUI(FirebaseUser user) {
        Intent locationIntent = new Intent(this, PutLocationService.class);
        locationIntent.putExtra(MainActivity.KEY_USERID, user.getUid());
        startService(locationIntent);
        Log.d("user", user.getDisplayName());
        SharedPreferences prefs = this.getSharedPreferences("linkup.geese.io", Context.MODE_PRIVATE);
        prefs.edit().putString("linkup.geese.io.loggedin", user.getUid()).apply();
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.putExtra("name", user.getDisplayName());
        profileIntent.putExtra("email", user.getEmail());
        profileIntent.putExtra("UID", user.getUid());
        profileIntent.putExtra("userId", user.getUid());
        startActivity(profileIntent);
        finish();
    }

    public void toDashBoard(View v) {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }


}
