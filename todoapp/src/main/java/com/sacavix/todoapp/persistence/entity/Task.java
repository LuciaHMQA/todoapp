package com.sacavix.todoapp.persistence.entity;


import lombok.Data;
//Importamos persistence para su uso
import javax.persistence.*;
//Importamos LocalDateTime para usarlo después en createdDate
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;

}
