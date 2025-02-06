package com.Ivan;

import java.util.concurrent.RecursiveTask;

public class FactorialTask  extends RecursiveTask<Long> {
    int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if(n<0) {
            throw new ArithmeticException("The factorial of a negative number is indeterminate");
        }
        if (n==1 || n==0) return (long)1;
        FactorialTask factorialTaskRecurs = new FactorialTask(n-1);
        factorialTaskRecurs.fork();
        return factorialTaskRecurs.join()*n;
    }
}
