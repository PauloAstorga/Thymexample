package cl.thym.thymexample.repository;


import cl.thym.thymexample.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Slf4j
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp() {
        log.info("RoleRepositoryTest - Set Up");

        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1L, "ADM"));
        roleList.add(new Role(2L, "USR"));
        roleList.add(new Role(3L, "CLI"));
        roleList.add(new Role(4L, "ROA"));
        roleList.add(new Role(5L, "ZZZ"));
        roleList.add(new Role(6L, "ZXX"));
        roleList.add(new Role(7L, "ZXC"));
        roleList.add(new Role(8L, "ZXZ"));
        roleList.add(new Role(9L, "ZXQ"));
        roleList.add(new Role(10L, "QZX"));
        roleList.add(new Role(11L, "QQQ"));

        roleRepository.saveAllAndFlush(roleList);
    }

    @Test
    public void findRoleById() {
        Role role = roleRepository.findById(12l).get();
        assertEquals(12L, role.getId());
    }

    @Test
    public void findRoleByIdLike() {
        List<Role> roles = roleRepository.findRoleByIdLike(1L);
        assertEquals(3L, roles.size());
    }

    @Test
    public void findAllProduceAllRoles() {
        List<Role> roles = roleRepository.findAll();
        assertEquals(11, roles.size());
    }

    @Test
    public void findRoleByName() {
        Role role = roleRepository.findRoleByName("ADM");
        assertEquals("ADM", role.getName());

        role = roleRepository.findRoleByName("ZZZ");
        assertEquals("ZZZ", role.getName());
    }

    @Test
    public void findAllRolesByNameLike() {
        List<Role> roles = roleRepository.findRoleByNameLike("R");
        assertEquals(2, roles.size());

        roles = roleRepository.findRoleByNameLike("AD");
        assertEquals(1, roles.size());

        roles = roleRepository.findRoleByNameLike("Z");
        assertEquals(6, roles.size());
    }

}
