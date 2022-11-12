package com.example.springproject.modules;

import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull("Title of task should be not empty")
    private String title ;
    @NotNull("Deadline should be not empty")
    private String deadline ;
    private String description;
    @NotNull ("Status should be not null should be true or false")
    private boolean status ;

    public Task() {
    }
    public Task(Long id, String name, String  deadline ,String description , boolean status) {
        this.id = id;
        this.title = name;
        this.deadline = deadline;
        this.description = description;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "todoController{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
