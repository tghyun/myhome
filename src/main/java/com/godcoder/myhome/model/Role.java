package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ev_role")
@SequenceGenerator(
        name="ROLE_SEQ_GEN",
        sequenceName = "EV_ROLE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "ROLE_SEQ_GEN")
    private Long role_id;
    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}