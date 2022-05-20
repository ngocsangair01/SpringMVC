package com.example.mavenproject2.dtos;

public class ClassDTO {
    private Integer id;
    private String name;
    private Integer amount;
    private String monitor;

    public ClassDTO() {
    }

    public ClassDTO(String name, Integer amount, String monitor) {
        this.name = name;
        this.amount = amount;
        this.monitor = monitor;
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
}
