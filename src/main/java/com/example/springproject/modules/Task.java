package com.example.springproject.modules;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull("title of task should be not empty ")
    private String title ;
    @NotNull("Age should be not empty ")
    private int  age ;
    public Task() {
    }
    public Task(Long id, String name, int  age) {
        this.id = id;
        this.title = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "todoController{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", age=" + age +
                '}';
    }
}
