package com.example.Billcom4.model;
import jakarta.persistence.*;

@Entity
@Table(name="contracts")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = true, unique = true)
    private int client_id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String status;

    public ContractEntity(Long id, int client_id, String number, String status) {
        this.id = id;
        this.client_id = client_id;
        this.number = number;
        this.status = status;
    }

    public ContractEntity (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContractEntity{" +
                "id=" + id +
                ", client_id='" + client_id + '\'' +
                ", number='" + number + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
