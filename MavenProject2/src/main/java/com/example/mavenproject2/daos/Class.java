package com.example.mavenproject2.daos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @Column(name = "id_class")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "monitor")
    private String monitor;

    @OneToMany(mappedBy = "aClass",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User> users;

    public Class() {
    }

    public Class(Integer id, String name, Integer amount, String monitor) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.monitor = monitor;
    }

    public Class(String name, Integer amount, String monitor) {
        this.name = name;
        this.amount = amount;
        this.monitor = monitor;
    }

    public Class(String name, Integer amount, String monitor, Set<User> users) {
        this.name = name;
        this.amount = amount;
        this.monitor = monitor;
        this.users = users;
    }

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
