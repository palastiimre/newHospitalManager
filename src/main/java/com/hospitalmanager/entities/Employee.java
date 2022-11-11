package com.hospitalmanager.entities;

import com.hospitalmanager.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    private static final long serialVersionUID = 3821160631862423062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    @NotNull
    private String userId;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name="first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "encrypted_password")
    @NotNull
    private String encryptedPassword;

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "email_verification_status")
    @NotNull
    private boolean emailVerificationStatus = false;

    @Column(name = "role")
    @NotNull
    private UserRole role;

    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy ="employee" )
    private Collection<ClassesEmployees>classesEmployees;


}
