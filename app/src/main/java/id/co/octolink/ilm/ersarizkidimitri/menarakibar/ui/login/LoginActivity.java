package id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.R;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.txt_logo)TextView txtLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        String fontPath = "fonts/Karla-Bold.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtLogo.setTypeface(tf);
    }

    @OnClick(R.id.btn_gplus)
    public void toMain(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    @OnClick(R.id.btn_login_email)
    public void toMain2(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

}
