package cl.thym.thymexample.repository;

import cl.thym.thymexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public List<User> findByUsernameLike(String username);

    public User findByEmail(String email);

    public List<User> findByEmailLike(String email);

}
