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
public class ZeroScore extends Activity{
    Button button;
    TextView scr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zeroscore);
        scr=(TextView)findViewById(R.id.scr);
        button = (Button)findViewById(R.id.over);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("amazing.apps.pranav.random.GAME");
                startActivity(intent);
            }
        });
    }
}
