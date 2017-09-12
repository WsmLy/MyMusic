package example.com.mymusic.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.mymusic.util.DisplayUtil;


/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class ItemView extends LinearLayout {
//    private Context context;
    private int width;
    public ItemView(@NonNull Context context, int width) {
        super(context);
//        this.setBackgroundColor(Color.BLUE);
        this.setOrientation(VERTICAL);
        LayoutParams mainParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mainParams.setMargins(DisplayUtil.dip2px(context, 4),DisplayUtil.dip2px(context, 4),DisplayUtil.dip2px(context, 4),DisplayUtil.dip2px(context, 4));//以后改成4dp
        this.setLayoutParams(mainParams);
//        this.context = context;
        this.width = width;
        initView(context);

    }
    private TextView name,auther,singer,time;
    private ImageView imageView;
    private void initView(Context context) {

        imageView = new ImageView(context);
        LayoutParams imageParams = new LayoutParams(width/2-20, width/2-20);
        imageView.setLayoutParams(imageParams);
        imageView.setPadding(20,20,20,20);
//        imageView.setElevation(0);
        addView(imageView);

        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        LinearLayout textGroup = new LinearLayout(context);
//        textGroup.setLayoutParams(textParams);
//        textGroup.setOrientation(HORIZONTAL);

        name = new TextView(context);
        name.setLayoutParams(textParams);
//        name.setText("ajlkds");
        name.setTextSize(14);
        name.setPadding(5,5,5,0);
//        textGroup.addView(name);
        addView(name);

        auther = new TextView(context);
        auther.setLayoutParams(textParams);
//        auther.setText("ajlkds");
        auther.setTextSize(12);
        auther.setPadding(5,5,5,5);
//        textGroup.addView(auther);
//        addView(textGroup);
        addView(auther);
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
