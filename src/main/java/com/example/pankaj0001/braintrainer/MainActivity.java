package com.example.pankaj0001.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button go;
    TextView sumText;
    LinearLayout l;
    TextView timer,score,decission,exitt,scorefinal;
    Button b1,b2,b3,b4;
    CountDownTimer countDownTimer;
    Random rand = new Random();
    int locationCorrectAnswer;


    int i=0,j=0;



    public void startt(final View view)
    {

        if(j==10)
        {

        }
        go.setVisibility(View.INVISIBLE);
        go.setEnabled(false);
        l.setVisibility(View.VISIBLE);
        sumText.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        exitt.setVisibility(View.VISIBLE);
         locationCorrectAnswer= rand.nextInt(4);
        exitt.setEnabled(true);
//*********************************************************************{correct/incorrect logic}*************************

        ArrayList<Integer>answers=new ArrayList<Integer>();


        //decission.setText("decission");

        int a= rand.nextInt(51);
        int b= rand.nextInt(51);


        sumText.setText(a+"+"+b);



        for (int i=0;i<4;i++)
        {
            if(i==locationCorrectAnswer)
            {
                answers.add(a+b);


            }
            else
            {  /*
                int l=  rand.nextInt(102);


                    answers.add(l);


            */
                int g=rand.nextInt(102);
            if(g!=a+b)
            {

                answers.add(g);
            }
            else
            {
                answers.add(g+1);
            }



            }

        }
    //    locationpassing=locationCorrectAnswer;

       // System.out.println(answers.get(0)+"ye bhi checking");
        b1.setText(answers.get(0).toString());
        b2.setText(answers.get(1).toString());
        b3.setText(answers.get(2).toString());
        b4.setText(answers.get(3).toString());
        /*
            *************************************************countdowntimer ***************************


        */


         countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
              long a=  millisUntilFinished/1000;

                timer.setText(a+"s");

            }

            @Override
            public void onFinish() {
                decission.setText("time up");
                    j++;
                score.setText(i+"/"+j);
                //decission.setText("decission");
                startt(view);

            }
        };
        countDownTimer.start();











    }

    public void answer(View view)
    { Button b= (Button) view;


        if(Integer.parseInt(b.getTag().toString())==locationCorrectAnswer)
        {
            i++;
            j++;
            decission.setText("Correct");
            score.setText(i+"/"+j);


        }
        else
        {   j++;
            decission.setText("InCorrect");
            score.setText(i+"/"+j);

        }
        countDownTimer.cancel();
        startt(view);




    }



    public void exit(View view)
    {
        l.setVisibility(View.INVISIBLE);
        l.setEnabled(false);
        scorefinal.setEnabled(true);
        scorefinal.setVisibility(View.VISIBLE);
        scorefinal.setText(i+"/"+j);


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go= findViewById(R.id.button);
         sumText= findViewById(R.id.sumTextview);
         l= findViewById(R.id.linearLayout);
         timer= findViewById(R.id.timerTextview);
         score= findViewById(R.id.scoreTextview);
         b1=findViewById(R.id.optionabutton);
        b2=findViewById(R.id.optionbButton);
        b3=findViewById(R.id.optioncbutton);
        b4=findViewById(R.id.optiondbutton);
        decission= findViewById(R.id.decisionTextview);
        exitt=findViewById(R.id.exitt);
        scorefinal=findViewById(R.id.textView8);







    }
}
