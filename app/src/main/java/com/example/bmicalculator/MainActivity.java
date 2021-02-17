package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt_calculatedBMI;
    private EditText edt_weight,edt_feet,edt_inches;
    private Button btn_calculate,btn_clear;
    private Spinner spn_unit;
    private double weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatBMI();

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_weight.setText("");
                edt_feet.setText("");
                edt_inches.setText("");
                txt_calculatedBMI.setVisibility(View.GONE);
            }
        });
    }
    public void calculatBMI(){

       exactWeight();

        double feet=Double.parseDouble(edt_feet.getText().toString());
        double inches=Double.parseDouble(edt_inches.getText().toString());
        inches=inches/12;
        feet=feet+inches;
        double height_in_meter=feet/3.281;
        height_in_meter=height_in_meter*height_in_meter;
        double BMI=weight/height_in_meter;
        txt_calculatedBMI.setText(String.format("Your BMI is %1.2f",BMI));
        txt_calculatedBMI.setVisibility(View.VISIBLE);
    }
    public void exactWeight(){
        weight =Double.parseDouble(edt_weight.getText().toString());
        if(spn_unit.getSelectedItem().toString().equals("Pounds")){
            weight=weight/2.205;
        }
    }
    public void initView(){
        txt_calculatedBMI=findViewById(R.id.txt_calutedBMI);
        edt_weight=findViewById(R.id.edt_weight);
        edt_feet=findViewById(R.id.edt_feet);
        edt_inches=findViewById(R.id.edt_inches);
        btn_calculate=findViewById(R.id.btn_calculate);
        btn_clear=findViewById(R.id.btn_clear);
        spn_unit=findViewById(R.id.spn_unit);
    }

}