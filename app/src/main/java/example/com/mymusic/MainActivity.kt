package example.com.mymusic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this@MainActivity, "Hello MyMusic!", Toast.LENGTH_SHORT).show()
    }
}
