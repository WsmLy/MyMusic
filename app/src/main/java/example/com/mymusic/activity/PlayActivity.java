package example.com.mymusic.activity;

import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import example.com.mymusic.R;
import example.com.mymusic.ui.PlayView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        PlayView playView = new PlayView(this, screenWidth);

//        setContentView(R.layout.playactivity_layout);
        setContentView(playView);
        getSupportActionBar().hide();
    }
}
