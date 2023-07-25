package cl.thym.thymexample.repository;

import cl.thym.thymexample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByName(String name);

    public List<Role> findRoleByNameLike(String nameLike);

    public List<Role> findRoleByIdLike(Long idLike);

}
