package amazing.apps.pranav.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends Activity {
    MediaPlayer ourSong;
    TextView EPref,Lpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EPref = (TextView)findViewById(R.id.ETpref);
        Lpref=(TextView)findViewById(R.id.Lpref);
        ourSong= MediaPlayer.create(MainActivity.this,R.raw.login_tone);
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkbox",true);
        if(music == true)
            ourSong.start();
        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String Et = getData.getString("name","This is default value...");
        String values = getData.getString("list","1");
        EPref.setText(Et);
        Lpref.setText(values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater Inflate= getMenuInflater();
        Inflate.inflate(R.menu.cool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.aboutUs:
                Intent i = new Intent("amazing.apps.pranav.menu.ABOUT");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent("amazing.apps.pranav.menu.PREFS");
                startActivity(p);
                break;
            case R.id.exit:
                finish();
        }
        return false;
    }
}
