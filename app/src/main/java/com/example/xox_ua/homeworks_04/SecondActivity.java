package com.example.xox_ua.homeworks_04;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private SeekBar mSeekBarR, mSeekBarG, mSeekBarB;
    private View mColorScreen2;
    private TextView mTvR2, mTvG2, mTvB2;
    int valueR, valueG, valueB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // фиксируем экран (запрет поворота)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // TOOLBAR добавление кнопки back и её функционала
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mColorScreen2 = (View) findViewById(R.id.colorScreen2);
        mSeekBarR = (SeekBar) findViewById(R.id.seekBarR);
        mSeekBarG = (SeekBar) findViewById(R.id.seekBarG);
        mSeekBarB = (SeekBar) findViewById(R.id.seekBarB);
        mTvR2 = (TextView) findViewById(R.id.tvR2);
        mTvG2 = (TextView) findViewById(R.id.tvG2);
        mTvB2 = (TextView) findViewById(R.id.tvB2);
        updateBackground();

        mSeekBarR.setOnSeekBarChangeListener(seekBarChangeListener);
        mSeekBarG.setOnSeekBarChangeListener(seekBarChangeListener);
        mSeekBarB.setOnSeekBarChangeListener(seekBarChangeListener);

        Button btnToActivity1 = (Button) findViewById(R.id.btnToActivity1);
        btnToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                // отдаём через bundle
                Bundle bundle = new Bundle();
                bundle.putInt("SetColorRed", valueR);
                // отдаём через intent
                intent.putExtra("RGBColors", bundle);
                intent.putExtra("SetColorGreen", valueG);
                intent.putExtra("SetColorBlue", valueB);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateBackground();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateBackground() {
        valueR = mSeekBarR.getProgress();
        valueG = mSeekBarG.getProgress();
        valueB = mSeekBarB.getProgress();
        // меняем фон через формат RGB
        mColorScreen2.setBackgroundColor(Color.rgb(valueR, valueG, valueB));
        // меняем цифровое значение цвета в TextView
        mTvR2.setText(String.valueOf(valueR));
        mTvG2.setText(String.valueOf(valueG));
        mTvB2.setText(String.valueOf(valueB));
    }

    // обработка нажатия на кнопку back toolbar'a
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
