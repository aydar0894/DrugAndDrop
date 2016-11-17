package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.User;

public interface UserRepository {

    User findOneByUsername(String username);

    boolean save(User user);
}
