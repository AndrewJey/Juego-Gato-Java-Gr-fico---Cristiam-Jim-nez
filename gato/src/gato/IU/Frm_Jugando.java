
package gato.IU;

import Gato.Logica.Gato_Metodos;
import Gato.Logica.conexionDB;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *Formulario de juego donde se llama a los diferentes metodos para realizar las validaciones
 * @author Cristiam
 */
public class Frm_Jugando extends javax.swing.JInternalFrame {

    public static conexionDB cone = new conexionDB();//Instancia de la Clase Conexion
    Gato_Metodos Metodos = Frm_NuevoJuego.Metodos;//Instancia de la Clase Gato_Metodos Iniciada en la Clase Frm_NuevoJuego

    /*
    Metodo que se utiliza si se va a cargar una partida almacenda donde verifica el varlor en cada campo de la matriz
    para mostrar la imagen correspondiente a cada ficha
    */
    public void Cargar_Tablero() {
            if (Metodos.tablero[1] == 1) {
                F1.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[2] == 1) {
                F2.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[3] == 1) {
                F3.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[4] == 1) {
                F4.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[5] == 1) {
                F5.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[6] == 1) {
                F6.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[7] == 1) {
                F1.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[8] == 1) {
                F8.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[9] == 1) {
                F9.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[1] == 2) {
                F1.setIcon(Metodos.jugador2.Imagen);
            }
            if (Metodos.tablero[2] == 2) {
                F2.setIcon(Metodos.jugador2.Imagen);
            }
            if (Metodos.tablero[3] == 2) {
                F3.setIcon(Metodos.jugador2.Imagen);
            }
             if (Metodos.tablero[4] == 2) {
                F4.setIcon(Metodos.jugador1.Imagen);
            }
            if (Metodos.tablero[5] == 2) {
                F5.setIcon(Metodos.jugador2.Imagen);
            }
            if (Metodos.tablero[6] == 2) {
                F6.setIcon(Metodos.jugador2.Imagen);
            }
             if (Metodos.tablero[7] == 2) {
                F7.setIcon(Metodos.jugador2.Imagen);
            }
            if (Metodos.tablero[8] == 2) {
                F8.setIcon(Metodos.jugador2.Imagen);
            }
            if (Metodos.tablero[9] == 2) {
                F9.setIcon(Metodos.jugador2.Imagen);
            }
               Metodos.EstaJugando = true;
    }
/*
    Limpia mediate un ciclo el arreglo y la imagen de cada label
    */
    public void LimpiarTablero() {
        for (int i = 0; i < Metodos.tablero.length; i++) {
            Metodos.tablero[i] = 0;
        }
        F1.setIcon(null);
        F2.setIcon(null);
        F6.setIcon(null);
        F4.setIcon(null);
        F5.setIcon(null);
        F3.setIcon(null);
        F7.setIcon(null);
        F8.setIcon(null);
        F9.setIcon(null);
        Metodos.Termino = false;

    }
/*
    Carga los datos almacenados en cada uno de los jugadores de la estadistica actual del juego
    */
    public void CargarPantalla() {
        LbJugador1.setText(Metodos.jugador1.Nombre);
        LbJugador2.setText(Metodos.jugador2.Nombre);
        Lb_FichaJ1.setIcon(Metodos.jugador1.Imagen);
        Lb_FichaJ2.setIcon(Metodos.jugador2.Imagen);
        Lb_ganados1.setText(Integer.toString(Metodos.jugador1.GANADOS));
        Lb_empatados1.setText(Integer.toString(Metodos.jugador1.EMPATADOS));
        Lb_perdidos1.setText(Integer.toString(Metodos.jugador1.PERDIDOS));
        Lb_ganados2.setText(Integer.toString(Metodos.jugador2.GANADOS));
        Lb_empatados2.setText(Integer.toString(Metodos.jugador2.EMPATADOS));
        Lb_perdidos2.setText(Integer.toString(Metodos.jugador2.PERDIDOS));

    }
/*
    
    */
    public void TurnoDe() {
        if (Metodos.TurnoJ1 == true) {
            Lb_Mensaje.setText("TURNO DE: " + Metodos.jugador1.Nombre);
        } else if (Metodos.TurnoJ2 == true) {
            {
                Lb_Mensaje.setText("TURNO DE: " + Metodos.jugador2.Nombre);
            }
        }
    }

