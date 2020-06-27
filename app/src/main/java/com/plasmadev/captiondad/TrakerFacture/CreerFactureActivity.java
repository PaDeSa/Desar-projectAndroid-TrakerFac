package com.plasmadev.captiondad.TrakerFacture;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class CreerFactureActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_creer_facture );

       final EditText type = (EditText) findViewById( R.id.type );
        final EditText numero = (EditText) findViewById( R.id.numero );
        final EditText montant = (EditText) findViewById( R.id.montant );
        Button payer = (Button ) findViewById( R.id.payer );
        Button impayee = (Button) findViewById( R.id.credit );

        final Button button = (Button) findViewById(R.id.date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        payer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(montant.getText().toString().equals( "" ) || numero.getText().toString().equals( "" )){
                    Toast.makeText( CreerFactureActivity.this, "Réessayer Svp!", Toast.LENGTH_SHORT ).show();
                }else{
                    String typ = type.getText().toString();
                    int num = Integer.parseInt( numero.getText().toString() );
                    int mont = Integer.parseInt( montant.getText().toString() );

                    Intent intent = new Intent( CreerFactureActivity.this, ConsulterLesFacActivity.class);
                    intent.putExtra( "Type" , typ );
                    intent.putExtra( "Numero" , num);
                    intent.putExtra( "Montant" , mont );
                    startActivityForResult( intent, 1  );
                }
            }

        } );
        impayee.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(montant.getText().toString().equals( "" ) || numero.getText().toString().equals( "" )){
                    Toast.makeText( CreerFactureActivity.this, "Réessayer Svp!", Toast.LENGTH_SHORT ).show();
                }else{
                    String typcr = type.getText().toString();
                    int numcr = Integer.parseInt( numero.getText().toString() );
                    int montcr = Integer.parseInt( montant.getText().toString() );
                    String dtcr = button.getText().toString();

                    Intent intent1 = new Intent( CreerFactureActivity.this, DateDesEcheancesActivity.class);
                    intent1.putExtra( "Typecredit" , typcr );
                    intent1.putExtra( "Numerocredit" , numcr);
                    intent1.putExtra( "Montantcredit" , montcr );
                    intent1.putExtra( "Datecredit",dtcr );

                    startActivityForResult( intent1, 1  );

                }
            }

        } );
    }


    @Override
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
