package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "Hotels")

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String hotelLocation;

    private String name;

    private int hotelCategory;

    private String pictUrl;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<HotelNumber> numbers;

    @OneToMany(mappedBy = "hId", cascade = CascadeType.REMOVE)
    private List<Rent> rents;

    @OneToMany(mappedBy = "hId", cascade = CascadeType.REMOVE)
    private List<Staff> staffs;

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(int hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public List<HotelNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<HotelNumber> numbers) {
        this.numbers = numbers;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
