package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "cave")
public class CaveGet {

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

    @Column(name = "nbr_rouge")
    private Integer nbrRouge;

    @Column(name = "nbr_blanc")
    private Integer nbrBlanc;

    @Column(name = "nbr_rose")
    private Integer nbrRose;

    @Column(name = "nbr_jaune")
    private Integer nbrJaune;

    @Column(name = "nbr_effervescent")
    private Integer nbrEffervescent;

    @Column(name = "nbr_liquoreux")
    private Integer nbrLiquoreux;

    @Column(name = "nbr_gc")
    private Integer nbrGc;

    @Column(name = "nbr_pc")
    private Integer nbrPc;

    @Column(name = "nbr_cb")
    private Integer nbrCb;

    @Column(name = "nbr_cc")
    private Integer nbrCc;

    @Column(name = "nbr_nc")
    private Integer nbrNc;

    @Column(name = "nbr_v")
    private Integer nbrV;

    @Column(name = "nbr_total")
    private Integer nbrTotal;

    @Column(name = "prix_total_actuelle")
    private Integer prixTotalActuelle;

    @Column(name = "prix_total_achat")
    private Integer prixTotalAchat;


    public CaveGet() {
    }

    public CaveGet(Integer id, String nom, Integer idUtilisateur, Integer nbrCompartiment, Integer nbrRow, Integer nbrRouge, Integer nbrBlanc, Integer nbrRose, Integer nbrJaune, Integer nbrEffervescent, Integer nbrLiquoreux, Integer nbrGc, Integer nbrPc, Integer nbrCb, Integer nbrCc, Integer nbrNc, Integer nbrV, Integer nbrTotal, Integer prixTotalActuelle, Integer prixTotalAchat) {
        this.id = id;
        this.nom = nom;
        this.idUtilisateur = idUtilisateur;
        this.nbrCompartiment = nbrCompartiment;
        this.nbrRow = nbrRow;
        this.nbrRouge = nbrRouge;
        this.nbrBlanc = nbrBlanc;
        this.nbrRose = nbrRose;
        this.nbrJaune = nbrJaune;
        this.nbrEffervescent = nbrEffervescent;
        this.nbrLiquoreux = nbrLiquoreux;
        this.nbrGc = nbrGc;
        this.nbrPc = nbrPc;
        this.nbrCb = nbrCb;
        this.nbrCc = nbrCc;
        this.nbrNc = nbrNc;
        this.nbrV = nbrV;
        this.nbrTotal = nbrTotal;
        this.prixTotalActuelle = prixTotalActuelle;
        this.prixTotalAchat = prixTotalAchat;
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

    public Integer getNbrRouge() {
        return nbrRouge;
    }

    public void setNbrRouge(Integer nbrRouge) {
        this.nbrRouge = nbrRouge;
    }

    public Integer getNbrBlanc() {
        return nbrBlanc;
    }

    public void setNbrBlanc(Integer nbrBlanc) {
        this.nbrBlanc = nbrBlanc;
    }

    public Integer getNbrRose() {
        return nbrRose;
    }

    public void setNbrRose(Integer nbrRose) {
        this.nbrRose = nbrRose;
    }

    public Integer getNbrJaune() {
        return nbrJaune;
    }

    public void setNbrJaune(Integer nbrJaune) {
        this.nbrJaune = nbrJaune;
    }

    public Integer getNbrEffervescent() {
        return nbrEffervescent;
    }

    public void setNbrEffervescent(Integer nbrEffervescent) {
        this.nbrEffervescent = nbrEffervescent;
    }

    public Integer getNbrLiquoreux() {
        return nbrLiquoreux;
    }

    public void setNbrLiquoreux(Integer nbrLiquoreux) {
        this.nbrLiquoreux = nbrLiquoreux;
    }

    public Integer getNbrGc() {
        return nbrGc;
    }

    public void setNbrGc(Integer nbrGc) {
        this.nbrGc = nbrGc;
    }

    public Integer getNbrPc() {
        return nbrPc;
    }

    public void setNbrPc(Integer nbrPc) {
        this.nbrPc = nbrPc;
    }

    public Integer getNbrCb() {
        return nbrCb;
    }

    public void setNbrCb(Integer nbrCb) {
        this.nbrCb = nbrCb;
    }

    public Integer getNbrCc() {
        return nbrCc;
    }

    public void setNbrCc(Integer nbrCc) {
        this.nbrCc = nbrCc;
    }

    public Integer getNbrNc() {
        return nbrNc;
    }

    public void setNbrNc(Integer nbrNc) {
        this.nbrNc = nbrNc;
    }

    public Integer getNbrV() {
        return nbrV;
    }

    public void setNbrV(Integer nbrV) {
        this.nbrV = nbrV;
    }

    public Integer getNbrTotal() {
        return nbrTotal;
    }

    public void setNbrTotal(Integer nbrTotal) {
        this.nbrTotal = nbrTotal;
    }

    public Integer getPrixTotalActuelle() {
        return prixTotalActuelle;
    }

    public void setPrixTotalActuelle(Integer prixTotalActuelle) {
        this.prixTotalActuelle = prixTotalActuelle;
    }

    public Integer getPrixTotalAchat() {
        return prixTotalAchat;
    }

    public void setPrixTotalAchat(Integer prixTotalAchat) {
        this.prixTotalAchat = prixTotalAchat;
    }
}
