package example.com.mymusic.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import example.com.mymusic.R;
import example.com.mymusic.util.DisplayUtil;

/**
 * @author Wang Shaoming
 * @create 2017/9/5
 * @description
 */

public class PlayView extends LinearLayout {

    private int width;
    private int image;

    public ImageView btnPrevious, btnPlay, btnNext, btnStop, playImage;
    public Spinner spinner;

    public PlayView(Context context, int width) {
        super(context);
        this.width = width;
        this.setOrientation(VERTICAL);
        init(context);
    }

    private void init(final Context context) {

        playImage = new ImageView(context);
        LayoutParams params = new LayoutParams(width, (int) (width * 1.2));
        playImage.setLayoutParams(params);
        addView(playImage);

        LinearLayout linearLayout = new LinearLayout(context);
        LayoutParams params1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1);
        params1.gravity = Gravity.CENTER;
        linearLayout.setLayoutParams(params1);
        linearLayout.setOrientation(HORIZONTAL);

        btnPrevious = new ImageView(context);
        btnPlay = new ImageView(context);
        btnNext = new ImageView(context);
        btnStop = new ImageView(context);
        spinner = new Spinner(context);
        LayoutParams btnParams = new LayoutParams(DisplayUtil.dip2px(context, 36), DisplayUtil.dip2px(context, 36));
        btnParams.setMargins(DisplayUtil.dip2px(context, 12), DisplayUtil.dip2px(context, 8), DisplayUtil.dip2px(context, 12), DisplayUtil.dip2px(context, 8));

        btnPrevious.setLayoutParams(btnParams);
        btnPlay.setLayoutParams(btnParams);
        btnNext.setLayoutParams(btnParams);
        btnStop.setLayoutParams(btnParams);
        spinner.setLayoutParams(btnParams);

        btnPlay.setBackgroundResource(R.drawable.play);
        btnPrevious.setBackgroundResource(R.drawable.skip_previous);
        btnNext.setBackgroundResource(R.drawable.skip_next);
        btnStop.setBackgroundResource(R.drawable.stop);
        spinner.setBackgroundResource(R.drawable.menu);

        btnPrevious.setPadding(0, 0, 0, 0);
        btnNext.setPadding(0, 0, 0, 0);
        btnPlay.setPadding(0, 0, 0, 0);
        btnStop.setPadding(0, 0, 0, 0);
        spinner.setPadding(0, 0, 0, 0);

        linearLayout.addView(btnPrevious);
        linearLayout.addView(btnPlay);
        linearLayout.addView(btnNext);
        linearLayout.addView(btnStop);
        linearLayout.addView(spinner);
        addView(linearLayout);
    }
}