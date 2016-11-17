package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Search;
import ru.kpfu.itis.model.HotelNumber;

import java.util.List;

/**
 * Created by Ilgiz on 14.11.2016.
 */
public interface HotelNumberRepository {
    List<HotelNumber> getAllByBooking(Search search);
    HotelNumber findById(Long id);
}
