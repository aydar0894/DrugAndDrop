package ru.kpfu.itis.repository;

import ru.kpfu.itis.form.StaffForm;
import ru.kpfu.itis.model.Staff;

import java.util.List;

/**
 * Created by Ilgiz on 17.11.2016.
 */
public interface StaffRepository {
    List<Staff> findAll();

    boolean save(StaffForm staff);

    boolean deleteById(Long id);
}
