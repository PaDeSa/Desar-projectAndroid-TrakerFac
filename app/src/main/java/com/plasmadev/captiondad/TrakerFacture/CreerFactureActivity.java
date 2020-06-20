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

        Button payer = (Button ) findViewById( R.id.btn );
        Button impayee = (Button) findViewById( R.id.credit );

        Button button = (Button) findViewById(R.id.date);
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
                Toast.makeText( CreerFactureActivity.this, "Facture payer", Toast.LENGTH_SHORT ).show();
            }

        } );
        impayee.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( CreerFactureActivity.this, "Facture impayée", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
    public void PayerFacture (View view){

        EditText editText = (EditText)findViewById( R.id.type );
        String str = editText.getText().toString();

        EditText editText1 = (EditText)findViewById( R.id.numero );
        int id = Integer.parseInt( editText1.getText().toString() );

        EditText editText2 = (EditText)findViewById( R.id.total );
        int id1 = Integer.parseInt( editText2.getText().toString() );

        Intent intent = new Intent( this, ConsulterLesFacActivity.class );
        startActivity( intent );


        intent.putExtra( "type", str );
        intent.putExtra( "numero", id );
        intent.putExtra( "Montant" , id1 );

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
