package com.example.mathskills;

/**
 * Created by Влад on 10.09.2017.
 */

public class Equation {
    private int first;
    private int second;
    private int rightAnswer;

    public Equation(int first, int second) {
        this.first = first;
        this.second = second;
        rightAnswer = first * second;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        return first + " * " + second + " = ";
    }
}
