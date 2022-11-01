package com.bank.transaction.service.processor.function;

/**
 * Represents a function that accepts zero argument and produces a result.
 * Type parameters: <R> – the type of the return value of the function
 * */
@FunctionalInterface
public interface ZeroArgsFunction<R> {

    /**
     * Apply the given instructions.
     * @return R return type
     * */
    public abstract R apply();
}
