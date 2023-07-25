package cl.thym.thymexample.service;

import cl.thym.thymexample.entity.User;
import cl.thym.thymexample.ex.NotFoundException;

import java.util.List;

public interface UserService {

    void init();

    User findUserById(Long idUser) throws NotFoundException;

    User findByUsername(String username) throws NotFoundException;

    List<User> findByUsernameLike(String usernameLike) throws NotFoundException;

    User findByEmail(String email) throws NotFoundException;

    List<User> findByEmailLike(String email) throws NotFoundException;

}
