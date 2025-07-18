package org.example;

public class Calculator {
    private boolean status = false;


    public void turnOn() {
        status = true;
    }

    public boolean isOn() {
        return status;
    }

    public void turnOff() {
        status = false;
    }

    public boolean isOff() {
        return !status;
    }

    public int add(int a, int b) {
        return a+b;
    }

    public long add(long a, long b) {
        return a+b;
    }

    public short add(short a, short b) {
        return (short) (a+b);
    }

    public float add(float a, float b) {
        return a+b;
    }

    public double add(double a, double b) {
        return a+b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public long subtract(long a, long b) {
        return a-b;
    }

    public short subtract(short a, short b) {
        return (short) (a-b);
    }

    public float subtract(float a, float b) {
        return a-b;
    }

    public double subtract(double a, double b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public long multiply(long a, long b) {
        return a*b;
    }

    public short multiply(short a, short b) {
        return (short) (a*b);
    }

    public float multiply(float a, float b) {
        return a*b;
    }

    public double multiply(double a, double b) {
        return a*b;
    }

    public int divide(int a, int b) {
        return a/b;
    }

    public long divide(long a, long b) {
        return a/b;
    }

    public short divide(short a, short b) {
        return (short) (a/b);
    }

    public float divide(float a, float b) {
        return a/b;
    }

    public double divide(double a, double b) {
        return a/b;
    }
}