    public void Jugada(JLabel ficha) {
        int campo = 0;
        if (Metodos.Termino) {
            LimpiarTablero();
            TurnoDe();
            return;
        }

        campo = Integer.parseInt("" + ficha.getName().charAt(1));
        if (Metodos.tablero[campo] == 0) {
            if (Metodos.TurnoJ1) {
                Metodos.tablero[campo] = Metodos.JUGADOR1;
            } else if (Metodos.TurnoJ2) {
                Metodos.tablero[campo] = Metodos.JUGADOR2;
            }
            Metodos.Ficha(ficha);

            if (Metodos.verificar() != 0) {
                if (Metodos.verificar() == 1) {
                    Metodos.jugador1.gano();
                    Metodos.jugador2.perdio();
                    Lb_Mensaje.setText("Ganó " + Metodos.jugador1.Nombre);
                    Metodos.Termino = true;
                    Metodos.TurnoJ1 = true;
                    Metodos.TurnoJ2 = false;
                    CargarPantalla();
                    return;
                } else {
                    Metodos.jugador2.gano();
                    Metodos.jugador1.perdio();
                    Lb_Mensaje.setText("Ganó " + Metodos.jugador2.Nombre);
                    Metodos.Termino = true;
                    Metodos.TurnoJ1 = false;
                    Metodos.TurnoJ2 = true;
                    CargarPantalla();
                    return;
                }
            } else if (Metodos.TableroLleno()) {
                Metodos.jugador1.empato();
                Metodos.jugador2.empato();
                Lb_Mensaje.setText("Empate");
                Metodos.Termino = true;
                CargarPantalla();
                return;
            }
            TurnoDe();

        }
    }

    public Frm_Jugando() {
        initComponents();
        if (Metodos.jugador1.Nombre != "") {
            Cargar_Tablero();
        }
        CargarPantalla();
        TurnoDe();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Juego = new javax.swing.JPanel();
        Panel_jugador1 = new javax.swing.JPanel();
        LbJugador1 = new javax.swing.JLabel();
        lblGanados1 = new javax.swing.JLabel();
        lblEmpatados1 = new javax.swing.JLabel();
        lblPerdidos1 = new javax.swing.JLabel();
        Lb_ganados1 = new javax.swing.JLabel();
        Lb_empatados1 = new javax.swing.JLabel();
        Lb_perdidos1 = new javax.swing.JLabel();
        Lb_FichaJ1 = new javax.swing.JLabel();
        Lb_FichaJ2 = new javax.swing.JLabel();
        F1 = new javax.swing.JLabel();
        F2 = new javax.swing.JLabel();
        F3 = new javax.swing.JLabel();
        F4 = new javax.swing.JLabel();
        F5 = new javax.swing.JLabel();
        F6 = new javax.swing.JLabel();
        F9 = new javax.swing.JLabel();
        F8 = new javax.swing.JLabel();
        F7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Panel_jugador2 = new javax.swing.JPanel();
        LbJugador2 = new javax.swing.JLabel();
        lblGanados2 = new javax.swing.JLabel();
        lblEmpatados2 = new javax.swing.JLabel();
        lblPerdidos2 = new javax.swing.JLabel();
        Lb_ganados2 = new javax.swing.JLabel();
        Lb_empatados2 = new javax.swing.JLabel();
        Lb_perdidos2 = new javax.swing.JLabel();
        Lb_Mensaje = new javax.swing.JLabel();
        Btn_SalirJuego = new javax.swing.JButton();
        Lb_FichaJ3 = new javax.swing.JLabel();

        Panel_Juego.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Juego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_jugador1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_jugador1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3), "Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        Panel_jugador1.setForeground(new java.awt.Color(0, 0, 102));

        LbJugador1.setBackground(new java.awt.Color(0, 51, 153));
        LbJugador1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        LbJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGanados1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblGanados1.setForeground(new java.awt.Color(0, 0, 102));
        lblGanados1.setText("Ganados:");

        lblEmpatados1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblEmpatados1.setForeground(new java.awt.Color(0, 0, 102));
        lblEmpatados1.setText("Empatados:");

        lblPerdidos1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblPerdidos1.setForeground(new java.awt.Color(0, 0, 102));
        lblPerdidos1.setText("Perdidos:");

        Lb_ganados1.setBackground(new java.awt.Color(0, 51, 153));
        Lb_ganados1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_ganados1.setForeground(new java.awt.Color(0, 0, 102));

        Lb_empatados1.setBackground(new java.awt.Color(0, 51, 153));
        Lb_empatados1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_empatados1.setForeground(new java.awt.Color(0, 0, 102));

