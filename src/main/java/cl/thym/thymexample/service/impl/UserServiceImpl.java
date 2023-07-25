package cl.thym.thymexample.service.impl;

import cl.thym.thymexample.entity.User;
import cl.thym.thymexample.ex.NotFoundException;
import cl.thym.thymexample.repository.UserRepository;
import cl.thym.thymexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void init() {
        userRepository.save(new User(1L, "pepe", "321321", 1L));
        userRepository.save(new User(2L, "pepin", "321321", 3L));
        userRepository.save(new User(3L, "pepote", "321321", 2L));
        userRepository.save(new User(4L, "jjj", "321321", 1L));
        userRepository.save(new User(5L, "zxcvbn", "321321", 2L));
        userRepository.save(new User(6L, "epe", "321321", 3L));
        userRepository.save(new User(7L, "pe", "321321", 2L));
    }

    @Override
    public User findByUsername(String username) throws NotFoundException {

        Optional<User> userFound = Optional.ofNullable(userRepository.findByUsername(username));

        if (!userFound.isPresent()) {
            log.error("User(s) not found with username : " + username);
            throw new NotFoundException("User(s) not found with username : " + username);
        }

        return userFound.get();
    }

    @Override
    public List<User> findByUsernameLike(String usernameLike) throws NotFoundException {

        Optional<List<User>> usersFound = Optional.ofNullable(userRepository.findByUsernameLike(usernameLike));

        if (!usersFound.isPresent()) {
            log.error("User(s) not found with username like : " + usernameLike);
            throw new NotFoundException("User(s) not found with username like : " + usernameLike);
        }

        return usersFound.get();
    }

    @Override
    public User findByEmail(String email) throws NotFoundException {
        Optional<User> userFound = Optional.ofNullable(userRepository.findByEmail(email));

        if (!userFound.isPresent()) {
            log.error("User(s) not found with email : " + email);
            throw new NotFoundException("User(s) not found with email : " + email);
        }

        return userFound.get();
    }

    @Override
    public List<User> findByEmailLike(String emailLike) throws NotFoundException {

        Optional<List<User>> usersFound = Optional.ofNullable(userRepository.findByEmailLike(emailLike));

        if (!usersFound.isPresent()) {
            log.error("User(s) not found with email like : " + emailLike);
            throw new NotFoundException("User(s) not found with email like : " + emailLike);
        }

        return usersFound.get();
    }

}
