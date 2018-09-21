package com.example.arazth.tempconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arazth.tempconverterapp.Temperature.Unit;

public class MainActivity extends AppCompatActivity {

    TextView tv_c;
    TextView tv_r;
    TextView tv_f;
    TextView tv_k;
    EditText et_number;
    Button btn;

    String spinner_item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_c = findViewById(R.id.tv_c);
        tv_r = findViewById(R.id.tv_r);
        tv_f = findViewById(R.id.tv_f);
        tv_k = findViewById(R.id.tv_k);
        et_number = findViewById(R.id.et_number);
        btn = findViewById(R.id.btn);


        final Spinner spinner = findViewById(R.id.spinner);
        final ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.temp_symbol, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner_item = "Celcius";
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temp = Double.parseDouble(et_number.getText().toString());
                convert(temp, spinner_item);
            }
        });
    }


    private void convert(double n, String spinner_item) {
        Unit.convert(spinner_item, n);
        String degree = getResources().getString(R.string.degree_sybol);


        tv_c.setText(getString(R.string.result, Unit.celcius, 'C'));
        tv_r.setText(getString(R.string.result, Unit.reamur, 'R'));
        tv_f.setText(getString(R.string.result, Unit.fahrenheit, 'F'));
        tv_k.setText(getString(R.string.result, Unit.kelvin, 'K'));
    }


}
