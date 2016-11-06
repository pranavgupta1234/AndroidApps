package amazing.apps.pranav.random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by root on 23/10/16.
 */

public class Gel extends Activity{
    Button question;
    Button opt1,opt2,opt3,opt4;
    TextView funfacts,op1,op2,op3,op4,option1,option2,option3,option4,timer,resp;
    int p,q,t,s,i,min,max;
    int arr[];
    int answer_correct=0;
    int answe_wrong=0;
    int score;
    int difficulty=20000;
    String final_score;
    CountDownTimer countDownTimer;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gel);
        op1=(TextView)findViewById(R.id.op1);
        op2=(TextView)findViewById(R.id.op2);
        op3=(TextView)findViewById(R.id.op3);
        op4=(TextView)findViewById(R.id.op4);
        option1=(TextView)findViewById(R.id.option1);
        option2=(TextView)findViewById(R.id.option2);
        option3=(TextView)findViewById(R.id.option3);
        option4=(TextView)findViewById(R.id.option4);
        funfacts=(TextView)findViewById(R.id.funfacts);
        opt1=(Button)findViewById(R.id.a);
        opt2=(Button)findViewById(R.id.b);
        opt3=(Button)findViewById(R.id.c);
        opt4=(Button)findViewById(R.id.d);
        timer=(TextView)findViewById(R.id.timer);
        question =(Button)findViewById(R.id.question);
        resp=(TextView)findViewById(R.id.resp);
        score=0;
        //reset =(Button)findViewById(R.id.reset);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setText("Left:20s");
                resp.setText("GO FAST !!!" + "\n" + "The Timer is ON");
                countDownTimer = new CountDownTimer(difficulty, 1000) {

                    public void onTick(long millisUntilFinished) {
                        timer.setText("Left:" + millisUntilFinished / 1000 + "s");
                        question.setEnabled(false);
                    }

                    public void onFinish() {
                        resp.setText("Sorry the time is over!!!"+"\n"+"Score is :: "+score);
                            /*Intent intent = new Intent("amazing.apps.pranav.random.ZEROSCORE");
                            startActivity(intent);*/
                        score=0;
                        question.setEnabled(true);
                    }
                };
                countDownTimer.start();
                Random crazy = new Random();
                p = (crazy.nextInt(20) + 1);
                q = (crazy.nextInt(20) + 1);
                s = (crazy.nextInt(20) + 1);
                t = (crazy.nextInt(20) + 1);
                arr = new int[4];
                arr[0]=p;
                arr[1]=q;
                arr[2]=s;
                arr[3]=t;
                min=50;
                max=-1;
                for (i = 0; i < 4; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                answer=min+","+max;
                op1.setText(" A ) " + p * 1000 + " bp");
                op2.setText(" B ) " + q * 1000 + " bp");
                op3.setText(" C ) " + s * 1000 + " bp");
                op4.setText(" D ) " + t * 1000 + " bp");
                switch (crazy.nextInt(10)) {
                    case 0:
                        option1.setText(min + "," + max);
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        break;
                    case 1:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText(min + "," + max);
                        break;
                    case 2:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText(min + "," + max);
                        option4.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        break;
                    case 3:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText(min + "," + max);
                        break;
                    case 4:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText((crazy.nextInt(20)+1) + "," + crazy.nextInt(20)+1);
                        option3.setText(max + "," + min);
                        option4.setText(min + "," + max);
                        break;
                    case 5:
                        option1.setText(min + "," + max);
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        break;
                    case 6:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText(min + "," + max);
                        option4.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        break;
                    case 7:
                        option1.setText(min + "," + max);
                        option2.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText(max + "," + min);
                        break;
                    case 8:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText(min + "," + max);
                        break;
                    case 9:
                        option1.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option2.setText(max + "," + min);
                        option3.setText((crazy.nextInt(20)+1) + "," + (crazy.nextInt(20)+1));
                        option4.setText(min + "," + max);
                        break;
                }
                switch (crazy.nextInt(10)) {
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
                    case 9:
                        funfacts.setText("Human penis once used to be spiny. That’s scary! Luckily that DNA code which made the penis spiny is lost.");
                        break;
                }
            }

        });
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option1.getText().toString().contentEquals(answer)){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
                    //response=1;
                    difficulty=difficulty-1000;
                    countDownTimer.cancel();
                    //button.performClick();
                    question.setEnabled(true);

                }
                else {
                    //resp.setText("Incorrect Response");
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    score=0;
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Gel.this,Correct.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option2.getText().toString().contentEquals(answer)){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    question.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    score=0;
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Gel.this,Correct.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option3.getText().toString().contentEquals(answer)){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    question.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    score=0;
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Gel.this,Correct.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option4.getText().toString().contentEquals(answer)){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                    question.setEnabled(true);
                }
                else {
                    //resp.setText("Incorrect Response");
                    answe_wrong=1;
                    final_score= " **** "+score+" **** ";
                    score=0;
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Gel.this,Correct.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Gel.this, MainActivity.class));
        finish();
    }
}
