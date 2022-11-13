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
    public Long getListId() {
        return list_id;
    }

    public void setListId(Long listId) {
        list_id = listId;
    }

    public TaskList(String name) {
        this.name = name;
    }

    public Long getId() {
        return list_id;
    }

    public void setId(Long id) {
        this.list_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
