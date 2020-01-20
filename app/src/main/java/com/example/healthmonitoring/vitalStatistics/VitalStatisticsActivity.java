package com.example.healthmonitoring.vitalStatistics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthmonitoring.R;

public class VitalStatisticsActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    VitalStatisticsManager vitalStatisticsManager = new VitalStatisticsManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_statistics);

        init();
    }

    private void init() {
        final TextView inputWeight = findViewById(R.id.input_weight);
        final TextView inputNumberSteps = findViewById(R.id.input_number_steps);
        Button btnSave = findViewById(R.id.btn_save);

        final Toast toastEmpty = Toast.makeText(this, "Заполните все поля!",
                Toast.LENGTH_LONG);
        final Toast toastErrorConverNumber = Toast.makeText(this,
                "Пожалуйста, введите число!", Toast.LENGTH_LONG);
        final Toast toastVitalStatisticsAdded = Toast.makeText(this,
                "Данные о жизненных показателях сохранены!", Toast.LENGTH_LONG);
        final Toast toastError = Toast.makeText(this,
                "Что-то пошло не так!", Toast.LENGTH_LONG);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал на кнопку \"Сохранить\"");

                String weight = inputWeight.getText().toString();
                String numberSteps = inputNumberSteps.getText().toString();

                if (weight.equals("") || numberSteps.equals("")) {
                    toastEmpty.show();
                    return;
                }

                double weightDouble;
                int numberStepsInteger;

                try {
                    weightDouble = Double.parseDouble(weight);
                    numberStepsInteger = Integer.parseInt(numberSteps);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Получено исключение", e);
                    toastErrorConverNumber.show();
                    return;
                }

                if (vitalStatisticsManager.addVitalStatistics(weightDouble, numberStepsInteger)) {
                    toastVitalStatisticsAdded.show();
                } else {
                    toastError.show();
                }
            }
        });
    }
}
