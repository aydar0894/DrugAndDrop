package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Hotel;

import java.util.List;

/**
 * Created by Ilgiz on 13.11.2016.
 */
public interface HotelRepository {
    List<Hotel> findAll();
}
