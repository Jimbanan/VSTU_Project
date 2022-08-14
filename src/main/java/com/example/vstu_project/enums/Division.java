package com.example.vstu_project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Division {

    STUDENT("Студент"),
    DEANERY("Деканат"),
    CHAIR("Кафедра"),
    PHD("Аспирантура");

    private final String displayValue;

}
