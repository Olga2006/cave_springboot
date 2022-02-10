package com.orb.caveweb.dao.entity;

import javax.persistence.*;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "is_wineproducer")
    private Boolean isWineproducer;

    @Column(name = "is_allowed_ad")
    private Boolean isAllowedAD;

    @Column(name = "is_payed")
    private Integer isPayed;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String email, String motDePasse, Boolean isWineproducer, Boolean isAllowedAD, Integer isPayed) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.isWineproducer = isWineproducer;
        this.isAllowedAD = isAllowedAD;
        this.isPayed = isPayed;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Boolean getIsWineproducer() {
        return isWineproducer;
    }

    public void setIsWineproducer(Boolean wineproducer) {
        isWineproducer = wineproducer;
    }

    public Boolean getIsAllowedAD() {
        return isAllowedAD;
    }

    public void setIsAllowedAD(Boolean allowedAD) {
        isAllowedAD = allowedAD;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

}
