package example.com.mymusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.adapter.LeftAdapter;
import example.com.mymusic.adapter.RecyclerViewAdapter;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.entity.ItemLeft;
import example.com.mymusic.util.DisplayUtil;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class MainActivity_Copy extends AppCompatActivity {

    private List<BaseMusic> musicList;

    private FrameLayout drawerLayout;
    private FrameLayout parentView;
    private RecyclerView mainView;
    private RecyclerViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();

        int screenWidth = dm.widthPixels;// * dm.density);
        int screenHeight = dm.heightPixels;// * dm.density);

        drawerLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        drawerLayout.setLayoutParams(layoutParams);

        adapter = new RecyclerViewAdapter(this, screenWidth, musicList);
        adapter.setOnItemClick(new RecyclerViewAdapter.OnItemClick() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(MainActivity_Copy.this, PlayActivity.class);
                /**
                 * 传参数
                 */
                intent.putExtra("name", musicList.get(position).getName());
                intent.putExtra("singer", musicList.get(position).getSinger());
                intent.putExtra("date", musicList.get(position).getDate());
                intent.putExtra("author", musicList.get(position).getAuthor());
                intent.putExtra("image", musicList.get(position).getImage());
                startActivity(intent);
            }
        });
        mainView.setAdapter(adapter);
        parentView.addView(mainView);

        drawerLayout.addView(parentView);

    }

}
