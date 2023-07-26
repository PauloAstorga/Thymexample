package cl.thym.thymexample.repository;


import cl.thym.thymexample.entity.Role;
import lombok.extern.slf4j.Slf4j;
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

        roleRepository.saveAllAndFlush(roleList);
    }

    @Test
    public void findAllProduceAllRoles() {
        List<Role> roles = roleRepository.findAll();
        assertEquals(roles.size(), 3);
    }

}
