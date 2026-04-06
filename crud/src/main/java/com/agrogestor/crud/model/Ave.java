package com.agrogestor.crud.model;


import jakarta.persistence.*;

@Entity(name = "Ave")
@Table(name = "Ave")

public class Ave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String raca;
   private Double preco;

    public Ave() {

    }

    public Ave(int id, String raca, Double preco) {
        this.id = id;
        this.raca = raca;
        this.preco = preco;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }


}

