package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Search;
import ru.kpfu.itis.model.HotelNumber;
import ru.kpfu.itis.repository.HotelNumberRepository;
import ru.kpfu.itis.service.SearchService;

import java.util.List;

/**
 * Created by Ilgiz on 14.11.2016.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    HotelNumberRepository hotelNumberRepository;

    @Override
    public List<HotelNumber> search(Search search) {
        if (search != null)
            return hotelNumberRepository.getAllByBooking(search);
        return null;
    }
}
