/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gato.Logica;

import javax.swing.ImageIcon;

/**
 *Clase de los jugadores con sus atributos y su respectivo set y get
 * @author Cristiam
 */
public class Jugadores {

    public String Nombre;
    public int GANADOS;
    public int PERDIDOS;
    public int EMPATADOS;
   public ImageIcon Imagen;
  public Jugadores( ) {}

    public Jugadores(String Nombre, ImageIcon Imagen ) {
        this.Nombre = Nombre;
        this.GANADOS = 0;
        this.PERDIDOS =0;
        this.EMPATADOS = 0;
        this.Imagen = Imagen;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setGANADOS(int GANADOS) {
        this.GANADOS = GANADOS;
    }

    public void setPERDIDOS(int PERDIDOS) {
        this.PERDIDOS = PERDIDOS;
    }

    public void setEMPATADOS(int EMPATADOS) {
        this.EMPATADOS = EMPATADOS;
    }

    public void setImagen(ImageIcon Imagen) {
        this.Imagen = Imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getGANADOS() {
        return GANADOS;
    }

    public int getPERDIDOS() {
        return PERDIDOS;
    }

    public int getEMPATADOS() {
        return EMPATADOS;
    }

    public ImageIcon getImagen() {
        return Imagen;
    }
  /*
    suma a las patidas ganadas 
    */
     public void gano(){
        GANADOS ++;
    }
     /*
      suma a las patidas Perdidas
     */ 
    public void perdio(){
        PERDIDOS ++;
    }
    /*
      suma a las patidas que empato
    */
    public void empato(){
        EMPATADOS ++;
    }
}
