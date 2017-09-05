package example.com.mymusic.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

import example.com.mymusic.R;
import example.com.mymusic.adapter.RecyclerViewAdapter;
import example.com.mymusic.ui.MyDecoration;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class MainActivity extends AppCompatActivity {

    private ImageView menu;
    private ImageView search;
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
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(this, R.layout.header);
        RecyclerView mainView = new RecyclerView(this);
        mainView.setLayoutParams(params);
        mainView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
//        mainView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, screenWidth);
        adapter.setOnItemClick(new RecyclerViewAdapter.OnItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                /**
                 * 传参数
                 */
                startActivity(intent);
            }
        });
        mainView.setAdapter(adapter);
        parentView.addView(mainView);
        header.attachTo(mainView);

        setContentView(parentView);

        getSupportActionBar().hide();
        findView();
        onClick();

    }

    private void findView() {
        menu = (ImageView) findViewById(R.id.menu);
        search = (ImageView) findViewById(R.id.search_button);
    }

    private void onClick() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
                /**
                 * menu点击事件处理
                 */
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                /**
                 * search点击事件处理
                 */
            }
        });
    }
}
