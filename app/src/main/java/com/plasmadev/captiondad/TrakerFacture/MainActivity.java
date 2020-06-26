package com.plasmadev.captiondad.TrakerFacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.plasmadev.captiondad.TrakerFacture.R;

public class MainActivity extends AppCompatActivity {
    private ImageView but1;
    private ImageView but2;
    private ImageView but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);


        but1 = (ImageView) findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFacture();
            }


        });

        but2 = (ImageView) findViewById(R.id.button2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsulterFacture();
            }
        });


        but3 = (ImageView) findViewById(R.id.button3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDesEcheance();
            }
        });

    }
    public void createFacture(){
        Intent intent = new Intent(this , CreerFactureActivity.class);
        startActivity(intent);
    }
    public void ConsulterFacture(){
        Intent intent = new Intent(this , ConsulterLesFacActivity.class);
        startActivity(intent);
    }
    public void DateDesEcheance(){
        Intent intent = new Intent(this , DateDesEcheancesActivity.class);
        startActivity(intent);
    }
}

