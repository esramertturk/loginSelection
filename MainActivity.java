package com.example.esrapc.orneksoru;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    String metin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        result = findViewById(R.id.resultText);
        // metin = result.getText().toString();

        Intent incomingData = getIntent();
        Bundle bundle = incomingData.getExtras();
        String gender = bundle.getString("send_gender");
        String edu = bundle.getString("send_education");
        String lang = bundle.getString("send_language");
        String proglang = bundle.getString("send_proglang");
        result.setText(gender + "\n" + edu + "\n" + "\n" + lang + "\n" + proglang);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.fourteenSize) {
            result.setTextSize(14);
        } else if (id == R.id.sixteenSize) {
            result.setTextSize(16);
        } else if (id == R.id.eightteenSize) {
            result.setTextSize(18);
        } else if (id == R.id.blackcolor) {
            result.setTextColor(Color.BLACK);
        } else if (id == R.id.bluecolor) {
            result.setTextColor(Color.BLUE);
        } else if (id == R.id.redColor) {
            result.setTextColor(Color.RED);
        }

        return super.onOptionsItemSelected(item);
    }
}
