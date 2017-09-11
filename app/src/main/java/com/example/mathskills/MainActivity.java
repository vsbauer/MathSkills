package com.example.mathskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    private EditText editCountOfEquation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCountOfEquation = (EditText) findViewById(R.id.editCountOfEquation);

    }

    public void onClick(View view) {

        if (TextUtils.isEmpty(editCountOfEquation.getText().toString())) {
            return;
        }
        int countOfEquation = countOfEquation = Integer.parseInt(editCountOfEquation.getText().toString());
        Intent intent = new Intent(this, MultiplicationTable.class);
        intent.putExtra("countOfEquation", countOfEquation);
        startActivity(intent);
    }
}
