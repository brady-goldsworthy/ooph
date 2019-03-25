package com.example.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

//Brady Goldsworthy

public class MainActivity extends AppCompatActivity {

    private RadioGroup shapesRG;
    private RadioButton circleRB, triangleRB, ellipseRB;
    private TextView areaTV, areaLabelTV;

    private double area;

    public int checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shapesRG = findViewById(R.id.shapeRadioGroup);

        circleRB = findViewById(R.id.circleRadioButton);
        triangleRB = findViewById(R.id.triangleRadioButton);
        ellipseRB = findViewById(R.id.ellipseRadioButton);

        areaTV = findViewById(R.id.areaTextView);
        areaLabelTV = findViewById(R.id.areaLabel);

        final DecimalFormat df = new DecimalFormat("#.0000");


        shapesRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.triangleRadioButton: checked = 1; //Triangle
                    break;
                    case R.id.circleRadioButton: checked = 2; //Circle
                    break;
                    case R.id.ellipseRadioButton: checked = 3; //Ellipse
                    break;
                }
            }
        });

        Intent intent = getIntent();
        area = intent.getDoubleExtra("area", -1);

        if (area != -1) {
            areaLabelTV.setText(intent.getStringExtra("shape"));
            areaTV.setText(df.format(area));
        }

    } //end onCreate


    public void calcScreen(View view) {
        Intent calcIntent = new Intent(MainActivity.this, CalcActivity.class);
        calcIntent.putExtra("id", checked);
        startActivity(calcIntent);
    }
}
