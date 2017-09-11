package com.example.mathskills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private TextView mark;
    private TextView res;
    private int countOfRightAnswers;
    private int countOfEquation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        res = (TextView) findViewById(R.id.result);
        mark = (TextView) findViewById(R.id.mark);

        Bundle bundle = getIntent().getExtras();
        countOfEquation = bundle.getInt("countOfEquation");
        countOfRightAnswers = bundle.getInt("countOfRightAnswers");
        estimate();
    }

    private void estimate() {
        res.setText(countOfRightAnswers + "/" + countOfEquation);

        double percent = (double) countOfRightAnswers / (double) countOfEquation * 100;

        if (percent > 85)
            mark.setText("5");
        if (percent > 70 && percent < 85)
            mark.setText("4");
        if (percent > 55 && percent < 70)
            mark.setText("3");
        if (percent < 55)
            mark.setText("2");
    }

    public void exit(View view) {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


    public void reset(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
