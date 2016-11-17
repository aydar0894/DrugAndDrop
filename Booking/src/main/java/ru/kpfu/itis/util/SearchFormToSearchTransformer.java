package ru.kpfu.itis.util;

import ru.kpfu.itis.form.SearchForm;
import ru.kpfu.itis.model.Search;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgiz on 14.11.2016.
 */
public class SearchFormToSearchTransformer {

    public static Search transform(SearchForm form) {
        if (form == null) {
            return null;
        }
        Search search = new Search();

        search.setPlace(form.getCity());
        search.setFrom(form.getFrom());
        search.setTo(form.getTo());
        search.setPeopleQuantity(form.getQuantity());

        long diffInMillies = search.getTo().getTime() - search.getFrom().getTime();
        long days = (TimeUnit.DAYS).convert(diffInMillies, TimeUnit.MILLISECONDS);

        search.setDayCount((int) days);
        search.setMoney(form.getMoney());

        return search;
    }
}
