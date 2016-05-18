/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gato.Logica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Cristiam
 */
@Entity
@Table(name = "Jugadores", catalog = "Gato", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Jugadores_1.findAll", query = "SELECT j FROM Jugadores_1 j"),
    @NamedQuery(name = "Jugadores_1.findByIDJugador", query = "SELECT j FROM Jugadores_1 j WHERE j.iDJugador = :iDJugador"),
    @NamedQuery(name = "Jugadores_1.findByJugador", query = "SELECT j FROM Jugadores_1 j WHERE j.jugador = :jugador"),
    @NamedQuery(name = "Jugadores_1.findByGanes", query = "SELECT j FROM Jugadores_1 j WHERE j.ganes = :ganes"),
    @NamedQuery(name = "Jugadores_1.findByPerdidas", query = "SELECT j FROM Jugadores_1 j WHERE j.perdidas = :perdidas"),
    @NamedQuery(name = "Jugadores_1.findByEmpates", query = "SELECT j FROM Jugadores_1 j WHERE j.empates = :empates")})
public class Jugadores_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Jugador")
    private Integer iDJugador;
    @Basic(optional = false)
    @Column(name = "Jugador")
    private String jugador;
    @Column(name = "Ganes")
    private Integer ganes;
    @Column(name = "Perdidas")
    private Integer perdidas;
    @Column(name = "Empates")
    private Integer empates;

    public Jugadores_1() {
    }

    public Jugadores_1(Integer iDJugador) {
        this.iDJugador = iDJugador;
    }

    public Jugadores_1(Integer iDJugador, String jugador) {
        this.iDJugador = iDJugador;
        this.jugador = jugador;
    }

    public Integer getIDJugador() {
        return iDJugador;
    }

    public void setIDJugador(Integer iDJugador) {
        Integer oldIDJugador = this.iDJugador;
        this.iDJugador = iDJugador;
        changeSupport.firePropertyChange("IDJugador", oldIDJugador, iDJugador);
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        String oldJugador = this.jugador;
        this.jugador = jugador;
        changeSupport.firePropertyChange("jugador", oldJugador, jugador);
    }

    public Integer getGanes() {
        return ganes;
    }

    public void setGanes(Integer ganes) {
        Integer oldGanes = this.ganes;
        this.ganes = ganes;
        changeSupport.firePropertyChange("ganes", oldGanes, ganes);
    }

    public Integer getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(Integer perdidas) {
        Integer oldPerdidas = this.perdidas;
        this.perdidas = perdidas;
        changeSupport.firePropertyChange("perdidas", oldPerdidas, perdidas);
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        Integer oldEmpates = this.empates;
        this.empates = empates;
        changeSupport.firePropertyChange("empates", oldEmpates, empates);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDJugador != null ? iDJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores_1)) {
            return false;
        }
        Jugadores_1 other = (Jugadores_1) object;
        if ((this.iDJugador == null && other.iDJugador != null) || (this.iDJugador != null && !this.iDJugador.equals(other.iDJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return jugador;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
