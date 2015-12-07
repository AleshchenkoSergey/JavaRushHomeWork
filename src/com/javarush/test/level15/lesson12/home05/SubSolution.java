package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Admin on 31.01.2015.
 */
public class SubSolution extends Solution {
    SubSolution() {
    }

    SubSolution(int i) {
        super(i);
    }

    SubSolution(int i, int j) {
        super(i, j);
    }

    public SubSolution(int i, double j) {
        super(i, j);
    }

    public SubSolution(double j, int i) {
        super(j, i);
    }

    public SubSolution(int i, short j) {
        super(i, j);
    }

    private SubSolution(char ch) {}
    private SubSolution(char ch, int i) {}
    private SubSolution(int i, char ch) {}

    protected SubSolution(long l) {
        super(l);
    }

    protected SubSolution(long l, int i) {
        super(l, i);
    }

    protected SubSolution(int i, long l) {
        super(i, l);
    }
}
