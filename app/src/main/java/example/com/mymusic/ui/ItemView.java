package example.com.mymusic.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.mymusic.util.ToolActivity;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class ItemView extends LinearLayout {
//    private Context context;
    public ItemView(@NonNull Context context) {
        super(context);
        this.setBackgroundColor(Color.GREEN);
        this.setOrientation(VERTICAL);
        LayoutParams mainParams = new LayoutParams((int)ToolActivity.getScreenWidth()/2, (int)ToolActivity.getScreenWidth()/2);
        this.setLayoutParams(mainParams);
//        this.context = context;
        initView(context);

    }
    private TextView name,auther,singer,time;
    private ImageView imageView;
    private void initView(Context context) {

        imageView = new ImageView(context);
        LayoutParams imageParams = new LayoutParams(78,78);
        imageView.setLayoutParams(imageParams);
        addView(imageView);

        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout textGroup = new LinearLayout(context);
        textGroup.setLayoutParams(textParams);
        textGroup.setOrientation(HORIZONTAL);

        name = new TextView(context);
        name.setLayoutParams(textParams);
        name.setText("ajlkds");
        name.setTextSize(12);
        textGroup.addView(name);

        auther = new TextView(context);
        auther.setLayoutParams(textParams);
        auther.setText("ajlkds");
        auther.setTextSize(12);
        textGroup.addView(auther);
        addView(textGroup);
    }

    public TextView getName() {
        return name;
    }

    public TextView getAuther() {
        return auther;
    }

    public TextView getSinger() {
        return singer;
    }

    public TextView getTime() {
        return time;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
