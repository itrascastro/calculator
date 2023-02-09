package com.trascastro.calculator.service;

public class CalculatorService {
    private int op1;
    private int op2;
    private int res;

    public CalculatorService(int op1, int op2) {
        this.setOp1(op1);
        this.setOp2(op2);
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void add() {
        this.setRes(this.getOp1() + this.getOp2());
    }
}
