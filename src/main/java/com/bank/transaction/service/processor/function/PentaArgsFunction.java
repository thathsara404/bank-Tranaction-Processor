package com.bank.transaction.service.processor.function;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Represents a function that accepts five argument and produces a result.
 * Type parameters: <R> – the type of the return value of the function
 * */
public interface PentaArgsFunction<M, N, O, P, Q, R> {

    /**
     * Apply the given instructions.
     * @param m
     * @param n
     * @param o
     * @param p
     * @param q
     * @return R return type
     * */
    public abstract R apply(M m, N n, O o, P p, Q q) throws IOException, TimeoutException;

}
