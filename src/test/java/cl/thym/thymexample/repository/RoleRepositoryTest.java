package cl.thym.thymexample.repository;


import cl.thym.thymexample.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class RoleRepositoryTest {

    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp() {
        roleRepository = Mockito.mock(RoleRepository.class);
        log.info("RoleRepositoryTest - Set Up");
    }

    @Test
    public void AddRole_And_FindById() {
        log.info("RoleRepositoryTest - AddRole_And_FindById");
        Role role = new Role();
        role.setId(2L);
        role.setName("ADM");

        log.info("RoleRepositoryTest - Role to mock: " + role.toString());
        when(roleRepository.findById(anyLong())).thenReturn(Optional.of(role));
        Optional<Role> returnedRole = this.roleRepository.findById(2L);

        assertTrue(returnedRole.isPresent());
        verify(this.roleRepository).findById(2L);
    }

    @Test
    public void AddRole_And_FindByName() {
        log.info("RoleRepositoryTest - AddRole_And_FindByName");
        Role role = new Role();
        role.setId(1L);
        role.setName("CLI");

        log.info("RoleRepositoryTest - Role to mock: " + role.toString());
        when(roleRepository.save(any(Role.class))).thenReturn(role);
        roleRepository.save(role);

        when(roleRepository.findRoleByName(anyString())).thenReturn(role);
        Role returnedRole = this.roleRepository.findRoleByName("CLI");

        assertEquals("CLI", returnedRole.getName());

        verify(this.roleRepository).save(role);
        verify(this.roleRepository).findRoleByName("CLI");
    }

    @Test
    public void AddRole_And_FindByIdLike() {
        log.info("RoleRepositoryTest - AddRole_And_FindByIdLike");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, "ADM"));
        roles.add(new Role(2L, "CLI"));
        roles.add(new Role(3L, "USR"));
        roles.add(new Role(11L, "AAA"));

        when(roleRepository.findRoleByIdLike(anyLong()))
                .thenReturn(
                        roles.stream()
                                .filter(role -> String.valueOf( role.getId()).contains("1") )
                                .collect(Collectors.toList())
        );

        List<Role> returnedRoles = roleRepository.findRoleByIdLike(1L);
        assertEquals(2, returnedRoles.size());

        verify(this.roleRepository).findRoleByIdLike(1L);
    }

    @Test
    public void AddRole_And_FindByNameLike() {
        log.info("RoleRepositoryTest - AddRole_And_FindByNameLike");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, "ADM"));
        roles.add(new Role(2L, "CLI"));
        roles.add(new Role(3L, "USR"));
        roles.add(new Role(11L, "AAA"));
        roles.add(new Role(13L, "USS"));

        final String testWithA = "A";
        final String testWithI = "I";

        when(roleRepository.findRoleByNameLike(testWithA))
                .thenReturn(
                        roles.stream()
                                .filter(role -> role.getName().contains(testWithA) )
                                .collect(Collectors.toList())
                );

        when(roleRepository.findRoleByNameLike(testWithI))
                .thenReturn(
                        roles.stream()
                                .filter(role -> role.getName().contains(testWithI) )
                                .collect(Collectors.toList())
                );

        List<Role> returnedRolesWithA = roleRepository.findRoleByNameLike("A");
        assertEquals(2, returnedRolesWithA.size());

        List<Role> returnedRolesWithI = roleRepository.findRoleByNameLike("I");
        assertEquals(1, returnedRolesWithI.size());

        verify(this.roleRepository).findRoleByNameLike("A");
        verify(this.roleRepository).findRoleByNameLike("I");
    }

    @Test
    public void Find_AllRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1L, "ADM"));
        roles.add(new Role(2L, "CLI"));
        roles.add(new Role(100L, "USR"));

        when(roleRepository.findAll()).thenReturn(roles);

        Integer rolesFound = roleRepository.findAll().size();

        assertEquals(3, rolesFound);

        verify(this.roleRepository).findAll();
    }

}
