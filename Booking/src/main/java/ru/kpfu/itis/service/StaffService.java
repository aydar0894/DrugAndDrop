package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.StaffForm;

/**
 * Created by Ilgiz on 17.11.2016.
 */
@Service
public interface StaffService {
    boolean addStaff(StaffForm staff);
}
