package example.com.mymusic.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.com.mymusic.R;

/**
 * search点击事件处理
 * 跳转到搜索页，
 * 先查询本地，
 * 再查询数据库，
 * 若没有，就去网上爬取相关内容。
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.search_header);
        }
        findViewById(R.id.back).setOnClickListener(view -> finish());
        setContentView(R.layout.activity_search);
    }
}
