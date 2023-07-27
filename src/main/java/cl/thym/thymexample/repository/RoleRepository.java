package cl.thym.thymexample.repository;

import cl.thym.thymexample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleByName(String name);

    @Query(nativeQuery = true, value = "select * from Role r where r.name LIKE %:nameLike%")
    public List<Role> findRoleByNameLike(@Param("nameLike") String nameLike);

    @Query(nativeQuery = true, value = "select * from Role r where r.id LIKE %:idLike%")
    public List<Role> findRoleByIdLike(@Param("idLike") Long idLike);

}
