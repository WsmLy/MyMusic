package example.com.mymusic.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import example.com.mymusic.adapter.RecyclerViewAdapter;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class MainActivity extends AppCompatActivity {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout parentView = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        parentView.setLayoutParams(params);
        RecyclerView mainView = new RecyclerView(this);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        mainView.setLayoutManager(new LinearLayoutManager(this));
        mainView.setAdapter(adapter);
        mainView.setLayoutParams(params);
        parentView.addView(mainView);

        setContentView(parentView);
        Toast.makeText(this, "ad", Toast.LENGTH_SHORT).show();

        DisplayMetrics dm = new DisplayMetrics();
//        display.getMetrics(dm);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
    }
}
