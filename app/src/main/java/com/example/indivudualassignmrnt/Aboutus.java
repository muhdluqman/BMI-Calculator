package com.example.indivudualassignmrnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {
    private TextView Home;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
         t= (TextView) findViewById(R.id.j);
        t.setMovementMethod(LinkMovementMethod.getInstance());

        Home = findViewById(R.id.Home);
        setContentView(R.layout.activity_aboutus);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aboutus.this, MainActivity.class));
            }
        });
    }






}