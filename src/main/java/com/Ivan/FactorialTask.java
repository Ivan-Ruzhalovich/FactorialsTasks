package com.Ivan;

import java.util.concurrent.RecursiveTask;

public class FactorialTask  extends RecursiveTask<Long> {
    int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        boolean negative = false;
        if(n<0) {
            negative = true;
            n *= -1;
        }
        if (n==1 || n==0) return negative ? (long)-1 : (long)1;
        FactorialTask factorialTaskRecurs = new FactorialTask(n-1);
        factorialTaskRecurs.fork();
        long result = factorialTaskRecurs.join()*n;
        return !negative ? result : result * (-1);
    }
}
