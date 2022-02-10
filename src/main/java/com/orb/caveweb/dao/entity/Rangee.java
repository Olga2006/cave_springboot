package com.orb.caveweb.dao.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "rangee")
public class Rangee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference_r")
    private Integer referenceR;

    @Column(name = "id_compartiment")
    private Integer idCompartiment;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rangee")
    List<Positions> listPositions = new ArrayList<>();

    public Rangee() {
    }

    public Rangee(Integer id, Integer referenceR, Integer idCompartiment, List<Positions> listPositions) {
        this.id = id;
        this.referenceR = referenceR;
        this.idCompartiment = idCompartiment;
        this.listPositions = listPositions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferenceR() {
        return referenceR;
    }

    public void setReferenceR(Integer referenceR) {
        this.referenceR = referenceR;
    }

    public Integer getIdCompartiment() {
        return idCompartiment;
    }

    public void setIdCompartiment(Integer idCompartiment) {
        this.idCompartiment = idCompartiment;
    }

    public List<Positions> getListPositions() {
        return listPositions;
    }

    public void setListPositions(List<Positions> listPositions) {
        this.listPositions = listPositions;
    }
}
