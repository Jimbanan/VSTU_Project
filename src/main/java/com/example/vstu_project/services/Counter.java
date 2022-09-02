package com.example.vstu_project.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Counter {
    private int count;

    public Counter() {
        count = 0;
    }

    public void clear() {
        count = 0;
    }

    public int incrementAndGet() {
        return ++count;
    }

    public String toString() {
        return "" + count;
    }
}
