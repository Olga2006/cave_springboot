package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "positions")
public class PositionsGet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference_p")
    private Integer referenceP;

    @Column(name = "id_rangee")
    private Integer idRangee;

    @Column(name = "id_bouteille")
    private Integer idBouteille;

    @Column(name = "full_ref_pos")
    private String fullRefPos;

    public PositionsGet() {
    }

    public PositionsGet(Integer id, Integer referenceP, Integer idRangee, Integer idBouteille, String fullRefPos) {
        this.id = id;
        this.referenceP = referenceP;
        this.idRangee = idRangee;
        this.idBouteille = idBouteille;
        this.fullRefPos = fullRefPos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferenceP() {
        return referenceP;
    }

    public void setReferenceP(Integer referenceP) {
        this.referenceP = referenceP;
    }

    public Integer getIdRangee() {
        return idRangee;
    }

    public void setIdRangee(Integer idRangee) {
        this.idRangee = idRangee;
    }

    public Integer getIdBouteille() {
        return idBouteille;
    }

    public void setIdBouteille(Integer idBouteille) {
        this.idBouteille = idBouteille;
    }

    public String getFullRefPos() {
        return fullRefPos;
    }

    public void setFullRefPos(String fullRefPos) {
        this.fullRefPos = fullRefPos;
    }
}
