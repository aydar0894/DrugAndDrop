package ru.kpfu.itis.form;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationForm {

    @NotEmpty(message = "Login mustn't be empty")
    private String username;

    @Size(min = 6, max = 24, message = "Password should consist min 6 max 24 simvols")
    private String pass;

    private String repassword;

    @NotEmpty(message = "Please write a phone number")
    @Pattern(regexp = "\\d{11}", message = "Phone should consist only 11 digits")
    private String phone;

    @NotEmpty
    @Email(message = "Invalid email")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
