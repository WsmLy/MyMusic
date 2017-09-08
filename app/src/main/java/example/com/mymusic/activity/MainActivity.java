package example.com.mymusic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.adapter.RecyclerViewAdapter;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.ui.MyDecoration;
import example.com.mymusic.util.DisplayUtil;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class MainActivity extends AppCompatActivity {

    private ImageView menu;
    private ImageView search;
    private List<BaseMusic> musicList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
//        display.getMetrics(dm);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;// * dm.density);
        int screenHeight = dm.heightPixels;// * dm.density);

        FrameLayout parentView = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        parentView.setLayoutParams(params);
//        RecyclerViewHeader header = RecyclerViewHeader.fromXml(this, R.layout.header);
        RecyclerView mainView = new RecyclerView(this);
        mainView.setLayoutParams(params);
        mainView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
//        mainView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        init();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, screenWidth, musicList);
        adapter.setOnItemClick(new RecyclerViewAdapter.OnItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
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
//        header.attachTo(mainView);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);//ENABLE自定义的ACTIONBAR
            actionBar.setCustomView(R.layout.header);
        }
        setContentView(parentView);

        findView();
        onClick();

    }

    private void findView() {
        menu = (ImageView) findViewById(R.id.menu);
        search = (ImageView) findViewById(R.id.search_button);
    }

    private void init() {
        musicList = new ArrayList<>();
        BaseMusic music = new BaseMusic();
        music.setName("name");
        music.setAuthor("author");
        music.setSinger("singer");
        music.setImage(R.mipmap.ic_launcher_round);
        musicList.add(music);
    }

    private void onClick() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * menu点击事件处理
                 * 弹出fragment侧边栏盒子
                 */
                Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * search点击事件处理
                 * 跳转到搜索页，
                 * 先查询本地，
                 * 再查询数据库，
                 * 若没有，就去网上爬取相关内容。
                 */
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
