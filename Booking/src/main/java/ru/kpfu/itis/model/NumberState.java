package ru.kpfu.itis.model;

import javax.persistence.*;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Entity
@Table(name = "NumberState")
public class NumberState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "numId")
    private HotelNumber numId;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staffId;

    private int numState;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HotelNumber getNumId() {
        return numId;
    }

    public void setNumId(HotelNumber numId) {
        this.numId = numId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public int getNumState() {
        return numState;
    }

    public void setNumState(int numState) {
        this.numState = numState;
    }
}
