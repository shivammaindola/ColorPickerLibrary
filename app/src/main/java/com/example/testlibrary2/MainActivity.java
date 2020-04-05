package com.example.testlibrary2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.librarytest.ColorPicker;
import com.example.librarytest.OnColorSelectChangeListener;

public class MainActivity extends AppCompatActivity implements OnColorSelectChangeListener {


    private static final String TAG = MainActivity.class.getSimpleName();

    private AppCompatTextView showColorCode;

    private ColorPicker colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        colorPicker = new ColorPicker(MainActivity.this);
        colorPicker.setOnColorSelectChangeListener(this);

        showColorCode = (AppCompatTextView)findViewById(R.id.selected_color);

        Button showColorPickerBtn = (AppCompatButton)findViewById(R.id.open_color_picker);
        showColorPickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPicker.show();
            }
        });
    }

    @Override
    public void onColorChange(int color) {
        Log.d(TAG, "Selected color " + color);
        showColorCode.setTextColor(color);
    }
}
