package ru.otus.example.ormdemo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtusStudent {
    private long id;
    private String name;

    //private List<Course> courses;
}
