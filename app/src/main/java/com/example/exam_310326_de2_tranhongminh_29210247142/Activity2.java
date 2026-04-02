package com.example.exam_310326_de2_tranhongminh_29210247142;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    RadioGroup rgSeat;
    EditText edtPeople;
    Button btnService, btnNext, btnBack;
    TextView txtMoney;

    int serviceMoney = 0;

    private ActivityResultLauncher<Intent> serviceLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // layout uses rgClass id; keep variable name rgSeat for compatibility with original code
        rgSeat = findViewById(R.id.rgClass);
        edtPeople = findViewById(R.id.edtPeople);
        btnService = findViewById(R.id.btnService);
        btnNext = findViewById(R.id.btnNext);
        txtMoney = findViewById(R.id.txtMoney);
        btnBack = findViewById(R.id.btnBack);

        btnNext.setEnabled(false);

        // register ActivityResultLauncher to receive the result from Activity3
        serviceLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        serviceMoney = data.getIntExtra("money", 0);
                        txtMoney.setText(getString(R.string.service_label, serviceMoney));
                        btnNext.setEnabled(true);
                    }
                }
        );

        btnService.setOnClickListener(v -> {
            Intent i = new Intent(Activity2.this, Activity3.class);
            serviceLauncher.launch(i);
        });

        btnNext.setOnClickListener(v -> {
            String peopleText = edtPeople.getText().toString().trim();
            if (peopleText.isEmpty()) {
                Toast.makeText(Activity2.this, "Nhập số người", Toast.LENGTH_SHORT).show();
                return;
            }
            int people;
            try {
                people = Integer.parseInt(peopleText);
            } catch (NumberFormatException e) {
                Toast.makeText(Activity2.this, "Số không hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }

            if (people < 1 || people > 9) {
                Toast.makeText(Activity2.this, "1-9 người", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent i = new Intent(Activity2.this, Activity4.class);
            i.putExtra("money", serviceMoney);
            startActivity(i);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
