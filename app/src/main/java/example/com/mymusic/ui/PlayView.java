package example.com.mymusic.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.mymusic.R;

/**
 * @author Wang Shaoming
 * @create 2017/9/5
 * @description
 */

public class PlayView extends LinearLayout {
//    private Context context;
    private int width;
    public PlayView(Context context, int width) {
        super(context);
//        this.context = context;
        this.width = width;
        this.setOrientation(VERTICAL);
        init(context);
    }

    private void init(Context context) {

        TextView nameText = new TextView(context);
        LayoutParams nameParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 48);//换成dp
        nameText.setLayoutParams(nameParams);
        nameText.setGravity(Gravity.CENTER);
        nameText.setText("music name");
        addView(nameText);

        ImageView playImage = new ImageView(context);
        LayoutParams params = new LayoutParams(width, (int)(width*1.2));
        playImage.setLayoutParams(params);
        playImage.setImageResource(R.mipmap.ic_launcher_round);
        addView(playImage);

        LinearLayout linearLayout = new LinearLayout(context);
        LayoutParams params1 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        linearLayout.setLayoutParams(params1);
        linearLayout.setOrientation(HORIZONTAL);

        Button btnStart, btnPause, btnStop;
        btnStart = new Button(context);
        btnPause = new Button(context);
        btnStop = new Button(context);
        LayoutParams btnParams = new LayoutParams(0, 72, 1);
        btnStart.setLayoutParams(btnParams);
        btnPause.setLayoutParams(btnParams);
        btnStop.setLayoutParams(btnParams);
        btnPause.setBackground(null);
        btnStart.setBackground(null);
        btnStop.setBackground(null);
        btnStart.setText("start");
        btnPause.setText("pause");
        btnStop.setText("stop");
//        btnStart.setBackgroundColor(Color.RED);
//        btnPause.setBackgroundColor(Color.YELLOW);
//        btnStop.setBackgroundColor(Color.GREEN);

        linearLayout.addView(btnStart);
        linearLayout.addView(btnPause);
        linearLayout.addView(btnStop);
        addView(linearLayout);

    }
}
