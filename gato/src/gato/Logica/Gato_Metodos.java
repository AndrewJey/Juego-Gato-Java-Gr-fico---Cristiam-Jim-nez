/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gato.Logica;

import gato.IU.Frm_Jugando;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Clase que almacena los metodos que se van a utilizar
 *
 * @author Cristiam
 */
public class Gato_Metodos {

    Statement s;
    public final int JUGADOR1 = 1;//Variable con el numero asignado a cada jugador
    public final int JUGADOR2 = 2;
    public boolean TurnoJ1, TurnoJ2, Termino = false;//Verifica el estado de cada jugador 
    public Jugadores jugador1, jugador2;//Creo jugador 1 y 2 con los atributos de jugador
    public int[] tablero = new int[10];//Arreglo de 10 indices
    public boolean EstaJugando = false;//Booleana utilizada para validaciones segun su estado 
    public boolean FrmEstado = false;//Verificar el estado si hay un formulario abierto

    /*
     * Verifica por medio de desiciones quien gano y retorna el valor del
     * arreglo del Jugador ganador
     *
     * @return
     */
    public int verificar() {
        if (tablero[1] == tablero[2] && tablero[1] == tablero[3] && tablero[1] != 0) {
            return tablero[1];
        } else if (tablero[4] == tablero[5] && tablero[4] == tablero[6] && tablero[4] != 0) {
            return tablero[4];
        } else if (tablero[7] == tablero[8] && tablero[7] == tablero[9] && tablero[7] != 0) {
            return tablero[7];
        } else if (tablero[1] == tablero[4] && tablero[1] == tablero[7] && tablero[1] != 0) {
            return tablero[1];
        } else if (tablero[2] == tablero[5] && tablero[2] == tablero[8] && tablero[2] != 0) {
            return tablero[2];
        } else if (tablero[3] == tablero[6] && tablero[3] == tablero[9] && tablero[3] != 0) {
            return tablero[3];
        } else if (tablero[3] == tablero[5] && tablero[3] == tablero[7] && tablero[3] != 0) {
            return tablero[3];
        } else if (tablero[1] == tablero[5] && tablero[1] == tablero[9] && tablero[1] != 0) {
            return tablero[1];
        }
        return 0;
    }

    /*
     * Metodo que resive los parametros del nuevo jugador y crear el jugador 1 y
     * 2 de la clase Jugador.
     *
     * @param Nombre1
     * @param Nombre2
     * @param Im1
     * @param Im2
     */
    public void IniciarJuego(String Nombre1, String Nombre2, ImageIcon Im1, ImageIcon Im2) {
        this.jugador1 = new Jugadores(Nombre1, Im1);
        this.jugador2 = new Jugadores(Nombre2, Im2);

    }

    /*
     * Verifica si el tablero esta lleno y retorna una boolenana con true de
     * estarlo
     *
     * @return
     */
    public boolean TableroLleno() {
        boolean resultado = true;
        for (int i = 1; i < tablero.length; i++) {
            if (tablero[i] == 0) {
                resultado = false;
            }
        }
        return resultado;
    }
/*
 * Verifica si en el arreglo del table hay un 1 o 2 de ser asi significa que hay una partida iniciada
 * @return 
 */
    public boolean Partida_Iniciada() {
        boolean resultado = false;
        for (int i = 1; i < tablero.length; i++) {
            if (tablero[i] == 2 || tablero[i] == 1) {
                resultado = true;
            }
        }
        return resultado;
    }
/*
 * Metodo de tipo void que se le envia el parametro un jlabel con la ficha del jugador para mostar la imagen en el jlabel correspodiente
 * @param ficha 
 */
    public void Ficha(JLabel ficha) {
        if (TurnoJ1) {
            ficha.setIcon(jugador1.Imagen);
            TurnoJ1 = false;
            TurnoJ2 = true;
        } else if (TurnoJ2) {
            ficha.setIcon(jugador2.Imagen);
            TurnoJ1 = true;
            TurnoJ2 = false;

        }

    }
/**
 * Vefica cual de los jugadores tiene mayor cantidad de partidas ganadas o empatadas para mostrar el mensaje del ganador
 * o empate, vefirica si hay una partida inicidad y consulta si desea guardarla 
 */
    public void SalirGuardar() {
        if (EstaJugando) {
            if (jugador1.GANADOS > jugador2.GANADOS) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar este juego, el ganador fue " + jugador1.Nombre + " con " + jugador1.GANADOS + " Partidas Ganadas");

            }
            if (jugador2.GANADOS > jugador1.GANADOS) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar este juego, el ganador fue " + jugador2.Nombre + " con " + jugador2.GANADOS + " Partidas Ganadas");
            }
            if (jugador2.GANADOS == jugador1.GANADOS && jugador2.GANADOS != 0) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar este juego, hubo empate entre " + jugador1.Nombre + " y " + jugador2.Nombre);
            }
            Frm_Jugando.cone.Actualizar_Datos();

            if (Partida_Iniciada()) {
                boolean n = (JOptionPane.showConfirmDialog(null, "¿Desea Guardar la partida Iniciada?", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
                if (n == true) {
                    Frm_Jugando.cone.InsertarPartida();
                }
            }
        }
    }

}
