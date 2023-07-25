package cl.thym.thymexample.service.impl;

import cl.thym.thymexample.entity.Role;
import cl.thym.thymexample.ex.NotFoundException;
import cl.thym.thymexample.repository.RoleRepository;
import cl.thym.thymexample.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void init() {
        roleRepository.save(new Role(1L, "ADM"));
        roleRepository.save(new Role(2L, "CLI"));
        roleRepository.save(new Role(3L, "USR"));
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(Long id) throws NotFoundException {

        Optional<Role> roleFound = roleRepository.findById(id);

        if (!roleFound.isPresent()) {
            log.error("Role(s) not found with id : " + id);
            throw new NotFoundException("Role(s) not found with id : " + id);
        }

        return roleFound.get();
    }

    @Override
    public Role findRoleByName(String name) throws NotFoundException {

        Optional<Role> roleFound = Optional.ofNullable(roleRepository.findRoleByName(name));

        if (!roleFound.isPresent()) {
            log.error("Role(s) not found with name : " + name);
            throw new NotFoundException("Role(s) not found with name : " + name);
        }

        return roleFound.get();
    }

    @Override
    public List<Role> findRoleByIdLike(Long idLike) throws NotFoundException {

        Optional<List<Role>> rolesFound = Optional.ofNullable(roleRepository.findRoleByIdLike(idLike));

        if (!rolesFound.isPresent()) {
            log.error("Role(s) not found with ID like: " + idLike);
            throw new NotFoundException("Role(s) not found with ID like: " + idLike);
        }

        return rolesFound.get();
    }

    @Override
    public List<Role> findRoleByNameLike(String nameLike) throws NotFoundException {

        Optional<List<Role>> rolesFound = Optional.ofNullable(roleRepository.findRoleByNameLike(nameLike));

        if (!rolesFound.isPresent()) {
            log.error("Role(s) not found with name like: " + nameLike);
            throw new NotFoundException("Role(s) not found with name like: " + nameLike);
        }

        return rolesFound.get();
    }

}
