package com.example.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthmonitoring.pressure.PressureActivity;
import com.example.healthmonitoring.vitalStatistics.VitalStatisticsActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        final TextView inputSurname = findViewById(R.id.input_surname);
        final TextView inputName = findViewById(R.id.input_name);
        final TextView inputPatronymic = findViewById(R.id.input_patronymic);
        final TextView inputAge = findViewById(R.id.input_age);
        Button btnSave = findViewById(R.id.btn_save);
        ImageButton btnPressureScreen = findViewById(R.id.btn_pressure_screen);
        ImageButton btnVitalStatisticsScreen = findViewById(R.id.btn_vital_statistics_screen);

        final Toast toastEmpty = Toast.makeText(this, "Заполните все поля!",
                Toast.LENGTH_LONG);
        final Toast toastErrorConvertNumber = Toast.makeText(this,
                "Пожалуйста, укажите возраст правильно!", Toast.LENGTH_LONG);
        final Toast toastUserCreated = Toast.makeText(this,
                "Пользователь успешно добавлен!", Toast.LENGTH_LONG);
        final Toast toastUserExists = Toast.makeText(this,
                "Пользователь уже добавлен!", Toast.LENGTH_SHORT);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал на кнопку \"Сохранить\"");

                if (user != null) {
                    toastUserExists.show();
                    return;
                }

                String surname = inputSurname.getText().toString();
                String name = inputName.getText().toString();
                String patronymic = inputPatronymic.getText().toString();
                String age = inputAge.getText().toString();
                int ageNumber;

                if (surname.equals("") || name.equals("") || patronymic.equals("") ||
                        age.equals("")) {
                    toastEmpty.show();
                    return;
                }

                try {
                    ageNumber = Integer.parseInt(age);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Получено исключение", e);
                    toastErrorConvertNumber.show();
                    return;
                }

                user = new User(surname, name, patronymic, ageNumber);

                toastUserCreated.show();
            }
        });

        btnPressureScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал на кнопку \"Переход на экран Давление\"");
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        btnVitalStatisticsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал на кнопку \"Переход на экран Жизненные " +
                        "показатели\"");
                Intent intent = new Intent(MainActivity.this,
                        VitalStatisticsActivity.class);
                startActivity(intent);
            }
        });
    }
}
