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

public class Game extends Activity {
    Button button,getans,reset,a,b,c,d;
    TextView tv,opt1,opt2,opt3,opt4,ans,com,timer,resp,funfacts;
    int i,answer_correct=0,answe_wrong=0;
    int score=0;
    int difficulty=20000;
    Random crazy;
    int flag=0;
    int response=0;
    String question = "";
    String question_show="";
    String answer="";
    String option1="",option2="",option3="";
    String final_score;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.gen);
        tv = (TextView)findViewById(R.id.question);
        com = (TextView)findViewById(R.id.comp);
        opt1=(TextView)findViewById(R.id.option1);
        opt2=(TextView)findViewById(R.id.option2);
        opt3=(TextView)findViewById(R.id.option3);
        opt4=(TextView)findViewById(R.id.option4);
        resp=(TextView)findViewById(R.id.sysresp);
        timer=(TextView)findViewById(R.id.timer);
        funfacts=(TextView)findViewById(R.id.funfacts);
        //ans=(TextView)findViewById(R.id.answer);
        getans=(Button)findViewById(R.id.getans);
        reset=(Button)findViewById(R.id.reset);
        a=(Button)findViewById(R.id.a);
        b=(Button)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.d);
        answe_wrong=0;
        answer_correct=0;
        //timer.setText("Left:20s");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer_correct=0;
                answe_wrong=0;
                flag = 1;
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
                opt1.setText("");
                opt2.setText("");
                opt3.setText("");
                opt4.setText("");
                question = "";
                question_show = "";
                answer = "";
                option1 = "";
                option2 = "";
                option3 = "";
                for (i = 1; i <= 10; i++) {
                    crazy = new Random();
                    switch (crazy.nextInt(4)) {
                        case 0:
                            //tv.append("A");
                            question += "A";
                            answer += "T";
                            break;
                        case 1:
                            //tv.append("T");
                            question += "T";
                            answer += "A";
                            break;
                        case 2:
                            //tv.append("G");
                            question += "G";
                            answer += "C";
                            break;
                        case 3:
                            //tv.append("C");
                            question += "C";
                            answer += "G";
                            break;
                    }
                }
                int count = 0;
                for (i = 0; i < 10; i++) {
                    crazy = new Random();
                    switch (crazy.nextInt(2)) {
                        case 0:
                            question_show += question.charAt(i);
                            option1 += question.charAt(i);
                            option2 += question.charAt(i);
                            option3 += question.charAt(i);
                            //option4 += question.charAt(i);
                            break;
                        case 1:
                            if (count < 5) {
                                question_show += "X";
                                count++;
                                switch (crazy.nextInt(4)) {
                                    case 0:
                                        option1 += "A";
                                        option2 += "T";
                                        option3 += "G";
                                        break;
                                    case 1:
                                        option1 += "C";
                                        option2 += "A";
                                        option3 += "T";

                                        break;
                                    case 2:
                                        option1 += "T";
                                        option2 += "G";
                                        option3 += "C";

                                        break;
                                    case 3:
                                        option1 += "G";
                                        option2 += "C";
                                        option3 += "A";

                                        break;
                                }
                                break;
                            } else {
                                question_show += question.charAt(i);
                                option1 += question.charAt(i);
                                option2 += question.charAt(i);
                                option3 += question.charAt(i);
                                break;
                            }
                    }
                }
                //tv.setText(question_show);
                com.setText(answer);
                switch (crazy.nextInt(4)) {
                    case 0:
                        opt1.setText(option1);
                        opt2.setText(option2);
                        opt3.setText(option3);
                        opt4.setText(question);
                        break;
                    case 1:
                        opt1.setText(question);
                        opt2.setText(option2);
                        opt3.setText(option3);
                        opt4.setText(option1);
                        break;
                    case 2:
                        opt1.setText(option1);
                        opt2.setText(option2);
                        opt3.setText(question);
                        opt4.setText(option3);
                        break;
                    case 3:
                        opt1.setText(option1);
                        opt2.setText(question);
                        opt3.setText(option3);
                        opt4.setText(option2);
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
        /*getans.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(flag==1){
                    Intent intent =new Intent("amazing.apps.pranav.random.SCORE");
                    startActivity(intent);

                }
                else {
                    ans.setText("Please Start To Play");
                }
                //ans.setText(question);
            }
        });*/
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.contentEquals(opt1.getText().toString())){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
                    //response=1;
                    difficulty=difficulty-1000;
                    countDownTimer.cancel();
                    //button.performClick();
                    button.setEnabled(true);

                }
                else {
                    //resp.setText("Incorrect Response");
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Game.this,FinalScore.class);
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
                if(question.contentEquals(opt2.getText().toString())){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
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
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Game.this,FinalScore.class);
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
                if(question.contentEquals(opt3.getText().toString())){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
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
                    answe_wrong=1;
                    final_score= "***"+score+"***";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Game.this,FinalScore.class);
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
                if(question.contentEquals(opt4.getText().toString())){
                    resp.setText("Congoz ! Correct Answer !"+"\n"+"You have earned 10 points");
                    score+=10;
                    answer_correct=1;
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
                    answe_wrong=1;
                    final_score= " **** "+score+" **** ";
                    Bundle basket= new Bundle();
                    basket.putString("game_score",final_score);
                    Intent a= new Intent(Game.this,FinalScore.class);
                    a.putExtras(basket);
                    startActivity(a);
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Game.this, MainActivity.class));
        finish();
    }
}
