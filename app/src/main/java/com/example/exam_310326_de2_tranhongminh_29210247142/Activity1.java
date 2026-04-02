package com.example.exam_310326_de2_tranhongminh_29210247142;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        final EditText edtFrom = findViewById(R.id.edtFrom);
        final EditText edtTo = findViewById(R.id.edtTo);
        final EditText edtPhone = findViewById(R.id.edtPhone);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnBack = findViewById(R.id.btnBack);

        btnNext.setOnClickListener(v -> {
            String from  = edtFrom.getText().toString();
            String to = edtTo.getText().toString();
            String phone = edtPhone.getText().toString();

            if (from.equals(to)) {
                Toast.makeText(Activity1.this, "Diem khong duoc trung", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!phone.matches("^0\\d{9}$")) {
                Toast.makeText(Activity1.this, "So dien thoai khong hop le", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent i = new Intent(Activity1.this, Activity2.class);
            startActivity(i);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
