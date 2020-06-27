package com.plasmadev.captiondad.TrakerFacture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText txtLogin, txtPassword;
    private Button btnConnect;
    private String login, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = (EditText) findViewById(R.id.username);//Now txtLogin dans le code represente de l'int graphique
        txtPassword = (EditText) findViewById(R.id.password);

        btnConnect = (Button) findViewById(R.id.btn_login);

        btnConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();

                if (login.isEmpty() || password.isEmpty())
                    Toast.makeText( LoginActivity.this,"Vous devez remplir les champs ", Toast.LENGTH_SHORT ).show();
                else {
                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}