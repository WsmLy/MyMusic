package example.com.mymusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.adapter.RecyclerViewAdapter;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.ui.MyDecoration;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<BaseMusic> musicList;
    private EditText search;
    private RecyclerView mainView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DisplayMetrics dm = new DisplayMetrics();
        int screenWidth = dm.widthPixels;// * dm.density);
        int screenHeight = dm.heightPixels;// * dm.density);

        findView();
        mainView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        mainView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        init();
        adapter = new RecyclerViewAdapter(this, screenWidth, musicList);
        adapter.setOnItemClick((view, position) -> {
                Intent intent = new Intent(Main2Activity.this, PlayActivity.class);
                intent.putExtra("name", musicList.get(position).getName());
                intent.putExtra("singer", musicList.get(position).getSinger());
                intent.putExtra("date", musicList.get(position).getDate());
                intent.putExtra("author", musicList.get(position).getAuthor());
                intent.putExtra("image", musicList.get(position).getImage());
                startActivity(intent);
        });
        mainView.setAdapter(adapter);
        onclick();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * menu已停止使用
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(Main2Activity.this, id+"", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(Main2Activity.this, id+"", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(Main2Activity.this, id+"", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(Main2Activity.this, id+"", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(Main2Activity.this, id+"检查更新", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(Main2Activity.this, id+"关于我们", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onclick() {
        search.setOnClickListener(v -> {
            /**
             * search点击事件处理
             * 跳转到搜索页，
             * 先查询本地，
             * 再查询数据库，
             * 若没有，就去网上爬取相关内容。
             */
            startActivity(new Intent(Main2Activity.this, SearchActivity.class));
            Toast.makeText(Main2Activity.this, "Search", Toast.LENGTH_SHORT).show();
        });
    }

    private void findView() {
        search = (EditText) findViewById(R.id.search);
        mainView = (RecyclerView) findViewById(R.id.mainViewRecycler);
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
    }
}

