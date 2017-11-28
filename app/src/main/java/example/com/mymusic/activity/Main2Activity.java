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

import java.io.Serializable;
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
            intent.putExtra("data", (Serializable) musicList);
            intent.putExtra("pos", position);
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onclick() {
        search.setOnClickListener(v -> {
            /**
             * 跳转到SearchActivity
             */
            startActivity(new Intent(Main2Activity.this, SearchActivity.class));
            Toast.makeText(Main2Activity.this, "Search", Toast.LENGTH_SHORT).show();
        });
    }

    private void findView() {
        search = findViewById(R.id.search);
        mainView = findViewById(R.id.mainViewRecycler);
    }

    private void init() {
        musicList = new ArrayList<>();
        BaseMusic music = new BaseMusic();
        music.setName("name1");
        music.setAuthor("author1");
        music.setSinger("singer1");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name2");
        music.setAuthor("author2");
        music.setSinger("singer2");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name3");
        music.setAuthor("author3");
        music.setSinger("singer3");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name4");
        music.setAuthor("author4");
        music.setSinger("singer4");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name5");
        music.setAuthor("author5");
        music.setSinger("singer5");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name6");
        music.setAuthor("author6");
        music.setSinger("singer6");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name7");
        music.setAuthor("author7");
        music.setSinger("singer7");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name8");
        music.setAuthor("author8");
        music.setSinger("singer8");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name9");
        music.setAuthor("author9");
        music.setSinger("singer9");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name10");
        music.setAuthor("author10");
        music.setSinger("singer10");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name11");
        music.setAuthor("author11");
        music.setSinger("singer11");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name12");
        music.setAuthor("author12");
        music.setSinger("singer12");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name13");
        music.setAuthor("author13");
        music.setSinger("singer13");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name14");
        music.setAuthor("author14");
        music.setSinger("singer14");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name15");
        music.setAuthor("author15");
        music.setSinger("singer15");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name16");
        music.setAuthor("author16");
        music.setSinger("singer16");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name17");
        music.setAuthor("author17");
        music.setSinger("singer17");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name18");
        music.setAuthor("author18");
        music.setSinger("singer18");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name19");
        music.setAuthor("author19");
        music.setSinger("singer19");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
        music = new BaseMusic();
        music.setName("name20");
        music.setAuthor("author20");
        music.setSinger("singer20");
        music.setImage(R.mipmap.ic_launcher_round);
        music.setResId(R.raw.huainvhai);
        musicList.add(music);
    }
}

