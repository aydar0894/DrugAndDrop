package ru.kpfu.itis.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Ilgiz on 12.11.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User findOneByUsername(String username) {
        Query query = em.createNativeQuery("SELECT * from users where username = ?", User.class);
        query.setParameter(1, username);
        List<User> results = query.getResultList();
        User user = null;
        if (!results.isEmpty()) {
            user = results.get(0);
        }

        return user;
    }

    @Override
    @Transactional
    public boolean save(User user) {
        Query query = em.createNativeQuery("INSERT INTO users (username, pass, role, email, phone) " +
                "VALUES (?, ?, ?, ?, ?);");
        query.setParameter(1, user.getUsername());
        query.setParameter(2, user.getPass());
        query.setParameter(3, user.getRole().toString());
        query.setParameter(4, user.getEmail());
        query.setParameter(5, user.getPhone());
        int result = query.executeUpdate();

        return result != 1;
    }
}
