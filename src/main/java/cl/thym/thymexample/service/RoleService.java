package cl.thym.thymexample.service;

import cl.thym.thymexample.entity.Role;
import cl.thym.thymexample.ex.NotFoundException;

import java.util.List;


public interface RoleService {

    void init();

    List<Role> findAll();

    Role findRoleById(Long id) throws NotFoundException;

    Role findRoleByName(String name) throws NotFoundException;

    List<Role> findRoleByIdLike(Long idlike) throws NotFoundException;

    List<Role> findRoleByNameLike(String nameLike) throws NotFoundException;

}
