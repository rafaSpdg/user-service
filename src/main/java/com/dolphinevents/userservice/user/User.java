package com.dolphinevents.userservice.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.Override;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
//import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name= "user_details")
public class User {
    
    public User() {

    }

    

    public User(Integer id, @Size(min = 3, message = "Event name should have at least 3 characteres") String name,
            @Past(message = "Birthdate should be in the past.") LocalDate birthdate,
            @Size(min = 3, message = "Event name should have at least 3 characteres") String address, String email,
            @NotNull String password,
            @Size(min = 9, max = 9, message = "Phone number should have exactly 9 digits") String phone) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min= 3, message= "Event name should have at least 3 characteres")
    private String name;

    @Past(message= "Birthdate should be in the past.")
    private LocalDate birthdate;

    @Size(min= 3, message= "Event name should have at least 3 characteres")
    private String address;

    @Column(unique= true)
    private String email;

    @NotNull
    @JsonIgnore
    private String password;

    @Size(min= 9, max= 9, message= "Phone number should have exactly 9 digits")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User [Id= " + id + ", Name= " + name + ", Birthdate= " + birthdate + ", Address= " + address + ", Email= " + email + ", Password= " + password + ", Phone= " + phone + "]";
    }

}
