package com.example.springproject.modules;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull("Title of task should be not empty")
    private String title ;
    @NotNull("Deadline should be not empty")
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date deadline ;
    @NotNull
    private String description;
    @NotNull ("Status should be not null should be true or false")
    private boolean status ;

    private Long list_id;
    public Task() {
        deadline = null;
    }

    public Long getList_id() {
        return list_id;
    }

    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }
    public Task(String name, Date  deadline , String description , boolean status ) {
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
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