        Lb_perdidos1.setBackground(new java.awt.Color(0, 51, 153));
        Lb_perdidos1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_perdidos1.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout Panel_jugador1Layout = new javax.swing.GroupLayout(Panel_jugador1);
        Panel_jugador1.setLayout(Panel_jugador1Layout);
        Panel_jugador1Layout.setHorizontalGroup(
            Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_jugador1Layout.createSequentialGroup()
                        .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                                .addComponent(lblPerdidos1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_perdidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                                .addComponent(lblGanados1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_ganados1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                                .addComponent(lblEmpatados1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_empatados1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_jugador1Layout.setVerticalGroup(
            Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(LbJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_ganados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmpatados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_empatados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerdidos1)
                    .addComponent(Lb_perdidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Panel_Juego.add(Panel_jugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 240, 170));
        Panel_Juego.add(Lb_FichaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 70, 60));
        Panel_Juego.add(Lb_FichaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, -1, -1));

        F1.setBackground(new java.awt.Color(255, 255, 255));
        F1.setForeground(new java.awt.Color(153, 0, 0));
        F1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F1.setName("p1"); // NOI18N
        F1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F1MouseClicked(evt);
            }
        });
        Panel_Juego.add(F1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 70, 60));

        F2.setBackground(new java.awt.Color(255, 255, 255));
        F2.setForeground(new java.awt.Color(153, 0, 0));
        F2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F2.setName("p2"); // NOI18N
        F2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F2MouseClicked(evt);
            }
        });
        Panel_Juego.add(F2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 70, 60));

        F3.setBackground(new java.awt.Color(255, 255, 255));
        F3.setForeground(new java.awt.Color(153, 0, 0));
        F3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F3.setName("p3"); // NOI18N
        F3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F3MouseClicked(evt);
            }
        });
        Panel_Juego.add(F3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 70, 60));

        F4.setBackground(new java.awt.Color(255, 255, 255));
        F4.setForeground(new java.awt.Color(153, 0, 0));
        F4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F4.setName("p4"); // NOI18N
        F4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F4MouseClicked(evt);
            }
        });
        Panel_Juego.add(F4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 70, 60));

        F5.setBackground(new java.awt.Color(255, 255, 255));
        F5.setForeground(new java.awt.Color(153, 0, 0));
        F5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F5.setName("p5"); // NOI18N
        F5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F5MouseClicked(evt);
            }
        });
        Panel_Juego.add(F5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 60, 60));

        F6.setBackground(new java.awt.Color(102, 0, 255));
        F6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F6.setName("p6"); // NOI18N
        F6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F6MouseClicked(evt);
            }
        });
        Panel_Juego.add(F6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 70, 60));

        F9.setBackground(new java.awt.Color(255, 255, 255));
        F9.setForeground(new java.awt.Color(153, 0, 0));
        F9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F9.setName("p9"); // NOI18N
        F9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F9MouseClicked(evt);
            }
        });
        Panel_Juego.add(F9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 70, 60));

        F8.setBackground(new java.awt.Color(255, 255, 255));
        F8.setForeground(new java.awt.Color(153, 0, 0));
        F8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F8.setName("p8"); // NOI18N
        F8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F8MouseClicked(evt);
            }
        });
        Panel_Juego.add(F8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 80, 60));

        F7.setBackground(new java.awt.Color(255, 255, 255));
        F7.setForeground(new java.awt.Color(153, 0, 0));
        F7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        F7.setName("p7"); // NOI18N
        F7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                F7MouseClicked(evt);
            }
        });
        Panel_Juego.add(F7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 70, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tablero gato.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        Panel_Juego.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 270, 260));

        Panel_jugador2.setBackground(new java.awt.Color(255, 255, 255));
        Panel_jugador2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3), "Jugador 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        Panel_jugador2.setForeground(new java.awt.Color(0, 0, 102));

        LbJugador2.setBackground(new java.awt.Color(0, 51, 153));
        LbJugador2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        LbJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGanados2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblGanados2.setForeground(new java.awt.Color(0, 0, 102));
        lblGanados2.setText("Ganados:");

        lblEmpatados2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblEmpatados2.setForeground(new java.awt.Color(0, 0, 102));
        lblEmpatados2.setText("Empatados:");

        lblPerdidos2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lblPerdidos2.setForeground(new java.awt.Color(0, 0, 102));
        lblPerdidos2.setText("Perdidos:");

        Lb_ganados2.setBackground(new java.awt.Color(0, 51, 153));
        Lb_ganados2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_ganados2.setForeground(new java.awt.Color(0, 0, 102));

        Lb_empatados2.setBackground(new java.awt.Color(0, 51, 153));
        Lb_empatados2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_empatados2.setForeground(new java.awt.Color(0, 0, 102));

        Lb_perdidos2.setBackground(new java.awt.Color(0, 51, 153));
        Lb_perdidos2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Lb_perdidos2.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout Panel_jugador2Layout = new javax.swing.GroupLayout(Panel_jugador2);
        Panel_jugador2.setLayout(Panel_jugador2Layout);
        Panel_jugador2Layout.setHorizontalGroup(
            Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_jugador2Layout.createSequentialGroup()
                        .addGroup(Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_jugador2Layout.createSequentialGroup()
                                .addComponent(lblPerdidos2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_perdidos2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_jugador2Layout.createSequentialGroup()
                                .addComponent(lblGanados2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_ganados2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_jugador2Layout.createSequentialGroup()
                                .addComponent(lblEmpatados2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lb_empatados2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_jugador2Layout.setVerticalGroup(
            Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador2Layout.createSequentialGroup()
                .addComponent(LbJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_ganados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmpatados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lb_empatados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Panel_jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerdidos2)
                    .addComponent(Lb_perdidos2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Panel_Juego.add(Panel_jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, 170));

        Lb_Mensaje.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        Lb_Mensaje.setForeground(new java.awt.Color(0, 0, 153));
        Lb_Mensaje.setText("TUrno de :");
        Panel_Juego.add(Lb_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 260, 20));

        Btn_SalirJuego.setBackground(new java.awt.Color(255, 255, 255));
        Btn_SalirJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/BotonSalirSinTexto.png"))); // NOI18N
        Btn_SalirJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalirJuegoActionPerformed(evt);
            }
        });
        Panel_Juego.add(Btn_SalirJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 30, 30));
        Panel_Juego.add(Lb_FichaJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Juego, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Juego, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void F1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F1MouseClicked
        Jugada(F1);
    }//GEN-LAST:event_F1MouseClicked

    private void F2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F2MouseClicked
        Jugada(F2);
    }//GEN-LAST:event_F2MouseClicked

    private void F3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F3MouseClicked
        Jugada(F3);
    }//GEN-LAST:event_F3MouseClicked

    private void F4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F4MouseClicked
        Jugada(F4);
    }//GEN-LAST:event_F4MouseClicked

    private void F5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F5MouseClicked
        Jugada(F5);
    }//GEN-LAST:event_F5MouseClicked

    private void F6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F6MouseClicked
        Jugada(F6);
    }//GEN-LAST:event_F6MouseClicked

    private void F9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F9MouseClicked
        Jugada(F9);
    }//GEN-LAST:event_F9MouseClicked

    private void F8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F8MouseClicked
        Jugada(F8);
    }//GEN-LAST:event_F8MouseClicked

    private void F7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F7MouseClicked
        Jugada(F7);
    }//GEN-LAST:event_F7MouseClicked

    private void Btn_SalirJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirJuegoActionPerformed
        Metodos.SalirGuardar();
      Metodos.FrmEstado = false;
        LimpiarTablero();
        this.dispose();
    }//GEN-LAST:event_Btn_SalirJuegoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_SalirJuego;
    private javax.swing.JLabel F1;
    private javax.swing.JLabel F2;
    private javax.swing.JLabel F3;
    private javax.swing.JLabel F4;
    private javax.swing.JLabel F5;
    private javax.swing.JLabel F6;
    private javax.swing.JLabel F7;
    private javax.swing.JLabel F8;
    private javax.swing.JLabel F9;
    private javax.swing.JLabel LbJugador1;
    private javax.swing.JLabel LbJugador2;
    private javax.swing.JLabel Lb_FichaJ1;
    private javax.swing.JLabel Lb_FichaJ2;
    private javax.swing.JLabel Lb_FichaJ3;
    public javax.swing.JLabel Lb_Mensaje;
    private javax.swing.JLabel Lb_empatados1;
    private javax.swing.JLabel Lb_empatados2;
    private javax.swing.JLabel Lb_ganados1;
    private javax.swing.JLabel Lb_ganados2;
    private javax.swing.JLabel Lb_perdidos1;
    private javax.swing.JLabel Lb_perdidos2;
    public javax.swing.JPanel Panel_Juego;
    private javax.swing.JPanel Panel_jugador1;
    private javax.swing.JPanel Panel_jugador2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEmpatados1;
    private javax.swing.JLabel lblEmpatados2;
    private javax.swing.JLabel lblGanados1;
    private javax.swing.JLabel lblGanados2;
    private javax.swing.JLabel lblPerdidos1;
    private javax.swing.JLabel lblPerdidos2;
    // End of variables declaration//GEN-END:variables
}
