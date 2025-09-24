package model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Todo {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private String status;
    private String date;

    public Todo() {
    }

    public Todo(String title, String description, String status, String date) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + ", date=" + date + '}';
    }
    
    
}
