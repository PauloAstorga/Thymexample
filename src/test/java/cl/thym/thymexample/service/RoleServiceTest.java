package cl.thym.thymexample.service;

import cl.thym.thymexample.entity.Role;
import cl.thym.thymexample.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyString;

@DataJpaTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    private final String findByNameA = "A";
    private final String findByNameI = "I";
    private final String findByNameX = "X";

    private final Long findById1 = 1L;
    private final Long findById11 = 11L;
    private final Long findById5 = 5L;

    @BeforeAll
    public void allSetup() {
        List<Role> roleList = new ArrayList<>();
        roleList.add(new Role(1L,"ADM"));
        roleList.add(new Role(2L,"CLI"));
        roleList.add(new Role(3L,"USR"));
        roleList.add(new Role(1_000_000L,"ADE"));
        roleList.add(new Role(1L,"ZZA"));

        Mockito.when(roleRepository.findAll()).thenReturn(roleList);

        /**
         * Find By Name
         */
        Mockito.when(roleRepository.findRoleByName(findByNameA)).thenReturn(
                roleList.stream().filter(role -> role.getName().equals(findByNameA)).findFirst().get()
        );

        Mockito.when(roleRepository.findRoleByNameLike(findByNameA)).thenReturn(
                roleList.stream().filter(role -> role.getName().contains(findByNameA)).collect(Collectors.toList())
        );

        Mockito.when(roleRepository.findRoleByName(findByNameI)).thenReturn(
                roleList.stream().filter(role -> role.getName().equals(findByNameI)).findFirst().get()
        );

        Mockito.when(roleRepository.findRoleByNameLike(findByNameI)).thenReturn(
                roleList.stream().filter(role -> role.getName().contains(findByNameI)).collect(Collectors.toList())
        );

        Mockito.when(roleRepository.findRoleByName(findByNameX)).thenReturn(
                roleList.stream().filter(role -> role.getName().equals(findByNameI)).findFirst().get()
        );

        Mockito.when(roleRepository.findRoleByNameLike(findByNameX)).thenReturn(
                roleList.stream().filter(role -> role.getName().contains(findByNameI)).collect(Collectors.toList())
        );

        /**
         * Find By ID
         */
        Mockito.when(roleRepository.findById(findById1)).thenReturn(
                roleList.stream().filter(role -> role.getId()==findById1).findFirst()
        );

        Mockito.when(roleRepository.findRoleByNameLike(findByNameA)).thenReturn(
                roleList.stream().filter(role -> role.getName().contains(findByNameA)).collect(Collectors.toList())
        );
    }

    @BeforeEach
    public void setUp() {
        roleRepository = Mockito.mock(RoleRepository.class);
        log.info("RoleRepositoryTest - Set Up");
    }



}
