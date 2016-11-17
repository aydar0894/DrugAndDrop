package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Search;
import ru.kpfu.itis.model.HotelNumber;

import java.util.List;

/**
 * Created by Ilgiz on 14.11.2016.
 */
@Service
public interface SearchService {
    List<HotelNumber> search(Search search);
}
