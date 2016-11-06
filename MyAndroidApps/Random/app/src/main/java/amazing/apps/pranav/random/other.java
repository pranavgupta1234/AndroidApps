package amazing.apps.pranav.random;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class other extends Activity {
    Button button,getans,reset,a,b,c,d;
    TextView tv,opt1,opt2,opt3,opt4,ans,com,resp;
    int i;
    Random crazy;
    String question = "";
    String question_show="";
    String answer="";
    String option1="",option2="",option3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finder);
        button = (Button)findViewById(R.id.gen);
        tv = (TextView)findViewById(R.id.question);
        com = (TextView)findViewById(R.id.comp);
        opt1=(TextView)findViewById(R.id.option1);
        opt2=(TextView)findViewById(R.id.option2);
        opt3=(TextView)findViewById(R.id.option3);
        opt4=(TextView)findViewById(R.id.option4);
        resp=(TextView)findViewById(R.id.resp);
        ans=(TextView)findViewById(R.id.answer);
        getans=(Button)findViewById(R.id.getans);
        reset=(Button)findViewById(R.id.reset);
        a=(Button)findViewById(R.id.a);
        b=(Button)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.d);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt1.setText("");
                opt2.setText("");
                opt3.setText("");
                opt4.setText("");
                tv.setText("");
                question = "";
                question_show="";
                answer="";
                option1="";
                option2="";
                option3="";
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
                            option1 += question.charAt(i);
                            option2 += question.charAt(i);
                            option3 += question.charAt(i);
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
                                option1 += question.charAt(i);
                                option2 += question.charAt(i);
                                option3 += question.charAt(i);
                                break;
                            }
                    }
                }
                tv.setText(question_show);
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


            }
        });
        getans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(question);
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.contentEquals(opt1.toString())){
                    resp.setText("Correct Answer");
                }
                else
                    resp.setText("Incorrect Response");
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.contentEquals(opt2.toString())){
                    resp.setText("Correct Answer");
                }
                else
                    resp.setText("Incorrect Response");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.contentEquals(opt3.toString())){
                    resp.setText("Correct Answer");
                }
                else
                    resp.setText("Incorrect Response");
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(question.contentEquals(opt4.toString())){
                    resp.setText("Correct Answer");
                }
                else
                    resp.setText("Incorrect Response");
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Question");
                com.setText("Complimentary");
                ans.setText("Answer");
                opt1.setText("Option A");
                opt2.setText("Option B");
                opt3.setText("Option C");
                opt4.setText("Option D");
                resp.setText("System Response");
            }
        });

    }
}
