package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "positions")
public class Positions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference_p")
    private Integer referenceP;

    @Column(name = "id_rangee")
    private Integer idRangee;

    @Column(name = "id_bouteille", insertable = false, updatable = false)
    private Integer idBouteille;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "id_bouteille")
    private Bouteille bouteille;

    public Positions() {
    }

    public Positions(Integer id, Integer referenceP, Integer idRangee, Integer idBouteille, Bouteille bouteille) {
        this.id = id;
        this.referenceP = referenceP;
        this.idRangee = idRangee;
        this.idBouteille = idBouteille;
        this.bouteille = bouteille;
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

    public Bouteille getBouteille() {
        return bouteille;
    }

    public void setBouteille(Bouteille bouteille) {
        this.bouteille = bouteille;
    }
}
