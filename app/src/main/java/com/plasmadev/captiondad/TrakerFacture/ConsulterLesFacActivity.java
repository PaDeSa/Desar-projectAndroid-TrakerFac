package com.plasmadev.captiondad.TrakerFacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ConsulterLesFacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulter_les_fac );

        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra( "type" )){
                str = intent.getStringExtra( "type" );
            }
            int num = intent.getIntExtra( "numero" , 1 );
            int mont = intent.getIntExtra( "montant", 0 );

            TextView textView = (TextView) findViewById( R.id.textView);
            textView.setText(str +" : Type ;" );
            textView.setText( num+" : Numero d'aricle" );
            textView.setText( mont+ " :Montant" );

        }
    }
}
