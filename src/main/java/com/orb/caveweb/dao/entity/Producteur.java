package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "producteur")
public class Producteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "contact")
    private String contact;

    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "is_allowed_cl")
    private Boolean isAllowedCL;

    @Column(name = "url")
    private String url;

    public Producteur() {
    }

    public Producteur(Integer id, String nom, String adresse, String contact, Integer idUtilisateur, Boolean isAllowedCL, String url) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
        this.idUtilisateur = idUtilisateur;
        this.isAllowedCL = isAllowedCL;
        this.url = url;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Boolean getIsAllowedCL() {
        return isAllowedCL;
    }

    public void setIsAllowedCL(Boolean allowedCL) {
        isAllowedCL = allowedCL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
