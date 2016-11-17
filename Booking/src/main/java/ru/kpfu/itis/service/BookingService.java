package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Booking;

/**
 * Created by Ilgiz on 15.11.2016.
 */
@Service
public interface BookingService {
    void save(Booking booking);
}
