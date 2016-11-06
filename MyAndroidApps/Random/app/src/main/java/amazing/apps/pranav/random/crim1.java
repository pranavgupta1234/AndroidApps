package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by root on 31/10/16.
 */

public class crim1 extends Activity{
    Button collect;
    Random crazy;
    TextView tv,cased;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crim1);
        tv = (TextView)findViewById(R.id.case_story);
        collect=(Button)findViewById(R.id.collect_dna);
        cased=(TextView)findViewById(R.id.cased);
        crazy = new Random();
        switch (crazy.nextInt(3)){
            case 0:
                cased.setText("Date: 17th June 1989\n" +
                        "Mr. Abhijeet was reported to be missing from\n 12th June 1989. Case was filed by his wife Mohini.\n His dead body was found near a local lake on 19th June 1989.\n" +
                        "He was never seen leaving the house on the day he went missing.\n There were only four people in the house on that day\n and he was last seen in his garage as reported by the maid.\n On investigation a hair was found his car but it was defective\n so due to lack of advancement of technology nothing was found about this hair and no other was found so the case was closed.\n" +
                        "\n" +
                        "Possible suspects:\n 1. The Wife\n" +
                        "\t\t   2. The maid\n" +
                        "\t\t   3. The Driver\n" +
                        "\t\t   4. The gardner\n"+"Find The Real Culprit\n");
                break;
            case 1:
                cased.setText("Date: 8th April 2016\n" +
                        "Tonight a kidnapping case came to Dectective james. Case was as follows:\n" +
                        "Akanksha, a fashon designing student from NIFT Kangra was kidnapped on 8th April 2016\n during Couture event in EXODIA'16.\n Exodia is tech-cult fest of IIT Mandi. Her friend Pooja\n saw someone taking Akanksha in a Maruti Van.\n She called for help but by that time the kidnapper was gone.\n Detective James and you investigated the crime seen and found a nail." +
                        "\n" +
                        "Now that the DNA structure is obtained you checked whether it belongs to Akanksha.\n But the DNA was someone others.\n Detective James checked the database of previous kidnapping cases\n and found that four kidnappers can be possible suspects.\n So he asks gel-electrophoresis result of these kidnappers.\n Now you have check whether the found DNA belong to any of these suspect."+"\nFind The Real Culprit");
                break;
            case 2:
                cased.setText("Date: 29th October 2016\n" +
                        "Today a crushed human head was found in dustbin in 2nd floor of Indira Market.\n The head is so severly damaged that it can't be recognised.\n So you are asked to extract the DNA from the head. There are\n currently four persons viz. Mohit, Akhil, Gantavya and Anand\n are missing in the town. You have access to DNA of all four\n missing person. So you decide to perform gel-electrophoresis\n to and check for a match amongst these missing person.\n"+"\nFind The Real Culprit");
                break;
        }
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("amazing.apps.pranav.random.COLLECT");
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(crim1.this, MainActivity.class));
        finish();
    }

}
