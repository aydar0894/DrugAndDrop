package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Booking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgiz on 15.11.2016.
 */
public class BookingValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Booking.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Booking booking = (Booking) o;

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date dateOfBirth = null;

        boolean isDataError = false;

        try {
            dateOfBirth = format.parse(booking.getBirthDay());

        } catch (ParseException e) {
            errors.rejectValue("birthDay", "", "wrong date format of birth day!");
            isDataError = true;
        }

        if (!isDataError) {
            if (dateOfBirth.after(Calendar.getInstance().getTime())) {
                errors.rejectValue("birthDay", "", "wrong birth day date, it must be in past!");
                isDataError = true;
            } else {

                long diffInMillies = -dateOfBirth.getTime() + Calendar.getInstance().getTime().getTime();
                long days = (TimeUnit.DAYS).convert(diffInMillies, TimeUnit.MILLISECONDS);

                if (days < 366 * 18) {
                    errors.rejectValue("birthDay", "", "Sorry, you little for booking:(");
                    isDataError = true;
                }
            }
        }

        booking.setDateOfBirth(dateOfBirth);

    }
}
