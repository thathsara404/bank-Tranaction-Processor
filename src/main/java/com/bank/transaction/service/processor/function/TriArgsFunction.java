package com.bank.transaction.service.processor.function;

/**
 * Represents a function that accepts three argument and produces a result.
 * Type parameters: <R> – the type of the return value of the function
 * */
@FunctionalInterface
public interface TriArgsFunction<O, P, Q, R> {

    /**
     * Apply the given instructions.
     * @param o
     * @param p
     * @param q
     * @return R return type
     * */
    public abstract R apply(O o, P p, Q q);
}
