package cl.thym.thymexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 20, unique = true, updatable = false)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    private Long roleId;

}
