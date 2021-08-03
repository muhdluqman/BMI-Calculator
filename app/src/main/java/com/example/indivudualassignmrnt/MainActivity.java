package com.example.indivudualassignmrnt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

        private EditText height;
        private EditText weight;
        private TextView result;
        private TextView result2;
    private TextView result3;
    private TextView aboutus;
    private TextView button;
    private SharedPreferences mpreferences;
    private SharedPreferences.Editor meditor;





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            height = (EditText) findViewById(R.id.height);
            weight = (EditText) findViewById(R.id.weight);
            result = (TextView) findViewById(R.id.result);
            result2 = (TextView) findViewById(R.id.result2);
            result3 = (TextView) findViewById(R.id.result3);
            aboutus = (TextView)findViewById(R.id.textView3);

            button=(Button)findViewById(R.id.calc);
            this.setTitle("BMI CALCULATOR");
            mpreferences = PreferenceManager.getDefaultSharedPreferences(this);
            //mpreferences = getSharedPreferences("mydatabase", Context.MODE_PRIVATE);
            meditor = mpreferences.edit();
            checkSharedPreferences();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //save weight
                    String aweight = weight.getText().toString();
                    meditor.putString(getString(R.string.iweight), aweight);
                    meditor.commit();
                    //save height
                    String aheight = height.getText().toString();
                    meditor.putString(getString(R.string.eheight), aheight);
                    meditor.commit();

                      if(height.length()==0)
                    {
                        height.setError("Enter Height");
                    }
                      else if(weight.length()==0)
                    {
                        weight.setError("Enter Weight");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"successfully",Toast.LENGTH_LONG);
                    }

                    String heightStr = height.getText().toString();
                    String weightStr = weight.getText().toString();

                    if (heightStr != null && !"".equals(heightStr)
                            && weightStr != null  &&  !"".equals(weightStr)) {
                        float heightValue = Float.parseFloat(heightStr) / 100;
                        float weightValue = Float.parseFloat(weightStr);

                        float bmi = weightValue / (heightValue * heightValue);


                        String bmiLabel = "";
                        String bmirisk = "";

                        if(!weight.getText().toString().equals("0") && !height.getText().toString().equals("0"))
                        {
                            if (bmi<=18.4)
                            {
                                bmiLabel = "underweight";
                                bmirisk="Malnutrition risk";
                            }
                            else if (bmi<=24.9)
                            {
                                bmiLabel = "normal weight";
                                bmirisk="Low risk";
                            }
                            else if (bmi<=29.9)
                            {
                                bmiLabel = "Overweight";
                                bmirisk="Enhance risk";
                            }
                            else if (bmi<=34.9)
                            {
                                bmiLabel = "moderately obese";
                                bmirisk="Medium risk";
                            }
                            else if (bmi<=39.9)
                            {
                                bmiLabel = "severely_obese";
                                bmirisk="High risk";
                            }
                            else
                            {
                                bmiLabel = "very_severely_obese";
                                bmirisk="Very high risk";
                            }

                            Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();

                            result.setText(Float.toString(bmi));
                            result2.setText(bmiLabel);
                            result3.setText(bmirisk);
                        }}}
                });



            aboutus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this , Aboutus.class));
                }
            });


        }


    private void checkSharedPreferences(){
        String bweight = mpreferences.getString(getString(R.string.iweight), "");
        String cheight = mpreferences.getString(getString(R.string.eheight), "");


        weight.setText(bweight);
        height.setText(cheight);
    }

}









