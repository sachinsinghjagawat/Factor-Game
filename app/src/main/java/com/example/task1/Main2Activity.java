package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import com.example.task1.FirstApp;

import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {

    TextView instruction;
    FirstApp obj = new FirstApp();
    Button b1 ;
    Button b2 ;
    Button b3 ;
    Button next ;
    int score ;
    int maxScore;
    TextView curScore ;
    TextView curMax ;
    TextView countDown ;
    CountDownTimer timer ;
    LinearLayout layout;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        instruction = (TextView) findViewById(R.id.textView3);
        layout = (LinearLayout)findViewById(R.id.linear);
        curScore = (TextView) findViewById(R.id.currentScore);
        curMax = (TextView) findViewById(R.id.maximumScore);
        LoadData();

        Intent myIntent = getIntent() ;
        int value = myIntent.getIntExtra( "key" , 0 );
        instruction.setText( "Choose the correct factor for the integer " + value);

        obj.n = value ;
        obj.getValue();
        obj.getOptions();

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        next = (Button) findViewById(R.id.button7);

        b1.setText(obj.op3[0] + " ");
        b2.setText(obj.op3[1] + " ");
        b3.setText(obj.op3[2] + " ");



        countDown = (TextView) findViewById(R.id.countDown);
        timer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDown.setText("Time Left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if ( obj.answer.contains(obj.op3[0])){
                    b1.setBackgroundColor(Color.GREEN);
                }else if ( obj.answer.contains(obj.op3[1])){
                    b2.setBackgroundColor(Color.GREEN);
                } else{
                    b3.setBackgroundColor(Color.GREEN);
                }


                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    Intent myIntent = new Intent(Main2Activity.this, Main4Activity.class);
                    startActivity(myIntent);


                    }
                });
                score = 0 ;
            }
        }.start();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( obj.answer.contains(obj.op3[0])){
                    score++ ;
                    layout.setBackgroundColor(Color.GREEN);
                    timer.cancel();
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(myIntent);
                        }
                    });

                }else{
                    layout.setBackgroundColor(Color.RED);
                    score-- ;
                    if ( obj.answer.contains(obj.op3[1])){
                        b2.setBackgroundColor(Color.GREEN);
                    }else{
                        b3.setBackgroundColor(Color.GREEN);
                    }
                    timer.cancel();
                    Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(myIntent);
                        }
                    });
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( obj.answer.contains(obj.op3[1])){
                    score++ ;
                    layout.setBackgroundColor(Color.GREEN);
                    timer.cancel();
//                    curScore.setText("CurScore: " + score);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(myIntent);
                        }
                    });

                }else{
                    layout.setBackgroundColor(Color.RED);
                    score-- ;
                    if ( obj.answer.contains(obj.op3[0])){
                        b1.setBackgroundColor(Color.GREEN);
                    }else{
                        b3.setBackgroundColor(Color.GREEN);
                    }
                    timer.cancel();
                    Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(myIntent);
                        }
                    });

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( obj.answer.contains(obj.op3[2])){
                    score++ ;
                    layout.setBackgroundColor(Color.GREEN);
                    timer.cancel();
//                    curScore.setText("CurScore: " + score);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                            //                    myIntent.putExtra("name", score); //Optional parameters
                            startActivity(myIntent);
                        }
                    });


                }else{
                    layout.setBackgroundColor(Color.RED);
                    score-- ;
                    if ( obj.answer.contains(obj.op3[1])){
                        b2.setBackgroundColor(Color.GREEN);
                    }else{
                        b1.setBackgroundColor(Color.GREEN);
                    }
                    timer.cancel();
                    Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                            //                    myIntent.putExtra("name", score); //Optional parameters
                            startActivity(myIntent);
                            //                    b1.setBackgroundColor(Color.GREEN);
                        }
                    });


                }
            }


        });
    }

    public void saveData (){
        SharedPreferences sharedPreferences = getSharedPreferences("saveScore" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt ( "counterScore" , score);
        if(score >= maxScore){
            maxScore = score ;
        }
        editor.putInt ("counterMaxScore" , maxScore);
        editor.apply();
    }

    public void LoadData (){
        SharedPreferences sharedPreferences = getSharedPreferences("saveScore" , MODE_PRIVATE);
        score = sharedPreferences.getInt( "counterScore" , MODE_PRIVATE);
        curScore.setText("CurScore: " + score);
        maxScore = sharedPreferences.getInt("counterMaxScore" , MODE_PRIVATE);
        curMax.setText("MaxScore: " + maxScore);
    }

    protected void onPause () {
        super.onPause();
        saveData();
    }
}
