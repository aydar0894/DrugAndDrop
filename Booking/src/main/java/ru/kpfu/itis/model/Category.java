package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int capacity;

    private int numOfrooms;

    private int breakfast;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumOfrooms() {
        return numOfrooms;
    }

    public void setNumOfrooms(int numOfrooms) {
        this.numOfrooms = numOfrooms;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
