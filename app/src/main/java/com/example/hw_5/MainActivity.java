package com.example.hw_5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")){
            textView.setText("0");
            first = 0;
            second = 0;
        }else if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(text);
        }else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_plus){
            first = Integer.valueOf(textView.getText().toString());
        }else if (view.getId() == R.id.btn_equal){
            second = Integer.valueOf(textView.getText().toString());
            Integer result = first + second;
            textView.setText(result.toString());
        }
        if(view.getId() == R.id.btn_subtraction){
            first = Integer.valueOf(textView.getText().toString());
        }else if (view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            Integer result = first - second;
            textView.setText(result.toString());
        }
        if(view.getId() == R.id.btn_division){
            first = Integer.valueOf(textView.getText().toString());
        } else if (view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            Integer result = first / second;
            textView.setText(result.toString());
        }
        if(view.getId() == R.id.btn_multiplication){
            first = Integer.valueOf(textView.getText().toString());
        }else if (view.getId() == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            Integer result = first * second;
            textView.setText(result.toString());
        }
        isOperationClick = true;
    }
}