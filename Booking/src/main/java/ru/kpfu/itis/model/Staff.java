package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "hId")
    private Hotel hId;

    private String name;

    private int salary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;

    private int phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hotel gethId() {
        return hId;
    }

    public void sethId(Hotel hId) {
        this.hId = hId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
