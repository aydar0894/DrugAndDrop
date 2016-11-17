package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "HotelNumbers")
public class HotelNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;

    private double price;

    @ManyToOne
    @JoinColumn(name = "catNum")
    private Category catNum;

    @ManyToOne
    @JoinColumn(name = "hId")
    private Hotel hotel;

    @OneToMany(mappedBy = "nId", cascade = CascadeType.REMOVE)
    private List<Rent> rents;

    @OneToMany(mappedBy = "numId", cascade = CascadeType.REMOVE)
    private List<NumberState> states;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCatNum() {
        return catNum;
    }

    public void setCatNum(Category catNum) {
        this.catNum = catNum;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public List<NumberState> getStates() {
        return states;
    }

    public void setStates(List<NumberState> states) {
        this.states = states;
    }
}
