package cl.thym.thymexample.repository;

import cl.thym.thymexample.entity.UserPrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserPrivate, Long> {

    public UserPrivate findByUsername(String username);

    public List<UserPrivate> findByUsernameLike(String username);

    public UserPrivate findByRoleId(Long roleId);

    public List<UserPrivate> findByRoleIdLike(Long roleIdLike);

}
