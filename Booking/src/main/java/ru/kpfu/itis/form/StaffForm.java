package ru.kpfu.itis.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Ilgiz on 17.11.2016.
 */
public class StaffForm {

    @NotNull(message = "Please write hotel id!")
    private Long hId;

    @NotEmpty(message = "Please write name!")
    private String name;

    @Digits(integer = 8, fraction = 2, message = "only numbers with 2 digits after point!!")
    private int salary;

    @NotNull(message = "Please write birthday!")
    @Past
    private Date dateOfBirth;

    @NotNull(message = "Please write position!")
    private Long position;

    @Digits(integer = 8, fraction = 2, message = "only numbers with 2 digits after point!!")
    private int phone;

    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
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

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
