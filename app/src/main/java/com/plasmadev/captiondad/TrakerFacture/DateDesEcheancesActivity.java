package com.plasmadev.captiondad.TrakerFacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateDesEcheancesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_date_des_echeances );

        Intent intent = getIntent();
        String type = intent.getStringExtra("Typecredit");
        String date = intent.getStringExtra( "Datecredit" );
        int numero = intent.getIntExtra( "NumeroCredit" , 0 );
        int montant = intent.getIntExtra( "MontantCredit", 0 );


        TextView textView = (TextView) findViewById( R.id.datetv);
        textView.setText("Les Factures Impayées : "+type+ "\n Montant: "+montant +"\n N°Facture: " +numero
                +"\n Date: " +date);
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String  currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);

    }

}
