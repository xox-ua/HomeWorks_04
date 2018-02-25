package com.example.xox_ua.homeworks_04;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public View colorScreen1;
    // всё пишем по отдельности, вдруг захотим изменить только один
    private TextView tvRed;
    private TextView tvGreen;
    private TextView tvBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        colorScreen1 = (View) findViewById(R.id.colorScreen1);
        colorScreen1.setBackgroundColor(Color.rgb(0, 0, 0));
        tvRed = (TextView) findViewById(R.id.tvR1);
        tvGreen = (TextView) findViewById(R.id.tvG1);
        tvBlue = (TextView) findViewById(R.id.tvB1);

        Button btnStartActivity2 = findViewById(R.id.btnToActivity2);
        btnStartActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, 1975);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // метод findViewById() здесь не писать - он тяжелый и будет нагружать при каждои выполнении onActivityResult
        switch (requestCode) {
            case 1975:
            if (resultCode == RESULT_OK) {
                // получаем из bundle
                int colorRed = data.getExtras().getBundle("RGBColors").getInt("SetColorRed", 0);
                // получаем из intent
                int colorGreen = data.getIntExtra("SetColorGreen", 0);
                int colorBlue = data.getIntExtra("SetColorBlue", 0);
                // меняем фон через формат RGB
                colorScreen1.setBackgroundColor(Color.rgb(colorRed, colorGreen, colorBlue));
                // изменяем данные в TextView
                tvRed.setText(String.valueOf(colorRed));
                tvGreen.setText(String.valueOf(colorGreen));
                tvBlue.setText(String.valueOf(colorBlue));
                Toast.makeText(getApplicationContext(), R.string.toast1, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), R.string.toast2, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
