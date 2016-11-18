package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.UserRegistrationForm;

@Service
public interface UserService {

    boolean saveNewUser(UserRegistrationForm form);

    void securedMethod();

}
