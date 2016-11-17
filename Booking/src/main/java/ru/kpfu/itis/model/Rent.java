package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "hId")
    private Hotel hId;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "nId")
    private HotelNumber nId;

    @ManyToOne
    @JoinColumn(name = "cId")
    private Customer cId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDeparture;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HotelNumber getnId() {
        return nId;
    }

    public void setnId(HotelNumber nId) {
        this.nId = nId;
    }

    public Customer getcId() {
        return cId;
    }

    public void setcId(Customer cId) {
        this.cId = cId;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
}
