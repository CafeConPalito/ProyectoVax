/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author produccion
 */
@Entity
@Table(name = "juego")
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
    @NamedQuery(name = "Juego.findByIdjuego", query = "SELECT j FROM Juego j WHERE j.idjuego = :idjuego"),
    @NamedQuery(name = "Juego.findByTitulo", query = "SELECT j FROM Juego j WHERE j.titulo = :titulo"),
    @NamedQuery(name = "Juego.findByImagen", query = "SELECT j FROM Juego j WHERE j.imagen = :imagen"),
    @NamedQuery(name = "Juego.findByFecha", query = "SELECT j FROM Juego j WHERE j.fecha = :fecha"),
    @NamedQuery(name = "Juego.findByNumdescargas", query = "SELECT j FROM Juego j WHERE j.numdescargas = :numdescargas"),
    @NamedQuery(name = "Juego.findByPrecio", query = "SELECT j FROM Juego j WHERE j.precio = :precio"),
    //PARA VER LOS JUEGOS QUE TIENE EL USUARIO en su biblioteca
    //@NamedQuery(name = "Juego.findJuegoTieneUsuario", query = "SELECT j FROM Juego j INNER JOIN Biblioteca b USING (idjuego) INNER JOIN Usuario u USING (idusuario) WHERE u.idusuario = :idusuario"),
    //PARA VER LOS JUEGOS QUE NO TIENE EL USUARIO 
    //QUEDA COMPROBAR!
    //@NamedQuery(name = "Juego.findJuegoNoTieneUsuario", query = "SELECT j FROM Juego j LEFT JOIN Biblioteca b USING (idjuego) INNER JOIN Usuario u USING (idusuario) WHERE u.idusuario = :idusuario")    
})

public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjuego")
    private Integer idjuego;
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "numdescargas")
    private Integer numdescargas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @JoinTable(name = "regulacion_juego", joinColumns = {
        @JoinColumn(name = "idjuego", referencedColumnName = "idjuego")}, inverseJoinColumns = {
        @JoinColumn(name = "idregulacion", referencedColumnName = "idregulacion")})
    @ManyToMany
    private Collection<Regulacion> regulacionCollection;
    @JoinTable(name = "juego_genero", joinColumns = {
        @JoinColumn(name = "idjuego", referencedColumnName = "idjuego")}, inverseJoinColumns = {
        @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")})
    @ManyToMany
    private Collection<Genero> generoCollection;
    @OneToMany(mappedBy = "idjuego")
    private Collection<Biblioteca> bibliotecaCollection;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public Juego() {
    }

    public Juego(Integer idjuego) {
        this.idjuego = idjuego;
    }

    public Integer getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(Integer idjuego) {
        this.idjuego = idjuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumdescargas() {
        return numdescargas;
    }

    public void setNumdescargas(Integer numdescargas) {
        this.numdescargas = numdescargas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Collection<Regulacion> getRegulacionCollection() {
        return regulacionCollection;
    }

    public void setRegulacionCollection(Collection<Regulacion> regulacionCollection) {
        this.regulacionCollection = regulacionCollection;
    }

    public Collection<Genero> getGeneroCollection() {
        return generoCollection;
    }

    public void setGeneroCollection(Collection<Genero> generoCollection) {
        this.generoCollection = generoCollection;
    }

    public Collection<Biblioteca> getBibliotecaCollection() {
        return bibliotecaCollection;
    }

    public void setBibliotecaCollection(Collection<Biblioteca> bibliotecaCollection) {
        this.bibliotecaCollection = bibliotecaCollection;
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
        hash += (idjuego != null ? idjuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.idjuego == null && other.idjuego != null) || (this.idjuego != null && !this.idjuego.equals(other.idjuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cafeconpalito.entitiDB.Juego[ idjuego=" + idjuego + " ]";
    }
    
}
