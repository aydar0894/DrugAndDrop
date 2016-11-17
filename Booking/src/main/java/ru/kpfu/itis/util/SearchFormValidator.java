package ru.kpfu.itis.util;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.form.SearchForm;

import java.util.Calendar;
import java.util.Date;

public class SearchFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return SearchForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SearchForm searchForm = (SearchForm) o;

        Date from = searchForm.getFrom();
        Date to = searchForm.getTo();

        boolean isDataError = false;

        if (from.before(Calendar.getInstance().getTime())) {
            errors.rejectValue("from", "", "wrong date of arrival date, it must be in future!");
            isDataError = true;
        }

        if (to.before(Calendar.getInstance().getTime())) {
            errors.rejectValue("to", "", "wrong date of departure date, it must be in future!");
            isDataError = true;
        }


        if (!isDataError && !to.after(from)) {
            errors.rejectValue("to", "", "date of departure date must be after arrival date!");
        }

    }
}
