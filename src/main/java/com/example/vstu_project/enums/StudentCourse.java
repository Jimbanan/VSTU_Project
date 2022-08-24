package com.example.vstu_project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentCourse {

    ONE("1"),

    ONE_TO_TWO("1-2"),

    ONE_TO_THREE("1-3"),

    ONE_TO_FOUR("1-4"),

    ONE_TO_FIVE("1-5"),

    TWO("2"),

    TWO_TO_THREE("2-3"),

    TWO_TO_FOUR("2-4"),

    TWO_TO_FIVE("2-5"),

    THREE("3"),

    THREE_TO_FOUR("3-4"),

    THREE_TO_FIVE("3-5"),

    FOUR("4"),

    FOUR_FIVE("4-5"),

    FIVE("5");


    private final String displayValue;

}
