package amazing.apps.pranav.activitydatatransmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by root on 11/10/16.
 */

public class Get extends Activity implements View.OnClickListener{
    Button start,startFor;
    EditText sendET;
    TextView gotAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialise();
    }

    private void initialise() {
        start = (Button)findViewById(R.id.start);
        startFor= (Button)findViewById(R.id.send);
        sendET=(EditText)findViewById(R.id.editText);
        gotAnswer=(TextView)findViewById(R.id.sendTv);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent i = new Intent(Get.this,Send.class);
                startActivityForResult(i,0);
                break;
            case R.id.send:
                String message = sendET.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key",message);
                Intent in= new Intent(Get.this,Send.class);
                in.putExtras(basket);
                startActivity(in);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle basket = data.getExtras();
            String s =basket.getString("answer");
            gotAnswer.setText(s);
        }
    }
}
