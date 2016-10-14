package amazing.apps.pranav.email;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 10/10/16.
 */

public class Email extends Activity implements View.OnClickListener{
    Button sendEmail;
    EditText personsEmail, intro,personsName,stupidThings,hatefulAction,outro;
    String emailAdd,beginning,name,stupidAction,hatefulAct,out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initialiseVars();
        sendEmail.setOnClickListener(this);
    }

    private void initialiseVars() {
        personsEmail=(EditText)findViewById(R.id.email);
        intro=(EditText)findViewById(R.id.intro);
        personsName=(EditText)findViewById(R.id.name);
        stupidThings=(EditText)findViewById(R.id.things);
        hatefulAction=(EditText)findViewById(R.id.action);
        outro=(EditText)findViewById(R.id.outro);
        sendEmail=(Button)findViewById(R.id.send_email);
    }

    @Override
    public void onClick(View v) {
        convertEditTextVarsIntoStrings();
        String emailaddress[]={emailAdd};
        String message = "Well Hello" + name + "I just wanted to say" +beginning+"Not only that but I hate u"
         + stupidAction+"that just really makes me crazy . I just want to make "+ hatefulAct+"Well"+out+"Bye!!";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"You are a dick");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(emailIntent);
    }

    private void convertEditTextVarsIntoStrings() {
        emailAdd=personsEmail.getText().toString();
        beginning=intro.getText().toString();
        name=personsName.getText().toString();
        stupidAction=stupidThings.getText().toString();
        hatefulAct=hatefulAction.getText().toString();
        out=outro.getText().toString();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
