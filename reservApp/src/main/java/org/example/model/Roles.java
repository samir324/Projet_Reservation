package org.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Roles implements Serializable {
    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    @Column(nullable = false, unique = true)
    private String roleName;


    @OneToMany(mappedBy = "role")
    private List<Users> users;
    //Constructor
    public Roles(){}

    public Roles(Long id, String roleName) {
        this.idRole = id;
        this.roleName = roleName;
    }

    public Roles(String roleName) {
        this.roleName = roleName;
    }

    //Getters and Setters

    public Long getId() {
        return idRole;
    }

    public void setId(Long id) {
        this.idRole = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + idRole +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
