package com.example.esrapc.orneksoru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText userName, password;
    Button saveBtn;
    String isim, parola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        saveBtn = findViewById(R.id.loginBtn);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isim = userName.getText().toString();
                parola = password.getText().toString();
                if (isim.equalsIgnoreCase("esra") && parola.equalsIgnoreCase("123")) {
                    //Toast.makeText(getApplicationContext(), "gitdi", Toast.LENGTH_SHORT).show();
                    Intent gonder = new Intent(getApplicationContext(), ProcessActivity.class);
                    gonder.putExtra("kullanici", isim);
                    //gonder.putExtra("sifre",parola);
                    startActivity(gonder);
                }
            }
        });


    }
}