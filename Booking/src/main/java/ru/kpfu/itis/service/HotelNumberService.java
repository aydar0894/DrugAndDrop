package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.HotelNumber;

/**
 * Created by Ilgiz on 15.11.2016.
 */
@Service
public interface HotelNumberService {
    HotelNumber findById(String numberId);
}
