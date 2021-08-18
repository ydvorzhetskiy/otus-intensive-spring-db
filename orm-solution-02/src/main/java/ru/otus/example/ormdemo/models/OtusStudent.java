package ru.otus.example.ormdemo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Указывает, что данный класс является сущностью
@Table(name = "otus_students") // Задает имя таблицы, на которую будет отображаться сущность
public class OtusStudent {
    @Id // Позволяет указать какое поле является идентификатором
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Стратегия генерации идентификаторов
    private long id;

    // Задает имя и некоторые свойства поля таблицы, на которое будет отображаться поле сущности
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Указывает на связь между таблицами "один к одному"
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "holder",
            orphanRemoval = true
    )
    private List<Avatar> avatar;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<Course> courses;
}
