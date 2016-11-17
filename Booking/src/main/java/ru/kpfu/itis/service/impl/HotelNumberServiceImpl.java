package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.HotelNumber;
import ru.kpfu.itis.repository.HotelNumberRepository;
import ru.kpfu.itis.service.HotelNumberService;

/**
 * Created by Ilgiz on 15.11.2016.
 */
@Service
public class HotelNumberServiceImpl implements HotelNumberService {
    @Autowired
    HotelNumberRepository numberRepository;

    @Override
    public HotelNumber findById(String numberId) {
        Long id = null;
        try {

            id = Long.valueOf(numberId);
        } catch (RuntimeException e) {

            return null;
        }

        return numberRepository.findById(id);
    }
}
