package com.example.todolist.datamodel;

import java.time.LocalDate;

public class toDoItem {
private String subject;
private String shortDescription;
private LocalDate date;

    public toDoItem(String subject, String shortDescription, LocalDate date) {
        this.subject = subject;
        this.shortDescription = shortDescription;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String toString()
    {
        return subject+" "+shortDescription;
    }

    public String getDetails() {
        return subject+" "+shortDescription;
    }
}
