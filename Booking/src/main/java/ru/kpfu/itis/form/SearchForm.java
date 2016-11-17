package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Ilgiz on 13.11.2016.
 */
public class SearchForm {

    @NotEmpty(message = "Please write city!")
    private String city;

    @NotNull
    @Digits(integer = 1, fraction = 0, message = "only integer number from 1 to 9")
    private Integer quantity;

    @Digits(integer = 8, fraction = 2, message = "only numbers with 2 digits after point!!")
    private Double money;

    @NotNull(message = "Please write arrival date!")
    @Future
    private Date from;

    @NotNull(message = "Please write date of departure!")
    @Future
    private Date to;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
