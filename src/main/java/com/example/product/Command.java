package com.example.product;

public interface Command <I, O>{
    O execute(I input);
}
