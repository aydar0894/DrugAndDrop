package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Booking;
import ru.kpfu.itis.repository.BookingRepository;
import ru.kpfu.itis.service.BookingService;

/**
 * Created by Ilgiz on 15.11.2016.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
}
