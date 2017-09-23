package example.com.mymusic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PlayService extends Service {
    public PlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
