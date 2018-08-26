package mendes.sutil.dyego.gymapp;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class ChooseLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        Button googleLoginButton = findViewById(R.id.google_login_button);
        googleLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(ChooseLogin.this,"Dyego Sutil",Toast.LENGTH_SHORT).show();
                // Configure sign-in to request the user's ID, email address, and basic
                // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
                Account account = gso.getAccount();
                // Build a GoogleSignInClient with the options specified by gso.
                GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(ChooseLogin.this, gso);
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivity(signInIntent);
                String name = mGoogleSignInClient.getApi().getName();
                Toast.makeText(ChooseLogin.this,name,Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null){
            Toast.makeText(ChooseLogin.this,"You've already signed in!",Toast.LENGTH_SHORT);
        }
        //updateUI(account);
    }
}
