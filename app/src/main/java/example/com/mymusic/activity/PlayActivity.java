package example.com.mymusic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.entity.Player;
import example.com.mymusic.ui.PlayView;
import example.com.mymusic.util.DisplayUtil;

public class PlayActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private List<String> nameList, singerList;
    private List<Integer> imageList, resList;
    private ArrayAdapter<String> adapter;
    private int position;

    private TextView singerText, nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initList(getIntent());

        Toast.makeText(PlayActivity.this, position+"", Toast.LENGTH_SHORT).show();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        PlayView playView = new PlayView(this, screenWidth);

        playView.playImage.setImageResource(imageList.get(position));
        setContentView(playView);

        mediaPlayer = MediaPlayer.create(this, resList.get(position));
        final int[] num = {0};
        playView.btnPrevious.setOnClickListener(v -> {
            Toast.makeText(PlayActivity.this, "Previous", Toast.LENGTH_SHORT).show();
        });
        playView.btnPlay.setOnClickListener(v -> {
            if (num[0] % 2 == 0) {
                mediaPlayer.start();
                playView.btnPlay.setBackgroundResource(R.drawable.pause);
            } else {
                mediaPlayer.pause();
                playView.btnPlay.setBackgroundResource(R.drawable.play);
            }
            num[0]++;
        });
        playView.btnNext.setOnClickListener(v ->

            Toast.makeText(PlayActivity.this, "Next", Toast.LENGTH_SHORT).show()
        );
        playView.btnStop.setOnClickListener(v -> mediaPlayer.stop());



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(createBarView());
        }

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, nameList);
        playView.spinner.setAdapter(adapter);
        playView.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                playView.playImage.setImageResource(imageList.get(position));
                nameText.setText(nameList.get(position));
                singerText.setText(singerList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return ;
            }
        });
    }

    private View createBarView() {
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

        nameText = new TextView(this);
        LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        nameText.setLayoutParams(nameParams);
        nameText.setGravity(Gravity.CENTER);
        nameText.setTextSize(14);
        nameText.setTextColor(Color.WHITE);
        nameText.setText(nameList.get(position));
        linearLayout.addView(nameText);

        singerText = new TextView(this);
        singerText.setLayoutParams(nameParams);
        singerText.setGravity(Gravity.CENTER);
        singerText.setTextSize(12);
        singerText.setTextColor(Color.WHITE);
        singerText.setText(singerList.get(position));
        linearLayout.addView(singerText);

        barView.addView(linearLayout);

        return barView;
    }

    private void initList(Intent intent) {
        List<BaseMusic> musicList = (List<BaseMusic>) intent.getSerializableExtra("data");
        position = intent.getIntExtra("pos", 0);
        nameList = new ArrayList<>();
        singerList = new ArrayList<>();
        imageList = new ArrayList<>();
        resList = new ArrayList<>();
        for (int i = 0; i < musicList.size(); i ++) {
            nameList.add("    " + musicList.get(i).getName());
            singerList.add("    " + musicList.get(i).getSinger());
            imageList.add(musicList.get(i).getImage());
            resList.add(musicList.get(i).getResId());
        }

    }
}
