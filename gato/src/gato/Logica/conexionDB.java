
package Gato.Logica;

import com.sun.jndi.cosnaming.CNCtx;
import gato.IU.Frm_Jugando;
import gato.IU.Frm_NuevoJuego;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Cristiam
 */
public class conexionDB {

    Gato_Metodos Metodos = Frm_NuevoJuego.Metodos;//Instancia de la Clase  Gato_Metodos inicializada en Frm_NuevoJuego

    public static Connection Con;
    protected Statement st;
    protected ResultSet rs;

    /*
    Metodo de la conexion con la base de datos 
     */
    public void conexionDB() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.Con = DriverManager.getConnection("jdbc:sqlserver://JIMENEZ;" + "database = Gato;" + "user = sa;" + "password = Cessna123");
            this.st = Con.createStatement();
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ERROR SQL:" + e1.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    public Connection getcon() {
        return Con;
    }

    public void setCon(Connection cn) {
        this.Con = cn;
    }

    public Statement getst() {
        return st;
    }

    public void setst(Connection st) {
        this.Con = st;
    }

    /*
    Inserta al jugador 1 con todos sus atributos en la base de datos
     */
    public void InsertarJugador1() {
        try {
            st = Con.createStatement();
            st.executeUpdate("INSERT INTO dbo.Jugadores(Jugador,Ganes,Empates,Perdidas)" + "VALUES('" + Metodos.jugador1.Nombre + "','" + Metodos.jugador1.GANADOS + "','" + Metodos.jugador1.EMPATADOS + "','" + Metodos.jugador1.PERDIDOS + "')");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LA PARTIDA 1:" + e.getMessage());
        }

    }

    /*
      Inserta al jugador 2 con todos sus atributos en la base de datos
     */
    public void InsertarJugador2() {
        try {
            st = Con.createStatement();
            st.executeUpdate("INSERT INTO dbo.Jugadores(Jugador,Ganes,Empates,Perdidas)" + "VALUES('" + Metodos.jugador2.Nombre + "','" + Metodos.jugador2.GANADOS + "','" + Metodos.jugador2.EMPATADOS + "','" + Metodos.jugador2.PERDIDOS + "')");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR LA PARTIDA 2: " + e.getMessage());
        }

    }

    /*
      Actualiza al jugador 1 con todos sus atributos en la base de datos
     */
    public void ActualizarJugador1() {
        try {
            st = Con.createStatement();
            st.executeUpdate("UPDATE Jugadores SET Jugador= '" + Metodos.jugador1.Nombre + "',Ganes = Jugadores.Ganes +'" + Metodos.jugador2.GANADOS + "',Empates = Jugadores.Empates +'" + Metodos.jugador2.EMPATADOS + "',Perdidas = Jugadores.Perdidas +'" + Metodos.jugador2.PERDIDOS + "' WHERE  Jugadores.Jugador = '" + Metodos.jugador1.Nombre + "'");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LA PARTIDA 1: " + e.getMessage());
        }

    }

    /*
       Actualiza al jugador 2 con todos sus atributos en la base de datos
     */
    public void ActualizarJugador2() {
        try {
            st = Con.createStatement();
            st.executeUpdate("UPDATE Jugadores SET Jugador= '" + Metodos.jugador2.Nombre + "',Ganes = Jugadores.Ganes +'" + Metodos.jugador2.GANADOS + "',Empates = Jugadores.Empates +'" + Metodos.jugador2.EMPATADOS + "',Perdidas = Jugadores.Perdidas +'" + Metodos.jugador2.PERDIDOS + "' WHERE  Jugadores.Jugador = '" + Metodos.jugador2.Nombre + "'");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR CONEXION:" + e.getMessage());
        }

    }

    /*
    Inseta la partida que quedo pendiente en la base de datos 
     */
    public void InsertarPartida() {
        try {
            st = Con.createStatement();
            st.executeUpdate("INSERT INTO dbo.Juego(F1,F2,F3,F4,F5,F6,F7,F8,F9,Jugador1,Ganados1,Empates1,Perdidos1,Ficha1,Turno1,Jugador2,Ganados2,Empates2,Perdidos2,Ficha2,Turno2)" + "VALUES('" + Metodos.tablero[1] + "','" + Metodos.tablero[2] + "','" + Metodos.tablero[3] + "','" + Metodos.tablero[4] + "','" + Metodos.tablero[5] + "','" + Metodos.tablero[6] + "','" + Metodos.tablero[7] + "','" + Metodos.tablero[8] + "','" + Metodos.tablero[9] + "','" + Metodos.jugador1.Nombre + "','" + Metodos.jugador1.GANADOS + "','" + Metodos.jugador1.EMPATADOS + "','" + Metodos.jugador1.PERDIDOS + "','" + Frm_NuevoJuego.Jugador1 + "','" + Metodos.TurnoJ1 + "','" + Metodos.jugador2.Nombre + "','" + Metodos.jugador2.GANADOS + "','" + Metodos.jugador2.EMPATADOS + "','" + Metodos.jugador2.PERDIDOS + "','" + Frm_NuevoJuego.Jugador2 + "','" + Metodos.TurnoJ2 + "')");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSETAR LA PARTIDA:" + e.getMessage());

        }
    }

    /*
   Selecciona la partida previamente almacendada para continuar con el juego
     */
    public void Seleccionar_Partida() {
        String Jugador1, Jugador2 = "";
        int GANADOS1, EMPATADOS1, PERDIDOS1, GANADOS2, EMPATADOS2, PERDIDOS2 = 0;
        try {
            rs = st.executeQuery("SELECT * FROM Juego");
            rs.next();
            Metodos.tablero[1] = rs.getInt(1);
            Metodos.tablero[2] = rs.getInt(2);
            Metodos.tablero[3] = rs.getInt(3);
            Metodos.tablero[4] = rs.getInt(4);
            Metodos.tablero[5] = rs.getInt(5);
            Metodos.tablero[6] = rs.getInt(6);
            Metodos.tablero[7] = rs.getInt(7);
            Metodos.tablero[8] = rs.getInt(8);
            Metodos.tablero[9] = rs.getInt(9);
            Jugador1 = rs.getString(10);
            GANADOS1 = rs.getInt(11);
            EMPATADOS1 = rs.getInt(12);
            PERDIDOS1 = rs.getInt(13);
            Frm_NuevoJuego.Jugador1 = rs.getInt(14);
            Metodos.TurnoJ1 = rs.getBoolean(15);
            Jugador2 = rs.getString(16);
            GANADOS2 = rs.getInt(17);
            EMPATADOS2 = rs.getInt(18);
            PERDIDOS2 = rs.getInt(19);
            Frm_NuevoJuego.Jugador2 = rs.getInt(20);
            Metodos.TurnoJ2 = rs.getBoolean(21);
            if (Frm_NuevoJuego.Jugador1 > Frm_NuevoJuego.Jugador2) {
                Metodos.IniciarJuego(Jugador1, Jugador2, (new ImageIcon(this.getClass().getResource("/Recursos/x gato.png"))), (new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png"))));
            }
            if (Frm_NuevoJuego.Jugador1 < Frm_NuevoJuego.Jugador2) {
                Metodos.IniciarJuego(Jugador2, Jugador1, (new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png"))), (new ImageIcon(this.getClass().getResource("/Recursos/x gato.png"))));
                Metodos.jugador1.GANADOS = GANADOS1;
                Metodos.jugador1.EMPATADOS = EMPATADOS1;
                Metodos.jugador1.PERDIDOS = PERDIDOS1;
                Metodos.jugador2.GANADOS = GANADOS2;
                Metodos.jugador2.EMPATADOS = EMPATADOS2;
                Metodos.jugador2.PERDIDOS = PERDIDOS2;
                
            }

            if (Frm_NuevoJuego.Jugador1 == Frm_NuevoJuego.Jugador2) {
                Metodos.IniciarJuego(Jugador1, Jugador2, (new ImageIcon(this.getClass().getResource("/Recursos/x gato.png"))), (new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png"))));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR LA PARTIDA: " + ex.getMessage());
        }
        eliminar_Partida();
    }

    /*
    Elimina la partida que ya fue cargada en la base de datos
     */
    public void eliminar_Partida() {
        try {
            st.execute("DELETE FROM Juego");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR Al ELIMINAR LA PARTIDA : " + ex.getMessage());
        }
    }

    /*
    Buscar el jugador para verificar si ya este se encuentra almacenado
     */
    public Boolean Buscar_Jugador(String Jugador) {

        try {
            st = Con.createStatement();
            rs = st.executeQuery("SELECT*  FROM Jugadores");
            while (rs.next()) {
                if (Jugador.equals(rs.getString("Jugador"))) {
                    return true;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA BUSQUEDA:" + e.getMessage());
        }

        return false;
    }

    /*
    Actualiza los datos en la BD una vez finalizado el juego verificado si el jufador 
    ya se encontraba registrado o es un nuevo registro 
     */
    public void Actualizar_Datos() {
        conexionDB();
        if (Buscar_Jugador(Metodos.jugador1.Nombre) == true && Buscar_Jugador(Metodos.jugador2.Nombre) == true) {
            ActualizarJugador1();
            ActualizarJugador2();

        } else if (Buscar_Jugador(Metodos.jugador1.Nombre) == true && Buscar_Jugador(Metodos.jugador2.Nombre) == false) {
            ActualizarJugador1();
            InsertarJugador2();

        } else if (Buscar_Jugador(Metodos.jugador1.Nombre) == false && Buscar_Jugador(Metodos.jugador2.Nombre) == false) {
            InsertarJugador1();
            InsertarJugador2();

        } else if (Buscar_Jugador(Metodos.jugador1.Nombre) == false && Buscar_Jugador(Metodos.jugador2.Nombre) == true) {
            InsertarJugador1();
            ActualizarJugador2();

        }
    }

    /*
    Verifica en la BD si hay una partida pendiente
     */
    public boolean Buscar_Partida() throws SQLException {
        boolean x = true;
        try {
            rs = st.executeQuery("SELECT * FROM Juego");
            rs.next();
            if (rs.getRow() == 0) {
                x = false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR LA PARTIDA : " + ex.getMessage());
        }
        return x;
    }
}
