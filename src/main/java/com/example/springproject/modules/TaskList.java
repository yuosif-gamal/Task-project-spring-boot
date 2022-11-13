package com.example.springproject.modules;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;

@Entity
@Table
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long list_id;
    @NotNull
    private  String name;

    public TaskList() {
    }

    public TaskList(@NotNull String name) {
        this.name = name;
    }

    public Long getList_id() {
        return list_id;
    }

    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
