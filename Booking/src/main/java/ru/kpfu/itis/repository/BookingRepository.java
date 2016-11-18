package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Booking;

/**
 * Created by Ilgiz on 15.11.2016.
 */

public interface BookingRepository {

    boolean save(Booking booking, String username);
}
