package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "app_erreur")
public class Erreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_id")
    private Integer id;

    @Column(name = "v_code_erreur")
    private String codeErreur;

    @Column(name = "v_txt_erreur")
    private String txtErreur;

    @Column(name = "i_id_utilisateur")
    private Integer idUtilisateur;

    public Erreur() {
    }

    public Erreur(Integer id, String codeErreur, String txtErreur, Integer idUtilisateur) {
        this.id = id;
        this.codeErreur = codeErreur;
        this.txtErreur = txtErreur;
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeErreur() {
        return codeErreur;
    }

    public void setCodeErreur(String codeErreur) {
        this.codeErreur = codeErreur;
    }

    public String getTxtErreur() {
        return txtErreur;
    }

    public void setTxtErreur(String txtErreur) {
        this.txtErreur = txtErreur;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
