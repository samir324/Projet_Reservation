package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false)
    private  String userNom;
    @Column(nullable = false)
    private  String userPrenom;
    @Column(unique = true,nullable = false)
    private  String userEmail;
    @Column(nullable = false)
    private  String userPassword;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private  Roles role;

    //Constructors

    public Users() {
    }

    public Users(String userNom, String userPrenom, String userEmail, String userPassword,Roles role) {
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
         this.role = role;
    }

    public Users(Long userId, String userNom, String userPrenom, String userEmail, String userPassword, Roles role) {
        this.userId = userId;
        this.userNom = userNom;
        this.userPrenom = userPrenom;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }

    public Users(String nom, String prenom, String email, String password, Admin admin, Apprenant apprenant, Roles roles) {
    }

    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserPrenom() {
        return userPrenom;
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = userPrenom;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userNom='" + userNom + '\'' +
                ", userPrenom='" + userPrenom + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role=" + role +
                '}';
    }
}

