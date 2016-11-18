package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.form.StaffForm;
import ru.kpfu.itis.model.Staff;
import ru.kpfu.itis.repository.StaffRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ilgiz on 17.11.2016.
 */
@Repository
public class StaffRepositoryImpl implements StaffRepository {
    @PersistenceContext
    EntityManager em;


    @Override
    public List<Staff> findAll() {
        Query query = em.createNativeQuery("SELECT TOP 100 * from Staff;", Staff.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public boolean save(StaffForm staff) {
        Query query = em.createNativeQuery("insert into dbo.Staff(hId, name, salary, dateOfBirth, position, phone)\n" +
                "values (?, ?, ?, ?, ?, ?);");
        query.setParameter(1, staff.gethId());
        query.setParameter(2, staff.getName());
        query.setParameter(3, staff.getSalary());
        query.setParameter(4, staff.getDateOfBirth());
        query.setParameter(5, staff.getPosition());
        query.setParameter(6, staff.getPhone());
        int result = query.executeUpdate();

        return result != 1;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        Query query = em.createNativeQuery("DELETE * from Staff where id = ?;");
        query.setParameter(1, id);
        int result = query.executeUpdate();

        return result != 1;
    }


}
