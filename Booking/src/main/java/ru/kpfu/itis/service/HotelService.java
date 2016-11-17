package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Hotel;

import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Service

public interface HotelService {
    List<Hotel> getAll();
}
