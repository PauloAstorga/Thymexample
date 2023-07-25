package cl.thym.thymexample.service;

import cl.thym.thymexample.entity.UserPrivate;
import cl.thym.thymexample.ex.NotFoundException;

import java.util.List;

public interface UserService {

    void init();

    List<UserPrivate> findAll();

    UserPrivate findUserById(Long idUser) throws NotFoundException;

    UserPrivate findByUsername(String username) throws NotFoundException;

    List<UserPrivate> findByUsernameLike(String usernameLike) throws NotFoundException;

    UserPrivate findByRole(Long roleId) throws NotFoundException;

    List<UserPrivate> findByRoleLike(Long roleIdLike) throws NotFoundException;

}
