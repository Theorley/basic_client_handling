package com.example.Billcom4.model;
import jakarta.persistence.*;

@Entity
@Table(name="client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String first_name;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cin;

    public ClientEntity(int id, String first_name, String name, String cin) {
        this.id = id;
        this.first_name = first_name;
        this.name = name;
        this.cin = cin;
    }

    public ClientEntity () {

    }

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
