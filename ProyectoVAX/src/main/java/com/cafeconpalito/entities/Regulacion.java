/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author produccion
 */
@Entity
@Table(name = "regulacion")
@NamedQueries({
    @NamedQuery(name = "Regulacion.findAll", query = "SELECT r FROM Regulacion r"),
    @NamedQuery(name = "Regulacion.findByIdregulacion21", query = "SELECT r FROM Regulacion r WHERE r.idregulacion = :idregulacion"),
    @NamedQuery(name = "Regulacion.findByRegion", query = "SELECT r FROM Regulacion r WHERE r.region = :region"),
    @NamedQuery(name = "Regulacion.findByNivel", query = "SELECT r FROM Regulacion r WHERE r.nivel = :nivel")})
public class Regulacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregulacion")
    private Integer idregulacion;
    @Column(name = "region")
    private Integer region;
    @Column(name = "nivel")
    private String nivel;
    @ManyToMany(mappedBy = "regulacionCollection")
    private Collection<Juego> juegoCollection;

    public Regulacion() {
    }

    public Regulacion(Integer idregulacion) {
        this.idregulacion = idregulacion;
    }

    public Integer getIdregulacion() {
        return idregulacion;
    }

    public void setIdregulacion(Integer idregulacion) {
        this.idregulacion = idregulacion;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregulacion != null ? idregulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regulacion)) {
            return false;
        }
        Regulacion other = (Regulacion) object;
        if ((this.idregulacion == null && other.idregulacion != null) || (this.idregulacion != null && !this.idregulacion.equals(other.idregulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.entitiDB.Regulacion[ idregulacion=" + idregulacion + " ]";
    }
    
}
