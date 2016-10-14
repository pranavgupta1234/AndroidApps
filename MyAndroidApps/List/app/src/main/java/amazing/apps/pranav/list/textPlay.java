package amazing.apps.pranav.list;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class textPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_play);
        Button button =(Button)findViewById(R.id.button);
        final EditText editText=(EditText)findViewById(R.id.password);
        final ToggleButton passTog=(ToggleButton)findViewById(R.id.tog);
        final TextView textView=(TextView)findViewById(R.id.textView);
        passTog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passTog.isChecked()){
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else{
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=editText.getText().toString();
                textView.setText(check);
                if(check.contentEquals("hello")){
                    textView.setTextColor(Color.CYAN);
                    textView.setTextSize(60);
                }
                if(check.contentEquals(check)){
                    Random crazy =new Random();
                    textView.setText(check);
                    textView.setTextSize(crazy.nextInt(100));
                    textView.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
                   switch (crazy.nextInt(3)){
                      case 0:
                            textView.setGravity(Gravity.CENTER);
                            break;
                      case 1:
                            textView.setGravity(Gravity.LEFT);
                            break;
                      case 2:
                            textView.setGravity(Gravity.RIGHT);
                            break;
                   }
                }
            }
        });
    }
}
