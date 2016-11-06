package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Created by root on 31/10/16.
 */

public class collect extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectdna);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent("amazing.apps.pranav.random.COLLECTED");
                    startActivity(intent);
                }
            }
        };
        timer.start();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(collect.this, MainActivity.class));
        finish();
    }
}
