package com.example.werkstoff_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
    public static  EditText durchmesserInput;
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



    public void getValue(){

        if(TextUtils.isEmpty(durchmesserInput.getText().toString())){
            ergebnis.setText("Durchmesser eingeben!");
        }else {

            if (menu.getSelectedItem().toString().equals("VHM")) {

                if (hart.isChecked()) {

                    double a;
                    a = (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);

                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (55 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (110 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (90 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }


            } else if (menu.getSelectedItem().toString().equals("PMX")) {

                if (hart.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hart.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (30 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (65 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }


            } else if (menu.getSelectedItem().toString().equals("HSSE-Co8")) {

                if (hart.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (18 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hart.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (18 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schlicht.isChecked()) {

                    double a;
                    a = (25 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schrup.isChecked()) {

                    double a;
                    a = (25 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hitze.isChecked() && schlicht.isChecked()) {

                    ergebnis.setText("keine Angabe");
                }

                if (hitze.isChecked() && schrup.isChecked()) {

                    ergebnis.setText("keien Angabe");
                }


            }

        }


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

/*
        switch (position) {


            case 0:
                        if (hart.isChecked()){

                            double a;
                            a =  (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);

                            ergebnis.setText(String.valueOf(a));

                        }

                        if (rostfrei.isChecked() && schrup.isChecked()){

                            double a;
                            a =  (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));

                        }

                        if (rostfrei.isChecked() && schlicht.isChecked()){

                            double a;
                            a =  (55 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));
                            Log.d("test", String.valueOf(a));

                        }

                        if (guss.isChecked() && schlicht.isChecked()){

                            double a;
                            a =  (110 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));

                        }

                        if (guss.isChecked() && schrup.isChecked()){

                            double a;
                            a =  (90 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));

                         }

                        if (hitze.isChecked() && schlicht.isChecked()){

                            double a;
                            a =  (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));
                        }

                        if (hitze.isChecked() && schlicht.isChecked()){

                            double a;
                            a =  (50 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                            ergebnis.setText(String.valueOf(a));
                         }


            case 1:


                if (hart.isChecked() && schrup.isChecked()){

                    double a;
                    a =  (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hart.isChecked() && schlicht.isChecked()){

                    double a;
                    a =  (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schrup.isChecked()){

                    double a;
                    a =  (30 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (rostfrei.isChecked() && schlicht.isChecked()){

                    double a;
                    a =  (45 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schlicht.isChecked()){

                    double a;
                    a =  (65 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (guss.isChecked() && schrup.isChecked()){

                    double a;
                    a =  (35 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));

                }

                if (hitze.isChecked() && schlicht.isChecked()){

                    double a;
                    a =  (20 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }

                if (hitze.isChecked() && schlicht.isChecked()){

                    double a;
                    a =  (15 * 1000) / (Integer.parseInt(durchmesserInput.getText().toString()) * Math.PI);
                    ergebnis.setText(String.valueOf(a));
                }


        }
*/


    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
