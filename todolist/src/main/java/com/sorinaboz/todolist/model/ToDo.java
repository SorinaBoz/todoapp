package com.sorinaboz.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  
    private Long id;

    private String description;


    private boolean complete;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deadline;

    public ToDo() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }



    public ToDo(String description, Date deadline) {
        this.description = description;
        this.complete = false;
        this.deadline = deadline;
    }

//    @Override
//    public String toString() {
//        return String.format("TodoItem{id=%d, description='%s', complete='%s', deadline='%s'}",
//                id, description, complete, deadline);
//    }


}
