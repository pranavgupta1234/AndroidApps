package amazing.apps.pranav.random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by root on 29/10/16.
 */
public class Variables extends Activity{
    Button button;
    TextView scr;
    String score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscore);
        scr=(TextView)findViewById(R.id.scr);
        button = (Button)findViewById(R.id.over);
        Bundle gotBasket = getIntent().getExtras();
        score=gotBasket.getString("game_score");
        scr.setText(score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("amazing.apps.pranav.random.VARIABLE");
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Variables.this, MainActivity.class));
        finish();
    }
}
