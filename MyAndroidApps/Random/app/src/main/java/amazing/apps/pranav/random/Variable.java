package amazing.apps.pranav.random;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Variable extends Activity {
    Button button,a,b,c,d;
    TextView tv,opt1,opt2,opt3,opt4,ans,com,resp,timer,funfacts;
    int i,score,difficulty=20000;
    int p,q,r,s;
    Random crazy;
    String question = "";
    String question_show="";
    String answer="";
    String option1="",option2="",option3="";
    CountDownTimer countDownTimer;
    String final_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variable);
        button = (Button)findViewById(R.id.gen);
        //tv = (TextView)findViewById(R.id.comp);
        com = (TextView)findViewById(R.id.comp);
        opt1=(TextView)findViewById(R.id.option1);
        opt2=(TextView)findViewById(R.id.option2);
        opt3=(TextView)findViewById(R.id.option3);
        opt4=(TextView)findViewById(R.id.option4);
        timer=(TextView)findViewById(R.id.timer);
        resp=(TextView)findViewById(R.id.sysresp);
        funfacts=(TextView)findViewById(R.id.funfacts);
        a=(Button)findViewById(R.id.a);
        b=(Button)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.d);
        score=0;
        p=0;
        q=0;
        r=0;
        s=0;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt1.setText("");
                opt2.setText("");
                opt3.setText("");
                opt4.setText("");
                //tv.setText("");
                question = "";
                question_show="";
                answer="";
                option1="";
                option2="";
                option3="";
                button.setText(" Click To Generate Next Question");
                timer.setText("Left:20s");
                resp.setText("GO FAST !!!" + "\n" + "The Timer is ON");
                countDownTimer = new CountDownTimer(difficulty, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText("Left:" + millisUntilFinished / 1000 + "s");
                        button.setEnabled(false);
                    }

                    public void onFinish() {
                        resp.setText("Sorry the time is over!!!"+"\n"+"Score is :: "+score);
                            /*Intent intent = new Intent("amazing.apps.pranav.random.ZEROSCORE");
                            startActivity(intent);*/
                        score=0;
                        button.setEnabled(true);

                    }
                };
                countDownTimer.start();
                for (i = 1; i <= 10; i++) {
                    crazy = new Random();
                    switch (crazy.nextInt(4)) {
                        case 0:
                            //tv.append("A");
                            question += "A";
                            answer+="T";
                            break;
                        case 1:
                            //tv.append("T");
                            question += "T";
                            answer+="A";
                            break;
                        case 2:
                            //tv.append("G");
                            question += "G";
                            answer+="C";
                            break;
                        case 3:
                            //tv.append("C");
                            question += "C";
                            answer+="G";
                            break;
                    }
                }
                //tv.setText("");
                //opt1.setText(question);
                //opt2.setText(question);
                //opt3.setText(question);
                //opt4.setText(question);
                int count=0;
                for (i = 0; i < 10; i++) {
                    crazy = new Random();
                    switch (crazy.nextInt(2)) {
                        case 0:
                            question_show += question.charAt(i);
                            switch (crazy.nextInt(3)){
                                case 0:
                                    option1 += "A";
                                    option2 += "T";
                                    option3 += "C";
                                    break;
                                case 1:
                                    option1 += "T";
                                    option2 += "G";
                                    option3 += "A";
                                    break;
                                case 2:
                                    option1 += "G";
                                    option2 += "A";
                                    option3 += "T";
                            }

                            //option4 += question.charAt(i);
                            break;
                        case 1:
                            if(count<5) {
                                question_show += "X";
                                count++;
                                switch (crazy.nextInt(4)){
                                    case 0:
                                        option1+="A";
                                        option2+="T";
                                        option3+="G";
                                        break;
                                    case 1:
                                        option1+="C";
                                        option2+="A";
                                        option3+="T";

                                        break;
                                    case 2:
                                        option1+="T";
                                        option2+="G";
                                        option3+="C";

                                        break;
                                    case 3:
                                        option1+="G";
                                        option2+="C";
                                        option3+="A";

                                        break;
                                }
                                break;
                            }
                            else{
                                question_show += question.charAt(i);
                                option1 += answer.charAt(i);
                                option2 += answer.charAt(i);
                                option3 += answer.charAt(i);
                                break;
                            }
                    }
                }
                com.setText(question_show);
                //com.setText(answer);
                switch (crazy.nextInt(4)) {
                    case 0:
                        opt1.setText(option1);
                        opt2.setText(option2);
                        opt3.setText(option3);
                        opt4.setText(answer);
                        s=1;
                        break;
                    case 1:
                        opt1.setText(answer);
                        opt2.setText(option2);
                        opt3.setText(option3);
                        opt4.setText(option1);
                        p=1;
                        break;
                    case 2:
                        opt1.setText(option1);
                        opt2.setText(option2);
                        opt3.setText(answer);
                        opt4.setText(option3);
                        r=1;
                        break;
                    case 3:
                        opt1.setText(option1);
                        opt2.setText(answer);
                        opt3.setText(option3);
                        opt4.setText(option2);
                        q=1;
                        break;

                }
                switch (crazy.nextInt(9)) {
                    case 0:
                        funfacts.setText("Your DNA could stretch from the earth to the sun 600 times!");
                        break;
                    case 1:
                        funfacts.setText("We’re all 99.9 percent alike!");
                        break;
                    case 2:
                        funfacts.setText(" DNA is present in each and every cell of human body. Each DNA strand is 1.8 meters long but squeezed into a space of 0.09 micrometers!");
                        break;
                    case 3:
                        funfacts.setText(" 99.9% of DNA is identical in all humans on this Earth. The remaining 0.1% is what helps us to differentiate between DNA sequences allowing us to tell which DNA belongs to whom.");
                        break;
                    case 4:
                        funfacts.setText(" DNA was first discovered in year 1869 by a man named Friedrich Miescher.");
                        break;
                    case 5:
                        funfacts.setText(" If someone undergoes bone marrow transplant, the recipient may or may not have DNA of the donor. In most cases the recipient will not have foreign DNA.");
                        break;
                    case 6:
                        funfacts.setText("The center of our galaxy Milky Way contains molecular precursors of DNA.");
                        break;
                    case 7:
                        funfacts.setText("It will take 50 years to type the entire human genome if someone types at a speed of 60 wpm (words per minute) and works 8 hours a day!");
                        break;
                    case 8:
                        funfacts.setText("Human penis once used to be spiny. That’s scary! Luckily that DNA code which made the penis spiny is lost.");
                        break;

                }


            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
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
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Variable.this,Variables.class);
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
                if(q==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
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
                    Intent a= new Intent(Variable.this,Variables.class);
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
                if(r==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
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
                    Intent a= new Intent(Variable.this,Variables.class);
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
                if(s==1){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
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
                    Intent a= new Intent(Variable.this,Variables.class);
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
        startActivity(new Intent(Variable.this, MainActivity.class));
        finish();
    }
}
