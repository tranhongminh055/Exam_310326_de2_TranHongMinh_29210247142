package com.example.exam_310326_de2_tranhongminh_29210247142;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        // local view variables
        CheckBox chkMeal = findViewById(R.id.chkMeal);
        CheckBox chkLuggage = findViewById(R.id.chkLuggage);
        CheckBox chkInsurance = findViewById(R.id.chkInsurance);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        Button btnBack = findViewById(R.id.btnBack);

        btnConfirm.setOnClickListener(v -> {
            int total = 0;
            if (chkMeal.isChecked()) total += 10;
            if (chkLuggage.isChecked()) total += 20;
            if (chkInsurance.isChecked()) total += 5;

            Intent result = new Intent();
            result.putExtra("money", total);
            setResult(RESULT_OK, result);
            finish();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
