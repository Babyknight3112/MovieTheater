package com.movietheater.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int roleId;

    @Column(nullable = false)
    private  String roleName;

    @OneToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

}
