package com.godcoder.myhome.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="ev_user")
@SequenceGenerator(
        name="USER_SEQ_GEN",
        sequenceName = "EV_USER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "USER_SEQ_GEN")
    private Integer user_id;
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name="ev_user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
     private List<Role> roles = new ArrayList<>();

}