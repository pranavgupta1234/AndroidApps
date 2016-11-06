package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 28/10/16.
 */

public class score extends Activity {
    Button cancel,over;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        cancel=(Button)findViewById(R.id.cancel);
        over=(Button)findViewById(R.id.over);
        cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                startActivity(intent);
            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(score.this, MainActivity.class));
        finish();
    }

}
