package com.example.mathskills;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MultiplicationTable extends AppCompatActivity {
    private TextView text;
    private EditText answer;
    private int countOfEquation;
    private int count;
    private int countOfRightAnswers = 0;
    private Equation equation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table);
        countOfEquation = getIntent().getExtras().getInt("countOfEquation");
        count = countOfEquation;
        text = (TextView) findViewById(R.id.equation);
        answer = (EditText) findViewById(R.id.answer);

        next(answer);

    }

    public void next(View view) {
        check();
        if (countOfEquation > 0) {
            equation = getEquation();
            answer.setText("");
            countOfEquation--;
        }else {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("countOfRightAnswers", countOfRightAnswers);
            intent.putExtra("countOfEquation", count);
            startActivity(intent);
        }
    }

    public void check() {
        if (TextUtils.isEmpty(answer.getText().toString())) {
            return;
        }
        int answ = Integer.parseInt(answer.getText().toString());
        if (answ == equation.getRightAnswer()) {
            countOfRightAnswers++;
        }

    }

    private static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);

    }

    private Equation getEquation() {
        Equation equation = new Equation(getRandomInt(1, 10), getRandomInt(1, 10));
        text.setText(equation.toString());
        return equation;
    }


}
