package example.com.mymusic.entity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/**
 * @author Wang Shaoming
 * @create 2017/11/20
 * @description
 */

public class Player extends MediaPlayer {
    private MediaPlayer mediaPlayer;
    private Context context;
    private int resId;
    public Player(Context context, int resId) {
        mediaPlayer = MediaPlayer.create(context, resId);
    }

    public Player(Context context, Uri uri) {
        mediaPlayer = MediaPlayer.create(context, uri);
    }
}
