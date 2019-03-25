package com.example.esrapc.orneksoru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProcessActivity extends AppCompatActivity {
    TextView isimTv;
    RadioGroup radioGroupGender, radioGroupEducation;
    RadioButton woman, man, primary, highSchool, bachelor;
    CheckBox dIng, dTurk, dIta, dIsp, pC, pCsharp, pJava, pPhp;
    Button saveBtn;
    String veri="", data="", dilVeri="",veriGender="";
    Boolean gender;
    Byte count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        isimTv = findViewById(R.id.processUser);
        radioGroupGender = findViewById(R.id.genderGroup);
        radioGroupEducation = findViewById(R.id.educationGroup);
        woman = findViewById(R.id.rdbWoman);
        man = findViewById(R.id.rdbMan);
        primary = findViewById(R.id.rdbPr);
        highSchool = findViewById(R.id.rdbHs);
        bachelor = findViewById(R.id.rdbBac);
        dIng = findViewById(R.id.ingCheck);
        dTurk = findViewById(R.id.trkCheck);
        dIta = findViewById(R.id.itaCheck);
        dIsp = findViewById(R.id.ispCheck);
        pC = findViewById(R.id.c);
        pCsharp = findViewById(R.id.csharp);
        pJava = findViewById(R.id.java);
        pPhp = findViewById(R.id.php);
        saveBtn = findViewById(R.id.saveBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String misim = bundle.getString("kullanici");
        isimTv.setText(misim);

        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (woman.isChecked()) {
                    gender = true;
                    veriGender += "kadın";
                } else if (man.isChecked()) {
                    gender = false;
                    veriGender += "erkek";
                }

            }
        });


        radioGroupEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (primary.isChecked()) {
                    veri += "İlkokul";
                } else if (highSchool.isChecked()) {
                    veri += "Lise";

                } else if (bachelor.isChecked()) {
                    veri += "lisans";
                }

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pC.isChecked()) {
                    data += "C ";
                }
                if (pCsharp.isChecked()) {
                    data += "C# ";
                }
                if (pJava.isChecked()) {
                    data += "Java ";
                }
                if (pPhp.isChecked()) {
                    data += "Php ";
                }
                if (dIng.isChecked()) {
                    dilVeri += "İngilizce ";
                }
                if (dTurk.isChecked()) {
                    dilVeri += "Türkçe ";
                }
                if (dIsp.isChecked()) {
                    dilVeri += "İspanyolca ";
                }
                if (dIta.isChecked()) {
                    dilVeri += "İtalyanca ";
                }
               // Toast.makeText(ProcessActivity.this, "..."+veriGender+veri+dilVeri+data, Toast.LENGTH_LONG).show();
            sendToData();
            }

        });
    }

    private void sendToData() {
        Intent sendData = new Intent(getApplicationContext(), MainActivity.class);
        sendData.putExtra("send_gender", veriGender);
        sendData.putExtra("send_education", veri);
        sendData.putExtra("send_language", dilVeri);
        sendData.putExtra("send_proglang", data);
        startActivity(sendData);
    }
}