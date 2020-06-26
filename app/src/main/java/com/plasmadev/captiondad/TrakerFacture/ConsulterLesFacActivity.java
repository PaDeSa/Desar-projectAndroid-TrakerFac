package com.plasmadev.captiondad.TrakerFacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class ConsulterLesFacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_consulter_les_fac );

        Intent intent = getIntent();
            String type = intent.getStringExtra("Type");
            int numero = intent.getIntExtra( "Numero" , 0 );
            int montant = intent.getIntExtra( "Montant", 0 );


            TextView textView = (TextView) findViewById( R.id.textView);
            textView.setText(type+ "\nMontant: "+montant +" FR\nN°article: " +numero );

              Intent intent1 = getIntent();
        String typecr = intent1.getStringExtra("Typecredit");
        int numerocr = intent1.getIntExtra( "Numerocredit" , 0 );
        int montantcr = intent1.getIntExtra( "Montantcredit", 0 );

        TextView textView1 = (TextView) findViewById( R.id.textViewimpayer);
        textView1.setText(typecr+ "\nMontant: "+montantcr +" FR\nN°article: " +numerocr);




    }
}
