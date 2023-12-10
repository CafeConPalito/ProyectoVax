/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.entitiDB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author produccion
 */
@Entity
@Table(name = "biblioteca")
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @NamedQuery(name = "Biblioteca.findByIdbiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.idbiblioteca = :idbiblioteca"),
    @NamedQuery(name = "Biblioteca.findByFecha", query = "SELECT b FROM Biblioteca b WHERE b.fecha = :fecha")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbiblioteca")
    private Integer idbiblioteca;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idjuego", referencedColumnName = "idjuego")
    @ManyToOne
    private Juego idjuego;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public Biblioteca() {
    }

    public Biblioteca(Integer idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }

    public Integer getIdbiblioteca() {
        return idbiblioteca;
    }

    public void setIdbiblioteca(Integer idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Juego getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(Juego idjuego) {
        this.idjuego = idjuego;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbiblioteca != null ? idbiblioteca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.idbiblioteca == null && other.idbiblioteca != null) || (this.idbiblioteca != null && !this.idbiblioteca.equals(other.idbiblioteca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.entitiDB.Biblioteca[ idbiblioteca=" + idbiblioteca + " ]";
    }
    
}
