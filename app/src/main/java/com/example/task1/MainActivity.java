package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button submitValue;
    EditText number;
    long backPressedTime;
    Toast backToast ;

    @Override
    public void onBackPressed() {
//        if(backPressedTime + 2000 > System.currentTimeMillis()){
//            backToast.cancel();
//            super.onBackPressed();
//            return;
//        }else{
//            backToast.makeText(getBaseContext() , "Press back again to exit" , Toast.LENGTH_SHORT);
//            backToast.show();
//        }
//        backPressedTime =System.currentTimeMillis();
//        finish();
//        System.exit(1000);

        while(1 > 0){
        moveTaskToBack(true);
        MainActivity.this.finish();}

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitValue = (Button)findViewById(R.id.button4);

        submitValue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                number   = (EditText)findViewById(R.id.editText);

                String value= number.getText().toString();
                int finalValue=Integer.parseInt(value);

                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                myIntent.putExtra("key", finalValue); //Optional parameters
                startActivity(myIntent);
            }





        }   );
    }
}

