package com.example.healthmonitoring.pressure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthmonitoring.R;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    PressureManager pressureManager = new PressureManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();
    }

    private void init() {
        final TextView inputTopPressure = findViewById(R.id.input_top_pressure);
        final TextView inputLowerPressure = findViewById(R.id.input_lower_pressure);
        final TextView inputPulse = findViewById(R.id.input_pulse);
        final CheckBox inputTachycardia = findViewById(R.id.input_tachycardia);
        Button btnSave = findViewById(R.id.btn_save);

        final Toast toastEmpty = Toast.makeText(this, "Заполните все поля!",
                Toast.LENGTH_LONG);
        final Toast toastErrorConverNumber = Toast.makeText(this,
                "Пожалуйста, укажите целое число!", Toast.LENGTH_LONG);
        final Toast toastPressureAdded = Toast.makeText(this,
                "Данные о давлении успешно сохранены!", Toast.LENGTH_LONG);
        final Toast toastError = Toast.makeText(this,
                "Что-то пошло не так!", Toast.LENGTH_LONG);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал на кнопку \"Сохранить\"");

                String topPressure = inputTopPressure.getText().toString();
                String lowerPressure = inputLowerPressure.getText().toString();
                String pulse = inputPulse.getText().toString();


                boolean tachycardia = inputTachycardia.isChecked();

                if (topPressure.equals("") || lowerPressure.equals("") || pulse.equals("")) {
                    toastEmpty.show();
                    return;
                }

                int topPressureNumber;
                int lowerPressureNumber;
                int pulseNumber;

                try {
                    topPressureNumber = Integer.parseInt(topPressure);
                    lowerPressureNumber = Integer.parseInt(lowerPressure);
                    pulseNumber = Integer.parseInt(pulse);

                } catch (NumberFormatException e) {
                    Log.e(TAG, "Получено исключение", e);
                    toastErrorConverNumber.show();
                    return;
                }

                boolean isAdded = pressureManager.addPressure(topPressureNumber,
                        lowerPressureNumber, pulseNumber, tachycardia);

                if (isAdded) {
                    toastPressureAdded.show();
                } else {
                    toastError.show();
                }

            }
        });

    }
}
