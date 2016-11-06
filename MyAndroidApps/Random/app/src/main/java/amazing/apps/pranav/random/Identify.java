package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by root on 4/11/16.
 */

public class Identify extends Activity{
    Button button;
    TextView q,option1,option2,option3,option4,resp,timer;
    ImageView imageView;
    Button a,b,c,d;
    int score=0,a1,b1,c1,d1,difficulty=10000;
    CountDownTimer countDownTimer;
    String final_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identify);
        button=(Button)findViewById(R.id.gen);
        imageView=(ImageView)findViewById(R.id.question);
        q=(TextView)findViewById(R.id.q);
        a=(Button)findViewById(R.id.a);
        b=(Button)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.d);
        option1=(TextView)findViewById(R.id.option1);
        option2=(TextView)findViewById(R.id.option2);
        option3=(TextView)findViewById(R.id.option3);
        option4=(TextView)findViewById(R.id.option4);
        timer=(TextView)findViewById(R.id.timer);
        resp=(TextView)findViewById(R.id.resp);

        a1=0;
        b1=0;
        c1=0;
        d1=0;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);
                a1=0;
                b1=0;
                c1=0;
                d1=0;
                countDownTimer = new CountDownTimer(difficulty, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText("Left:" + millisUntilFinished / 1000 + "s");
                        button.setEnabled(false);
                    }

                    public void onFinish() {
                        resp.setText("Time over!!!"+"\n"+"Score is: "+score);
                            /*Intent intent = new Intent("amazing.apps.pranav.random.ZEROSCORE");
                            startActivity(intent);*/
                        score=0;
                        button.setEnabled(true);

                    }
                };
                countDownTimer.start();
                Random crazy=new Random();
                switch (crazy.nextInt(10)) {
                    case 0:
                        q.setText("Which Base is this ?");
                        imageView.setImageResource(R.drawable.adenine);
                        option1.setText("Adenine");
                        option2.setText("Thymine");
                        option3.setText("Guanine");
                        option4.setText("Cytosine");
                        a1=1;
                        break;
                    case 1:
                        q.setText("Which Base is this ?");
                        imageView.setImageResource(R.drawable.thymine);
                        option1.setText("Adenine");
                        option2.setText("Thymine");
                        option3.setText("Guanine");
                        option4.setText("Cytosine");
                        b1=1;
                        break;
                    case 2:
                        q.setText("Which Base is this ?");
                        imageView.setImageResource(R.drawable.guanine);
                        option1.setText("Adenine");
                        option2.setText("Thymine");
                        option3.setText("Guanine");
                        option4.setText("Cytosine");
                        c1=1;
                        break;
                    case 3:
                        q.setText("Which Base is this ?");
                        imageView.setImageResource(R.drawable.cytosine);
                        option1.setText("Adenine");
                        option2.setText("Thymine");
                        option3.setText("Guanine");
                        option4.setText("Cytosine");
                        d1=1;
                        break;
                    case 4:
                        q.setText("Which protein structure is this ?");
                        imageView.setImageResource(R.drawable.primary);
                        option1.setText("Primary Protein");
                        option2.setText("Secondary Protein");
                        option3.setText("Tertiary Protein");
                        option4.setText("Quaternary Protein");
                        a1=1;
                        break;
                    case 5:
                        q.setText("Which technology is this?");
                        option1.setText("Transplantation");
                        option2.setText("Recombinant DNA");
                        option3.setText("Mutation");
                        option4.setText("Cytosine");
                        imageView.setImageResource(R.drawable.recombinant);
                        b1=1;
                        break;
                    case 6:
                        q.setText("Which enzyme is this?");
                        option1.setText("Ligase");
                        option2.setText("Polymerase");
                        option3.setText("Restricion Enzyme");
                        option4.setText("Lactase");
                        imageView.setImageResource(R.drawable.bottle_enzyme);
                        c1=1;
                        break;
                    case 7:
                        q.setText("What is this diagram?");
                        imageView.setImageResource(R.drawable.dna_finger);
                        option1.setText("Adenine");
                        option2.setText("Recombinant DNA Technology");
                        option3.setText("Polymerase Chain Reaction");
                        option4.setText("DNA fingerprint");
                        d1=1;
                        break;
                    case 8:
                        q.setText("What is this part of?");
                        imageView.setImageResource(R.drawable.rna);
                        option1.setText("RNA");
                        option2.setText("DNA");
                        option3.setText("Guanine");
                        option4.setText("Polymerase");
                        a1=1;
                        break;
                    case 9:
                        q.setText("What is this part of?");
                        imageView.setImageResource(R.drawable.dna_part);
                        option1.setText("DNA");
                        option2.setText("RNA");
                        option3.setText("INSULIN");
                        option4.setText("m-RNA");
                        a1=1;
                        break;

                }

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                if(a1==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+" +10 ");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    countDownTimer.cancel();
                    //button.performClick();
                    button.setEnabled(true);

                }
                else {
                    //resp.setText("Incorrect Response");
                    final_score= "***"+score+"***";
                    score=0;
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Identify.this,Identifier.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                if(b1==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+" +10");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    button.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    final_score= "***"+score+"***";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Identify.this,Identifier.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                if(c1==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+" +10");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    button.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    final_score= "***"+score+"***";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Identify.this,Identifier.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                if(d1==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+" +10");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    button.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    final_score= " **** "+score+" **** ";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Identify.this,Identifier.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Identify.this, MainActivity.class));
        finish();
    }
}
