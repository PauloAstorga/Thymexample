package cl.thym.thymexample.service.impl;

import cl.thym.thymexample.entity.UserPrivate;
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
        userRepository.save(new UserPrivate(1L, "pepe", "321321", "pepe1@gmail.com", 1L));
        userRepository.save(new UserPrivate(2L, "pepin", "321321", "pepin@gmail.com", 3L));
        userRepository.save(new UserPrivate(3L, "pepote", "321321", "pepote@gmail.com", 2L));
        userRepository.save(new UserPrivate(4L, "jjj", "321321", "jjj@gmail.com", 1L));
        userRepository.save(new UserPrivate(5L, "zxcvbn", "321321", "zxcvbn@gmail.com", 2L));
        userRepository.save(new UserPrivate(6L, "epe", "321321", "epe@gmail.com", 3L));
        userRepository.save(new UserPrivate(7L, "pe", "321321", "pe@gmail.com", 2L));
    }

    @Override
    public List<UserPrivate> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserPrivate findUserById(Long id) throws NotFoundException {
        Optional<UserPrivate> userFound = userRepository.findById(id);

        if (!userFound.isPresent()) {
            log.error("User(s) not found with id : " + id);
            throw new NotFoundException("User(s) not found with id : " + id);
        }

        return userFound.get();
    }

    @Override
    public UserPrivate findByUsername(String username) throws NotFoundException {

        Optional<UserPrivate> userFound = Optional.ofNullable(userRepository.findByUsername(username));

        if (!userFound.isPresent()) {
            log.error("User(s) not found with username : " + username);
            throw new NotFoundException("User(s) not found with username : " + username);
        }

        return userFound.get();
    }

    @Override
    public List<UserPrivate> findByUsernameLike(String usernameLike) throws NotFoundException {

        Optional<List<UserPrivate>> usersFound = Optional.ofNullable(userRepository.findByUsernameLike(usernameLike));

        if (!usersFound.isPresent()) {
            log.error("User(s) not found with username like : " + usernameLike);
            throw new NotFoundException("User(s) not found with username like : " + usernameLike);
        }

        return usersFound.get();
    }

    @Override
    public UserPrivate findByRole(Long roleId) throws NotFoundException {
        Optional<UserPrivate> userFound = Optional.ofNullable(userRepository.findByRoleId(roleId));

        if (!userFound.isPresent()) {
            log.error("User(s) not found with roleId : " + roleId);
            throw new NotFoundException("User(s) not found with roleId : " + roleId);
        }

        return userFound.get();
    }

    @Override
    public List<UserPrivate> findByRoleLike(Long roleIdLike) throws NotFoundException {

        Optional<List<UserPrivate>> usersFound = Optional.ofNullable(userRepository.findByRoleIdLike(roleIdLike));

        if (!usersFound.isPresent()) {
            log.error("User(s) not found with roleId like : " + roleIdLike);
            throw new NotFoundException("User(s) not found with roleId like : " + roleIdLike);
        }

        return usersFound.get();
    }

    @Override
    public List<UserPrivate> findUserPrivatesByEmailLike(String emailLike) throws NotFoundException {
        Optional<List<UserPrivate>> usersFound = Optional.ofNullable(userRepository.findUserPrivatesByEmailLike(emailLike));

        if (!usersFound.isPresent()) {
            log.error("User(s) not found with email like : " + emailLike);
            throw new NotFoundException("User(s) not found with email like : " + emailLike);
        }

        return usersFound.get();
    }

    @Override
    public UserPrivate findUserPrivatebyEmail(String email) throws NotFoundException {
        Optional<UserPrivate> userFound = Optional.ofNullable(userRepository.findUserPrivateByEmail(email));

        if (!userFound.isPresent()) {
            log.error("User(s) not found with email : " + email);
            throw new NotFoundException("User(s) not found with email : " + email);
        }

        return userFound.get();
    }

}
