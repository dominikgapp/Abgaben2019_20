package com.example.werkstoff_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    public static TextView ergebnis;
    public static CheckBox hart, rostfrei, guss, hitze, schrup, schlicht;
    public static EditText durchmesserInput;
    public static Button clear;

    Spinner menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         menu = findViewById(R.id.menu);

         hart = findViewById(R.id.gehartet);
         rostfrei = findViewById(R.id.rostfrei);
         guss = findViewById(R.id.guss);
         hitze = findViewById(R.id.hitze);

         schlicht = findViewById(R.id.schicht);
         schrup = findViewById(R.id.schrup);

         ergebnis = findViewById(R.id.ergebnis);

         clear = findViewById(R.id.clear);


        durchmesserInput = findViewById(R.id.durchmesser);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.werkstoffe, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        menu.setAdapter(adapter);
        menu.setOnItemSelectedListener(this);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ergebnis.setText("");
                durchmesserInput.setText("");
                rostfrei.setChecked(false);
                guss.setChecked(false);
                hitze.setChecked(false);
                hart.setChecked(false);
                schrup.setChecked(false);
                schlicht.setChecked(false);

            }
        });




            menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                clear.performClick();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        hart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    rostfrei.setChecked(false);
                    guss.setChecked(false);
                    hitze.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });

        rostfrei.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    hart.setChecked(false);
                    guss.setChecked(false);
                    hitze.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });

        guss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    rostfrei.setChecked(false);
                    hart.setChecked(false);
                    hitze.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });


        hitze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    rostfrei.setChecked(false);
                    guss.setChecked(false);
                    hart.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });


        schlicht.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    schrup.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });


        schrup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    schlicht.setChecked(false);
                    getValue();
                }
                if (isChecked == false) getValue();
            }
        });


    }


    public void calc (int value){

        double a;
        a = (value * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
        ergebnis.setText(String.valueOf(a));
    }


    public void getValue(){

        if(TextUtils.isEmpty(durchmesserInput.getText().toString())){
            ergebnis.setText("Durchmesser eingeben!");
        }else {

            if (menu.getSelectedItem().toString().equals("VHM")) {

                if (hart.isChecked()) {

                    calc(50);

                    /*double a;
                    a = (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);

                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    calc(45);
                    /*double a;
                    a = (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    calc(55);
                    /*double a;
                    a = (55 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    calc(110);
                    /* double a;
                    a = (110 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    calc(90);
                    /* double a;
                    a = (90 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    calc(35);
                    /*  double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/
                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    calc(50);
                   /*  double a;
                    a = (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/
                }


            } else if (menu.getSelectedItem().toString().equals("PMX")) {

                if (hart.isChecked() && schrup.isChecked()) {

                    calc(20);
                   /* double a;
                    a = (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (hart.isChecked() && schlicht.isChecked()) {

                    calc(35);
                    /* double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    calc(30);
                    /* double a;
                    a = (30 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    calc(45);
                    /* double a;
                    a = (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    calc(65);
                   /*  double a;
                    a = (65 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    calc(35);
                    /* double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    calc(15);
                    /* double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/
                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    calc(20);
                    /* double a;
                    a = (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/
                }


            } else if (menu.getSelectedItem().toString().equals("HSSE-Co8")) {

                if (hart.isChecked() && schrup.isChecked()) {

                    calc(18);
                   /*  double a;
                    a = (18 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (hart.isChecked() && schlicht.isChecked()) {

                    calc(18);
                    /* double a;
                    a = (18 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    calc(15);
                   /*  double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    calc(15);
                    /* double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    calc(25);
                    /* double a;
                    a = (25 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    calc(25);
                    /* double a;
                    a = (25 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));*/

                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    ergebnis.setText("keine Angabe");
                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    ergebnis.setText("keine Angabe");
                }


            }

        }


    } 


    float x1, x2, y1, y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1>x2){
                    Intent i = new Intent(MainActivity.this, view.class);
                    startActivity(i);
                }else if (x1<x2){
                    Intent i = new Intent(MainActivity.this, view.class);
                    startActivity(i);
                 }
                break;
        }

        return false;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
