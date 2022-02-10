package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "cave")
public class Cave {

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

    public Cave() {
    }

    public Cave(Integer id, String nom, Integer idUtilisateur, Integer nbrCompartiment, Integer nbrRow) {
        this.id = id;
        this.nom = nom;
        this.idUtilisateur = idUtilisateur;
        this.nbrCompartiment = nbrCompartiment;
        this.nbrRow = nbrRow;
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
}
