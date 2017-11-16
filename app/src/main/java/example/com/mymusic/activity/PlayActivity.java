package example.com.mymusic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.display.DisplayManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.mymusic.R;
import example.com.mymusic.ui.PlayView;
import example.com.mymusic.util.DisplayUtil;

public class PlayActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = getIntent();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        PlayView playView = new PlayView(this, screenWidth, intent.getIntExtra("image", 0));

//        setContentView(R.layout.playactivity_layout);
        setContentView(playView);

        LinearLayout barView = new LinearLayout(this);
        LinearLayout.LayoutParams barParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        barView.setLayoutParams(barParams);
        barView.setOrientation(LinearLayout.HORIZONTAL);

        ImageView back = new ImageView(this);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.gravity = Gravity.CENTER;
        btnParams.setMargins(DisplayUtil.px2dip(this, 4), DisplayUtil.px2dip(this, 4), DisplayUtil.px2dip(this, 4), DisplayUtil.px2dip(this, 4));
        back.setLayoutParams(btnParams);
        back.setBackgroundResource(R.drawable.arrow_left);
        back.setOnClickListener(view -> finish());
        barView.addView(back);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        linearLayout.setLayoutParams(layoutParams);

        TextView nameText = new TextView(this);
        LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        nameText.setLayoutParams(nameParams);
        nameText.setGravity(Gravity.CENTER);
        nameText.setTextSize(14);
        nameText.setTextColor(Color.WHITE);
        nameText.setText(intent.getStringExtra("name"));
        linearLayout.addView(nameText);

        TextView singerText = new TextView(this);
        singerText.setLayoutParams(nameParams);
        singerText.setGravity(Gravity.CENTER);
        singerText.setTextSize(12);
        singerText.setTextColor(Color.WHITE);
        singerText.setText(intent.getStringExtra("singer"));
        linearLayout.addView(singerText);

        barView.addView(linearLayout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(barView);
        }
    }
}
