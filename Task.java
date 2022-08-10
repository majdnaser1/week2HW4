package com.example.springbootday;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean status;
    private String deadline;


}

