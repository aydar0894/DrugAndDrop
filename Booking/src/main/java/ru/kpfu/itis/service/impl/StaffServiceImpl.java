package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.StaffForm;
import ru.kpfu.itis.repository.StaffRepository;
import ru.kpfu.itis.service.StaffService;

/**
 * Created by Ilgiz on 17.11.2016.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;

    @Override
    public boolean addStaff(StaffForm form) {
        if (form != null)
            return staffRepository.save(form);
        return false;
    }
}
