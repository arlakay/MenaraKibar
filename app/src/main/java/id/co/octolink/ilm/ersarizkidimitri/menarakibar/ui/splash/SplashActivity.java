package id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.login.LoginActivity;

/**
 * Created by e_er_de on 21/06/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
