package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Rent;

import java.util.List;

/**
 * Created by Ilgiz on 17.11.2016.
 */
public interface RentRepository {
    List<Rent> findAll();
}
