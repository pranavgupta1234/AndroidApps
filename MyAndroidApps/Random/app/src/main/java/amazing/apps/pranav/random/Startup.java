package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by root on 22/10/16.
 */

public class Startup extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          //      WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.startup);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent("amazing.apps.pranav.random.MAINACTIVITY");
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
