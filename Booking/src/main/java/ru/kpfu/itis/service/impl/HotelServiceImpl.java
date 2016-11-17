package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Hotel;
import ru.kpfu.itis.repository.HotelRepository;
import ru.kpfu.itis.service.HotelService;

import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
@Service

public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
