package com.example.xox_ua.homeworks_04;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private SeekBar mSeekBarR, mSeekBarG, mSeekBarB;
    private View mColorScreen2;
    private TextView mTvR2, mTvG2, mTvB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mColorScreen2 = (View) findViewById(R.id.colorScreen2);
        mSeekBarR = (SeekBar) findViewById(R.id.seekBarR);
        mSeekBarG = (SeekBar) findViewById(R.id.seekBarG);
        mSeekBarB = (SeekBar) findViewById(R.id.seekBarB);
        mTvR2 = (TextView) findViewById(R.id.tvR2);
        mTvG2 = (TextView) findViewById(R.id.tvG2);
        mTvG2 = (TextView) findViewById(R.id.tvB2);
        updateBackground();

        mSeekBarR.setOnSeekBarChangeListener(seekBarChangeListener);
        mSeekBarG.setOnSeekBarChangeListener(seekBarChangeListener);
        mSeekBarB.setOnSeekBarChangeListener(seekBarChangeListener);
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
        int valueR, valueG, valueB;
        valueR = mSeekBarR.getProgress();
        valueG = mSeekBarG.getProgress();
        valueB = mSeekBarB.getProgress();
        // меняем фон через формат RGB
        mColorScreen2.setBackgroundColor(Color.rgb(valueR, valueG, valueB));
    }
}
