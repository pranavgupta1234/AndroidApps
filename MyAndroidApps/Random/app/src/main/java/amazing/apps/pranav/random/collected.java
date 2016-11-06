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

public class collected extends Activity{
    Button question;
    TextView op1,op2,op3,op4,option1,option2,option3,option4,timer,resp;
    Button opt1,opt2,opt3,opt4;
    int a,b,c,d,p,q,t,s,i,min=20,max=-1;
    int arr[];
    long mil=2000;
    CountDownTimer countDownTimer;
    int difficulty=20000;
    int score;
    int a1,b1,c1,d1;
    String final_score,answer1;
    Thread timers = new Thread(){
        @Override
        public void run() {
            try{
                sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                Intent intent = new Intent("amazing.apps.pranav.random.MAINACTIVITY");
                startActivity(intent);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collected);
        op1=(TextView)findViewById(R.id.op1);
        op2=(TextView)findViewById(R.id.op2);
        op3=(TextView)findViewById(R.id.op3);
        op4=(TextView)findViewById(R.id.op4);
        option1=(TextView)findViewById(R.id.option1);
        option2=(TextView)findViewById(R.id.option2);
        option3=(TextView)findViewById(R.id.option3);
        option4=(TextView)findViewById(R.id.option4);
        opt1=(Button)findViewById(R.id.a);
        opt2=(Button)findViewById(R.id.b);
        opt3=(Button)findViewById(R.id.c);
        opt4=(Button)findViewById(R.id.d);
        resp=(TextView)findViewById(R.id.resp);
        timer=(TextView)findViewById(R.id.timer);
        //question =(Button)findViewById(R.id.question);
        //reset =(Button)findViewById(R.id.reset);
        a1=0;
        b1=0;
        c1=0;
        d1=0;
        countDownTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Left:"+millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("Over!!!");
                resp.setText("Sorry the time is over!!!\nTry Next time");
                score=0;
                Intent intent = new Intent("amazing.apps.pranav.random.MAINACTIVITY");
                startActivity(intent);
            }

        };
        countDownTimer.start();
        Random crazy = new Random();
        p=(crazy.nextInt(20)+1);
        q=(crazy.nextInt(20)+1);
        s=(crazy.nextInt(20)+1);
        t=(crazy.nextInt(20)+1);
        answer1=p+":"+q+":"+s+":"+t;
        a=p+3;
        b=p+2;
        c=s+8;
        d=q+4;
        op1.setText(" A ) "+p*1000+" bp");
        op2.setText(" B ) "+q*1000+" bp");
        op3.setText(" C ) "+s*1000+" bp");
        op4.setText(" D ) "+t*1000+" bp");
        switch (crazy.nextInt(8)){
            case 0:
                option1.setText(p+":"+q+":"+s+":"+t);
                option2.setText(d+":"+b+":"+a+":"+c);
                option3.setText(b+":"+c+":"+d+":"+a);
                option4.setText(a+":"+c+":"+b+":"+d);
                a1=1;
                break;
            case 1:
                option1.setText(b+":"+a+":"+c+":"+d);
                option2.setText(p+":"+q+":"+s+":"+t);
                option3.setText(c+":"+b+":"+a+":"+d);
                option4.setText(a+":"+c+":"+b+":"+d);
                b1=1;
                break;
            case 2:
                option1.setText(a+":"+d+":"+c+":"+b);
                option2.setText(d+":"+b+":"+a+":"+c);
                option3.setText(p+":"+q+":"+s+":"+t);
                option4.setText(a+":"+c+":"+b+":"+d);
                c1=1;
                break;
            case 3:
                option1.setText(d+":"+b+":"+c+":"+a);
                option2.setText(d+":"+b+":"+a+":"+c);
                option3.setText(b+":"+c+":"+d+":"+a);
                option4.setText(p+":"+q+":"+s+":"+t);
                d1=1;
                break;
            case 4:
                option1.setText(p+":"+q+":"+s+":"+t);
                option2.setText(b+":"+d+":"+a+":"+c);
                option3.setText(b+":"+d+":"+c+":"+a);
                option4.setText(d+":"+c+":"+a+":"+b);
                a1=1;
                break;
            case 5:
                option1.setText(b+":"+a+":"+c+":"+d);
                option2.setText(p+":"+q+":"+s+":"+t);
                option3.setText(c+":"+a+":"+d+":"+b);
                option4.setText(c+":"+d+":"+a+":"+b);
                b1=1;
                break;
            case 6:
                option1.setText(a+":"+d+":"+c+":"+b);
                option2.setText(d+":"+b+":"+c+":"+a);
                option3.setText(p+":"+q+":"+s+":"+t);
                option4.setText(a+":"+c+":"+b+":"+d);
                c1=1;
                break;
            case 7:
                option1.setText(d+":"+a+":"+c+":"+b);
                option2.setText(d+":"+b+":"+a+":"+c);
                option3.setText(b+":"+c+":"+d+":"+a);
                option4.setText(p+":"+q+":"+s+":"+t);
                d1=1;
                break;

        }
        //resp.setText(answer1);
        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a1==1){
                    resp.setText("Congoz ! You Have found the Criminal");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    countDownTimer.cancel();
                    //button.performClick();

                }
                else {
                    //resp.setText("Incorrect Response");
                    resp.setText("Unfortunately this suspect is not Criminal\nTry Next Case");
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                    countDownTimer.cancel();

                }
                timers.start();
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1==1){
                    resp.setText("Congoz ! You Have found the Criminal");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                }
                else {
                    //resp.setText("Incorrect Response");
                    resp.setText("Unfortunately this suspect is not Criminal\nTry Next Case");
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                    countDownTimer.cancel();

                }
                timers.start();
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1==1){
                    resp.setText("Congoz ! You Have found the Criminal");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.CORRECT");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                }
                else {
                    //resp.setText("Incorrect Response");
                    resp.setText("Unfortunately this suspect is not Criminal\nTry Next Case");
                    //Intent intent = new Intent("amazing.apps.pranav.random.FINALSCORE");
                    //startActivity(intent);
                    countDownTimer.cancel();
                }
                timers.start();
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d1==1){
                    resp.setText("Congoz ! You Have found the Criminal");
                    score+=10;
                    //response=1;
                    difficulty=difficulty-1000;
                    //Intent intent = new Intent("amazing.apps.pranav.random.MAINACTIVITY");
                    //startActivity(intent);
                    countDownTimer.cancel();
                    //button.performClick();
                }
                else {
                    //resp.setText("Incorrect Response");
                    resp.setText("Unfortunately this suspect is not Criminal\nTry Next Case");
                    countDownTimer.cancel();
                }
                timers.start();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(collected.this, MainActivity.class));
        finish();
    }
}
