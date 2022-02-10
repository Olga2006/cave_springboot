package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "bouteille")
public class BouteilleGet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "id_producteur")
    private Integer idProducteur;

    @Column(name = "nom_producteur", insertable = false, updatable = false)
    private String nomProducteur;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "cru")
    private String cru;

    @Column(name = "appelation")
    private String appelation;

    @Column(name = "region")
    private String region;

    @Column(name = "pays")
    private String pays;

    @Column(name = "taille")
    private Double taille;

    @Column(name = "prix_achat")
    private Double prixAchat;

    @Column(name = "prix_actuelle")
    private Double prixActuelle;

    @Column(name = "date_de_production")
    private Integer dateDeProduction;

    @Column(name = "date_garder")
    private Integer dateGarder;

    @Column(name = "image")
    private String image;

    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "nbr_list_courses")
    private Integer nbrListCourses;

    @Column(name = "evaluation")
    private Integer evaluation;

    @Column(name = "url_achat")
    private String urlAchat;

    @Column(name = "is_allowed_cl")
    private Boolean isAllowedCl;

    @Column(name = "nbr_positions", insertable = false, updatable = false)
    private Integer nbrPositions;

    public BouteilleGet() {
    }

    public BouteilleGet(Integer id, String nom, Integer idProducteur, String nomProducteur, String couleur, String cru, String appelation, String region, String pays, Double taille, Double prixAchat, Double prixActuelle, Integer dateDeProduction, Integer dateGarder, String image, Integer idUtilisateur, String commentaire, Integer nbrListCourses, Integer evaluation, String urlAchat, Boolean isAllowedCl, Integer nbrPositions) {
        this.id = id;
        this.nom = nom;
        this.idProducteur = idProducteur;
        this.nomProducteur = nomProducteur;
        this.couleur = couleur;
        this.cru = cru;
        this.appelation = appelation;
        this.region = region;
        this.pays = pays;
        this.taille = taille;
        this.prixAchat = prixAchat;
        this.prixActuelle = prixActuelle;
        this.dateDeProduction = dateDeProduction;
        this.dateGarder = dateGarder;
        this.image = image;
        this.idUtilisateur = idUtilisateur;
        this.commentaire = commentaire;
        this.nbrListCourses = nbrListCourses;
        this.evaluation = evaluation;
        this.urlAchat = urlAchat;
        this.isAllowedCl = isAllowedCl;
        this.nbrPositions = nbrPositions;
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

    public Integer getIdProducteur() {
        return idProducteur;
    }

    public void setIdProducteur(Integer idProducteur) {
        this.idProducteur = idProducteur;
    }

    public String getNomProducteur() {
        return nomProducteur;
    }

    public void setNomProducteur(String nomProducteur) {
        this.nomProducteur = nomProducteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCru() {
        return cru;
    }

    public void setCru(String cru) {
        this.cru = cru;
    }

    public String getAppelation() {
        return appelation;
    }

    public void setAppelation(String appelation) {
        this.appelation = appelation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public Double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Double getPrixActuelle() {
        return prixActuelle;
    }

    public void setPrixActuelle(Double prixActuelle) {
        this.prixActuelle = prixActuelle;
    }

    public Integer getDateDeProduction() {
        return dateDeProduction;
    }

    public void setDateDeProduction(Integer dateDeProduction) {
        this.dateDeProduction = dateDeProduction;
    }

    public Integer getDateGarder() {
        return dateGarder;
    }

    public void setDateGarder(Integer dateGarder) {
        this.dateGarder = dateGarder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNbrListCourses() {
        return nbrListCourses;
    }

    public void setNbrListCourses(Integer nbrListCourses) {
        this.nbrListCourses = nbrListCourses;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public String getUrlAchat() {
        return urlAchat;
    }

    public void setUrlAchat(String urlAchat) {
        this.urlAchat = urlAchat;
    }

    public Boolean getIsAllowedCl() {
        return this.isAllowedCl;
    }

    public void setIsAllowedCl(Boolean isAllowedCl) {
        this.isAllowedCl = isAllowedCl;
    }

    public Integer getNbrPositions() {
        return nbrPositions;
    }

    public void setNbrPositions(Integer nbrPositions) {
        this.nbrPositions = nbrPositions;
    }
}
