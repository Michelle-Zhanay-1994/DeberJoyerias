/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "joyeria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joyeria.findAll", query = "SELECT j FROM Joyeria j")
    , @NamedQuery(name = "Joyeria.findByNombre", query = "SELECT j FROM Joyeria j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Joyeria.findByUbicacion", query = "SELECT j FROM Joyeria j WHERE j.ubicacion = :ubicacion")
    , @NamedQuery(name = "Joyeria.findByDireccion", query = "SELECT j FROM Joyeria j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Joyeria.findByNombreEncargado", query = "SELECT j FROM Joyeria j WHERE j.nombreEncargado = :nombreEncargado")
    , @NamedQuery(name = "Joyeria.findByDimensionLocal", query = "SELECT j FROM Joyeria j WHERE j.dimensionLocal = :dimensionLocal")
    , @NamedQuery(name = "Joyeria.findByCiudad", query = "SELECT j FROM Joyeria j WHERE j.ciudad = :ciudad")
    , @NamedQuery(name = "Joyeria.findByIdJoyeriaLoja", query = "SELECT j FROM Joyeria j WHERE j.idJoyeriaLoja = :idJoyeriaLoja")})
public class Joyeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "nombre_encargado")
    private String nombreEncargado;
    @Column(name = "dimension_local")
    private Integer dimensionLocal;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJoyeriaLoja")
    private Integer idJoyeriaLoja;

    public Joyeria(String nombre, String ubicacion, String direccion, String nombreEncargado, Integer dimensionLocal, String ciudad, Integer idJoyeriaLoja) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nombreEncargado = nombreEncargado;
        this.dimensionLocal = dimensionLocal;
        this.ciudad = ciudad;
        this.idJoyeriaLoja = idJoyeriaLoja;
    }

    public Joyeria() {
    }

    public Joyeria(Integer idJoyeriaLoja) {
        this.idJoyeriaLoja = idJoyeriaLoja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public Integer getDimensionLocal() {
        return dimensionLocal;
    }

    public void setDimensionLocal(Integer dimensionLocal) {
        this.dimensionLocal = dimensionLocal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdJoyeriaLoja() {
        return idJoyeriaLoja;
    }

    public void setIdJoyeriaLoja(Integer idJoyeriaLoja) {
        this.idJoyeriaLoja = idJoyeriaLoja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJoyeriaLoja != null ? idJoyeriaLoja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joyeria)) {
            return false;
        }
        Joyeria other = (Joyeria) object;
        if ((this.idJoyeriaLoja == null && other.idJoyeriaLoja != null) || (this.idJoyeriaLoja != null && !this.idJoyeriaLoja.equals(other.idJoyeriaLoja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Joyeria[ idJoyeriaLoja=" + idJoyeriaLoja + " ]";
    }
    
}
