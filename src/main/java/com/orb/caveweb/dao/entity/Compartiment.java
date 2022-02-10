package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "compartiment")
public class Compartiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference_c")
    private String referenceC;

    @Column(name = "id_cave")
    private Integer idCave;

    @Column(name = "nom")
    private String nom;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compartiment")
    List<Rangee> listRangees = new ArrayList<>();

    public Compartiment() {
    }

    public Compartiment(Integer id, String referenceC, Integer idCave, String nom, List<Rangee> listRangees) {
        this.id = id;
        this.referenceC = referenceC;
        this.idCave = idCave;
        this.nom = nom;
        this.listRangees = listRangees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceC() {
        return referenceC;
    }

    public void setReferenceC(String referenceC) {
        this.referenceC = referenceC;
    }

    public Integer getIdCave() {
        return idCave;
    }

    public void setIdCave(Integer idCave) {
        this.idCave = idCave;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Rangee> getListRangees() {
        return listRangees;
    }

    public void setListRangees(List<Rangee> listRangees) {
        this.listRangees = listRangees;
    }
}
