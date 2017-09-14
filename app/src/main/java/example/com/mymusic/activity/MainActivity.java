package example.com.mymusic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
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
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.adapter.LeftAdapter;
import example.com.mymusic.adapter.RecyclerViewAdapter;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.entity.ItemLeft;
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
    private List<ItemLeft> itemLeftList;

//    private DrawerLayout drawerLayout;
    private FrameLayout drawerLayout;
    private RelativeLayout relativeLayout;
    private FrameLayout parentView;
    private RecyclerView mainView;
    private RecyclerViewAdapter adapter;

//    private String[] leftMenuNames = {"left_item1", "left_item2",
//            "left_item3", "left_item4"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
//        display.getMetrics(dm);

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;// * dm.density);
        int screenHeight = dm.heightPixels;// * dm.density);

//        drawerLayout = new DrawerLayout(this);
        drawerLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        drawerLayout.setLayoutParams(layoutParams);

        parentView = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        parentView.setLayoutParams(params);
//        parentView.setElevation(4);
//        RecyclerViewHeader header = RecyclerViewHeader.fromXml(this, R.layout.header);
        mainView = new RecyclerView(this);
        mainView.setLayoutParams(params);
        mainView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
//        mainView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        init();
        adapter = new RecyclerViewAdapter(this, screenWidth, musicList);
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

        drawerLayout.addView(parentView);

        relativeLayout = new RelativeLayout(this);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(DisplayUtil.dip2px(this, 200), ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams1.gravity = Gravity.LEFT;
//        relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
        relativeLayout.setLayoutParams(params);

        RecyclerView listView = new RecyclerView(this);
        listView.setLayoutParams(layoutParams1);
        listView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        LeftAdapter leftAdapter = new LeftAdapter(this, itemLeftList);
        leftAdapter.setOnItemClick(new LeftAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                switch (itemLeftList.get(position).getId()) {
                    case 0:
                        Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();break;
                    case 1:
                        Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();break;
                    case 2:
                        Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();break;
                    case 3:
                        Toast.makeText(MainActivity.this, position+"检查更新", Toast.LENGTH_SHORT).show();break;
                    case 4:
                        Toast.makeText(MainActivity.this, position+"关于我们", Toast.LENGTH_SHORT).show();break;
                    default:
                        break;
                }
            }
        });
        listView.setAdapter(leftAdapter);//给左边菜单写入数据
        listView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        listView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
        relativeLayout.addView(listView);

        drawerLayout.addView(relativeLayout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);//ENABLE自定义的ACTIONBAR
            actionBar.setCustomView(R.layout.header);
        }
        setContentView(drawerLayout);

//        drawerLayout.closeDrawer(Gravity.LEFT);
        relativeLayout.setVisibility(View.GONE);
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
        music = new BaseMusic();
        music.setName("name");
        music.setAuthor("author");
        music.setSinger("singer");
        music.setImage(R.mipmap.ic_launcher_round);
        musicList.add(music); music = new BaseMusic();
        music.setName("name");
        music.setAuthor("author");
        music.setSinger("singer");
        music.setImage(R.mipmap.ic_launcher_round);
        musicList.add(music); music = new BaseMusic();
        music.setName("name");
        music.setAuthor("author");
        music.setSinger("singer");
        music.setImage(R.mipmap.ic_launcher_round);
        musicList.add(music);

        itemLeftList = new ArrayList<>();
        ItemLeft itemLeft = new ItemLeft();
        itemLeft.setImageId(R.mipmap.ic_launcher_round);
        itemLeft.setText("itemLeft_1");
        itemLeft.setId(0);
        itemLeftList.add(itemLeft);
        itemLeft = new ItemLeft();
        itemLeft.setImageId(R.mipmap.ic_launcher);
        itemLeft.setText("itemLeft_2");
        itemLeft.setId(1);
        itemLeftList.add(itemLeft);
        itemLeft = new ItemLeft();
        itemLeft.setImageId(R.mipmap.ic_launcher_round);
        itemLeft.setText("itemLeft_3");
        itemLeft.setId(2);
        itemLeftList.add(itemLeft);
        itemLeft = new ItemLeft();
        itemLeft.setImageId(R.mipmap.ic_launcher);
        itemLeft.setText("检查更新");
        itemLeft.setId(3);
        itemLeftList.add(itemLeft);
        itemLeft = new ItemLeft();
        itemLeft.setImageId(R.mipmap.ic_launcher_round);
        itemLeft.setText("关于我们");
        itemLeft.setId(4);
        itemLeftList.add(itemLeft);
    }

    private void onClick() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * menu点击事件处理
                 * 弹出fragment侧边栏盒子
                 */
//                drawerLayout.openDrawer(Gravity.LEFT);
                if (relativeLayout.getVisibility() == View.GONE) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    adapter.setItemClickable(false);
                } else {
                    relativeLayout.setVisibility(View.GONE);
                    adapter.setItemClickable(true);
                }
//                Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * 并不执行
         */
//        parentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (relativeLayout.getVisibility() == View.GONE) {
//                    relativeLayout.setVisibility(View.GONE);
//                } else {
//
//                    Toast.makeText(MainActivity.this, "repeat", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
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
        drawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (relativeLayout.getVisibility() != View.GONE) {
                    relativeLayout.setVisibility(View.GONE);
                }
            }
        });
    }
}
