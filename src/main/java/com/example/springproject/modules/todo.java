package com.example.springproject.modules;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
@Entity
@Table(name = "task")
public class todo {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotNull("Name should be not empty ")
    private String name ;
    @NotNull("Age should be not empty ")
    private String age ;
    public todo() {
    }
    public todo(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "todoController{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
