package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    Button click;
    TextView greeting ;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myIntent = new Intent(Main4Activity.this, MainActivity.class);
        startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        click = (Button) findViewById(R.id.button6);
        greeting = (TextView) findViewById(R.id.textView3);

//        Intent myIntent = getIntent() ;
//        int value = myIntent.getIntExtra( "name" , 0 );
//        greeting.setText( "Score: " + value);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
