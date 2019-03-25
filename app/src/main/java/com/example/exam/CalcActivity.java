package com.example.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

//Brady Goldsworthy

public class CalcActivity extends AppCompatActivity {

    TextView num1TV, num2TV;
    EditText num1ET, num2ET;
    Button calcBTN;


    private double num1, num2, area;

    private int shape;

    private String shape_str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        num1TV = findViewById(R.id.num1Text);
        num2TV = findViewById(R.id.num2Text);

        num1ET = findViewById(R.id.num1Edit);
        num2ET = findViewById(R.id.num2Edit);

        calcBTN = findViewById(R.id.calcButton);




        Intent intent = getIntent();
        shape = intent.getIntExtra("id", -1);

        if (shape == 1) { //Triangle
            shape_str = "Area of Triangle: ";
            setTitle("Triangle");
            num1TV.setText("Base:");
            num2TV.setText("Height:");
        }
        else if (shape == 2) { //Circle
            shape_str = "Area of Circle: ";
            setTitle("Circle");
            num1TV.setText("Radius:");
            num2TV.setVisibility(View.INVISIBLE);
            num2ET.setVisibility(View.INVISIBLE);
        }
        else if (shape == 3) { //Ellipse
            shape_str = "Area of Ellipse: ";
            setTitle("Ellipse");
            num1TV.setText("semi-major:");
            num2TV.setText("semi-minor:");
        }

    }


    public void calcArea(View view) {

        if (shape == 1) { //Triangle
            num1 = Double.parseDouble(num1ET.getText().toString());
            num2 = Double.parseDouble(num2ET.getText().toString());

            area = .5 * num1 * num2;
        }
        else if (shape == 2) { //Circle
            num1 = Double.parseDouble(num1ET.getText().toString());
            num2 = 0;

            area = 3.14159 * Math.pow(num1, 2);
        }
        else if (shape == 3) { //Ellipse
            num1 = Double.parseDouble(num1ET.getText().toString());
            num2 = Double.parseDouble(num2ET.getText().toString());

            area = 3.14159 * num1 * num2;
        }

        Intent calcIntent = new Intent(CalcActivity.this, MainActivity.class);
        calcIntent.putExtra("area", area);
        calcIntent.putExtra("shape", shape_str);
        startActivity(calcIntent);
    }

}
