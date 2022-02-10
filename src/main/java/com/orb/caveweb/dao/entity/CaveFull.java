package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "cave")
public class CaveFull {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "nbr_compartiment")
    private Integer nbrCompartiment;

    @Column(name = "nbr_row")
    private Integer nbrRow;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cave")
    List<Compartiment> listCompartiments = new ArrayList<>();

    public CaveFull() {
    }

    public CaveFull(Integer id, String nom, Integer idUtilisateur, Integer nbrCompartiment, Integer nbrRow, List<Compartiment> listCompartiments) {
        this.id = id;
        this.nom = nom;
        this.idUtilisateur = idUtilisateur;
        this.nbrCompartiment = nbrCompartiment;
        this.nbrRow = nbrRow;
        this.listCompartiments = listCompartiments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getNbrCompartiment() {
        return nbrCompartiment;
    }

    public void setNbrCompartiment(Integer nbrCompartiment) {
        this.nbrCompartiment = nbrCompartiment;
    }

    public Integer getNbrRow() {
        return nbrRow;
    }

    public void setNbrRow(Integer nbrRow) {
        this.nbrRow = nbrRow;
    }

    public List<Compartiment> getListCompartiments() {
        return listCompartiments;
    }

    public void setListCompartiments(List<Compartiment> listCompartiments) {
        this.listCompartiments = listCompartiments;
    }
}
