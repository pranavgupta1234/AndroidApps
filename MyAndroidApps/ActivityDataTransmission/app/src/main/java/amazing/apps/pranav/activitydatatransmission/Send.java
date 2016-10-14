package amazing.apps.pranav.activitydatatransmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by root on 11/10/16.
 */

public class Send extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    TextView question,test;
    Button returnData;
    RadioGroup selectionList;
    String gotMessage;
    String setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialise();
        //Bundle gotBasket =  getIntent().getExtras();
        //gotMessage=gotBasket.getString("key");
        //question.setText(gotMessage);
    }

    private void initialise() {
        question =(TextView) findViewById(R.id.tv1);
        test = (TextView)findViewById(R.id.tv2);
        returnData=(Button)findViewById(R.id.Breturn);
        selectionList=(RadioGroup)findViewById(R.id.RG);
        returnData.setOnClickListener(this);
        selectionList.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer",setData);
        person.putExtras(backpack);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
         switch (checkedId){
             case R.id.rb1:
                 setData = "Probably Right !!!";
                 break;
             case R.id.rb2:
                 setData = "Definitely Right !!!";
                 break;
             case R.id.rb3:
                 setData = "Tumse Na Ho Payega !!!";
                 break;
         }
        test.setText(setData);
    }
}
