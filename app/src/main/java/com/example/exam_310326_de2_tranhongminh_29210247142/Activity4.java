package com.example.exam_310326_de2_tranhongminh_29210247142;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    EditText edtVoucher;
    Button btnPay;
    TextView txtResult;
    Button btnBack;
    Button btnBackTo1;

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        edtVoucher = findViewById(R.id.edtVoucher);
        btnPay = findViewById(R.id.btnPay);
        txtResult = findViewById(R.id.txtResult);

        total = getIntent().getIntExtra("money", 0);

        btnPay.setOnClickListener(v -> {
            String code = edtVoucher.getText().toString();
            int finalMoney = total;

            if ("FREESHIP".equals(code)) {
                finalMoney -= 5;
            } else if ("PHD2026".equals(code)) {
                finalMoney -= 20;
            } else if (!code.isEmpty()) {
                Toast.makeText(Activity4.this, getString(R.string.toast_invalid_code), Toast.LENGTH_SHORT).show();
                return;
            }

            txtResult.setText(getString(R.string.total_label, finalMoney));
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        btnBackTo1 = findViewById(R.id.btnBackTo1);
        btnBackTo1.setOnClickListener(v -> {
            Intent i = new Intent(Activity4.this, Activity1.class);
            startActivity(i);
        });
    }
}
