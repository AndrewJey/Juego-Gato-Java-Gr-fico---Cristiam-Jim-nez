
package gato.IU;

import Gato.Logica.Gato_Metodos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Formulario para registrar un nuevo juego ya sea con nuevos judadores o los que estan almacenados en la BD 
 * y realizar la rifa de los turnos
 * @author Cristiam
 */
public class Frm_NuevoJuego extends javax.swing.JInternalFrame {

    public static Gato_Metodos Metodos = new Gato_Metodos();//Instancia de la clase Gato_Metodos()
    public static int Jugador1,Jugador2;//Almace el valor obtenido del ramdom

    public Frm_NuevoJuego() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Panel_jugador1 = new javax.swing.JPanel();
        Rdb_ListaJugador1 = new javax.swing.JRadioButton();
        Rdb_NuevoJugador1 = new javax.swing.JRadioButton();
        txt_NuevoJugador1 = new javax.swing.JTextField();
        Cbx_ListaJ1 = new javax.swing.JComboBox<>();
        Lb_rifa1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("JIMENEZ:1433;databaseName=GatoPU").createEntityManager();
        jugadores_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT j FROM Jugadores_1 j");
        jugadores_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jugadores_1Query.getResultList();
        jugadores_1Query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT j FROM Jugadores_1 j");
        jugadores_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jugadores_1Query1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        Panel_jugador2 = new javax.swing.JPanel();
        Rdb_ListaJugador2 = new javax.swing.JRadioButton();
        Rdb_NuevoJugador2 = new javax.swing.JRadioButton();
        txt_NuevoJugador2 = new javax.swing.JTextField();
        Cbx_ListaJ2 = new javax.swing.JComboBox<>();
        LB_rifa1 = new javax.swing.JLabel();
        Panel_jugador3 = new javax.swing.JPanel();
        Rdb_ListaJugador3 = new javax.swing.JRadioButton();
        Rdb_NuevoJugador3 = new javax.swing.JRadioButton();
        txt_NuevoJugador3 = new javax.swing.JTextField();
        Cbx_ListaJ3 = new javax.swing.JComboBox<>();
        LB_rifa2 = new javax.swing.JLabel();
        Btn_Jugar = new javax.swing.JLabel();
        Btn_rifa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb_Ficha1 = new javax.swing.JLabel();
        Lb_Ficha2 = new javax.swing.JLabel();
        btn_Jugar = new javax.swing.JButton();
        Btn_Salir = new javax.swing.JButton();

        Panel_jugador1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_jugador1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3), "Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        Panel_jugador1.setForeground(new java.awt.Color(0, 0, 102));

        Rdb_ListaJugador1.setBackground(new java.awt.Color(255, 255, 255));
        Rdb_ListaJugador1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_ListaJugador1.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_ListaJugador1.setText("Lista de Jugadores");
        Rdb_ListaJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_ListaJugador1ActionPerformed(evt);
            }
        });

        Rdb_NuevoJugador1.setBackground(new java.awt.Color(255, 255, 255));
        Rdb_NuevoJugador1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_NuevoJugador1.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_NuevoJugador1.setText("Nuevo Jugador");
        Rdb_NuevoJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_NuevoJugador1ActionPerformed(evt);
            }
        });

        txt_NuevoJugador1.setEnabled(false);

        Cbx_ListaJ1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        Cbx_ListaJ1.setEnabled(false);

        javax.swing.GroupLayout Panel_jugador1Layout = new javax.swing.GroupLayout(Panel_jugador1);
        Panel_jugador1.setLayout(Panel_jugador1Layout);
        Panel_jugador1Layout.setHorizontalGroup(
            Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rdb_NuevoJugador1)
                    .addComponent(Rdb_ListaJugador1))
                .addGap(18, 18, 18)
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cbx_ListaJ1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_jugador1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_NuevoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(Lb_rifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_jugador1Layout.setVerticalGroup(
            Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_jugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rdb_ListaJugador1)
                    .addComponent(Cbx_ListaJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lb_rifa1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rdb_NuevoJugador1)
                    .addComponent(txt_NuevoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_jugador2.setBackground(new java.awt.Color(255, 255, 255));
        Panel_jugador2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3), "Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        Panel_jugador2.setForeground(new java.awt.Color(0, 0, 102));
        Panel_jugador2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rdb_ListaJugador2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rdb_ListaJugador2);
        Rdb_ListaJugador2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_ListaJugador2.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_ListaJugador2.setText("Lista de Jugadores");
        Rdb_ListaJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_ListaJugador2ActionPerformed(evt);
            }
        });
        Panel_jugador2.add(Rdb_ListaJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 28, -1, -1));

        Rdb_NuevoJugador2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Rdb_NuevoJugador2);
        Rdb_NuevoJugador2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_NuevoJugador2.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_NuevoJugador2.setText("Nuevo Jugador");
        Rdb_NuevoJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_NuevoJugador2ActionPerformed(evt);
            }
        });
        Panel_jugador2.add(Rdb_NuevoJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 122, -1, -1));

        txt_NuevoJugador2.setEnabled(false);
        Panel_jugador2.add(txt_NuevoJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 125, 127, -1));

        Cbx_ListaJ2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        Cbx_ListaJ2.setEnabled(false);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jugadores_1List, Cbx_ListaJ2);
        bindingGroup.addBinding(jComboBoxBinding);

        Panel_jugador2.add(Cbx_ListaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 31, 127, -1));
        Panel_jugador2.add(LB_rifa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, 50));

        jPanel1.add(Panel_jugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 320, 170));

        Panel_jugador3.setBackground(new java.awt.Color(255, 255, 255));
        Panel_jugador3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 3), "Jugador 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Reference Sans Serif", 0, 14), new java.awt.Color(0, 51, 153))); // NOI18N
        Panel_jugador3.setForeground(new java.awt.Color(0, 0, 102));
        Panel_jugador3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rdb_ListaJugador3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(Rdb_ListaJugador3);
        Rdb_ListaJugador3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_ListaJugador3.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_ListaJugador3.setText("Lista de Jugadores");
        Rdb_ListaJugador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_ListaJugador3ActionPerformed(evt);
            }
        });
        Panel_jugador3.add(Rdb_ListaJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 28, -1, -1));

        Rdb_NuevoJugador3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(Rdb_NuevoJugador3);
        Rdb_NuevoJugador3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Rdb_NuevoJugador3.setForeground(new java.awt.Color(0, 0, 102));
        Rdb_NuevoJugador3.setText("Nuevo Jugador");
        Rdb_NuevoJugador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdb_NuevoJugador3ActionPerformed(evt);
            }
        });
        Panel_jugador3.add(Rdb_NuevoJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 122, -1, -1));

        txt_NuevoJugador3.setEnabled(false);
        Panel_jugador3.add(txt_NuevoJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 125, 131, -1));

        Cbx_ListaJ3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        Cbx_ListaJ3.setEnabled(false);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jugadores_1List1, Cbx_ListaJ3);
        bindingGroup.addBinding(jComboBoxBinding);

        Panel_jugador3.add(Cbx_ListaJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 31, 131, -1));
        Panel_jugador3.add(LB_rifa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, 50));

        jPanel1.add(Panel_jugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 320, 170));

        Btn_Jugar.setEnabled(false);
        Btn_Jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_JugarMouseClicked(evt);
            }
        });
        jPanel1.add(Btn_Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, 110));

        Btn_rifa.setBackground(new java.awt.Color(0, 51, 102));
        Btn_rifa.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        Btn_rifa.setForeground(new java.awt.Color(255, 255, 255));
        Btn_rifa.setText("Rifa");
        Btn_rifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_rifaActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_rifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("VS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));
        jPanel1.add(lb_Ficha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 90, 80));
        jPanel1.add(Lb_Ficha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 80, 80));

        btn_Jugar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Jugar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/button-play.png"))); // NOI18N
        btn_Jugar.setEnabled(false);
        btn_Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JugarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 130, 110));

        Btn_Salir.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/BotonSalirSinTexto.png"))); // NOI18N
        Btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 350));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Rdb_ListaJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_ListaJugador1ActionPerformed

    }//GEN-LAST:event_Rdb_ListaJugador1ActionPerformed

    private void Rdb_NuevoJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_NuevoJugador1ActionPerformed

    }//GEN-LAST:event_Rdb_NuevoJugador1ActionPerformed

    private void Rdb_ListaJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_ListaJugador2ActionPerformed
        txt_NuevoJugador2.enable(false);
        Cbx_ListaJ2.enable(true);
    }//GEN-LAST:event_Rdb_ListaJugador2ActionPerformed

    private void Rdb_NuevoJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_NuevoJugador2ActionPerformed
        txt_NuevoJugador2.enable(true);
        Cbx_ListaJ2.enable(false);
    }//GEN-LAST:event_Rdb_NuevoJugador2ActionPerformed

    private void Rdb_ListaJugador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_ListaJugador3ActionPerformed
        txt_NuevoJugador3.enable(false);
        Cbx_ListaJ3.enable(true);
    }//GEN-LAST:event_Rdb_ListaJugador3ActionPerformed

    private void Rdb_NuevoJugador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdb_NuevoJugador3ActionPerformed
        txt_NuevoJugador3.enable(true);
        Cbx_ListaJ3.enable(false);
    }//GEN-LAST:event_Rdb_NuevoJugador3ActionPerformed

    private void Btn_JugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_JugarMouseClicked

    }//GEN-LAST:event_Btn_JugarMouseClicked
/*
    Realiza el ramdom despues mediante desicion verifica cual de los numeros es mayor y asigna 
    al label la imagen correspindiente
    */
    private void Btn_rifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_rifaActionPerformed

        Jugador1 = (int) (Math.random() * (6 - 1) + 1);
        Jugador2 = (int) (Math.random() * (6 - 1) + 1);
        if (Jugador1 == 1) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/1.png")));
        }
        if (Jugador1 == 2) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/2.png")));
        }
        if (Jugador1 == 3) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/3.png")));
        }
        if (Jugador1 == 4) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/4.png")));
        }
        if (Jugador1 == 5) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/5.png")));
        }
        if (Jugador1 == 6) {
            LB_rifa1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/6.png")));
        }
        if (Jugador2 == 1) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/1.png")));
        }
        if (Jugador2 == 2) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/2.png")));
        }
        if (Jugador2 == 3) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/3.png")));
        }
        if (Jugador2 == 4) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/4.png")));
        }
        if (Jugador2 == 5) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/5.png")));
        }
        if (Jugador2 == 6) {
            LB_rifa2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/6.png")));
        }
        if (Jugador1 > Jugador2) {
            lb_Ficha1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/x gato.png")));
            Lb_Ficha2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png")));
            Metodos.TurnoJ1 = true;
        }
        if (Jugador1 < Jugador2) {
            Lb_Ficha2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/x gato.png")));
            lb_Ficha1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png")));
            Metodos.TurnoJ2 = true;
        }
        if (Jugador1 == Jugador2) {
            lb_Ficha1.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/x gato.png")));
            Lb_Ficha2.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Ogato.png")));
            Metodos.TurnoJ1 = true;
        }
        btn_Jugar.setEnabled(true);
        Btn_rifa.setEnabled(false);
    }//GEN-LAST:event_Btn_rifaActionPerformed
/*
    realiza las validaciones para verificar si hay algun jugador ya sea ingresado por primera vez
    o de los que se encuetran en la lista luego llamo al metodo iniciar juego donde crea cada uno de los jugadores 
    ademas de la ficha que se le asigno a cada uno
    */
    private void btn_JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JugarActionPerformed
        boolean entrar = false;//Variable que se coloca true si se agrego corectamente el jugador y las imagenes 
        ImageIcon Img1 = (ImageIcon) lb_Ficha1.getIcon();
        ImageIcon Img2 = (ImageIcon) Lb_Ficha2.getIcon();
        if (Rdb_ListaJugador2.isSelected() == false && Rdb_NuevoJugador2.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Seleccione una de las opciones del Jugagor 1 ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador3.isSelected() == false && Rdb_NuevoJugador3.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Seleccione una de las opciones del Jugagor 2 ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_NuevoJugador2.isSelected() && txt_NuevoJugador2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre del jugador 1 ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_NuevoJugador3.isSelected() && txt_NuevoJugador3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre del jugador 2", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador2.isSelected() && Cbx_ListaJ2.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No hay datos en la lista de Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador3.isSelected() && Cbx_ListaJ3.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No hay datos en la lista de Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador2.isSelected() == true && Rdb_ListaJugador3.isSelected() == true && Cbx_ListaJ2.getSelectedItem().toString().equals(Cbx_ListaJ3.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Seleccione Diferentes Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador2.isSelected() == true && Rdb_NuevoJugador3.isSelected() == true && Cbx_ListaJ2.getSelectedItem().toString().equals(txt_NuevoJugador3.getText())) {
            JOptionPane.showMessageDialog(this, "Seleccione Diferentes Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador3.isSelected() == true && Rdb_NuevoJugador2.isSelected() == true && Cbx_ListaJ3.getSelectedItem().toString().equals(txt_NuevoJugador2.getText())) {
            JOptionPane.showMessageDialog(this, "Seleccione Diferentes Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_NuevoJugador2.isSelected() == true && Rdb_NuevoJugador3.isSelected() == true && txt_NuevoJugador2.getText().equals(txt_NuevoJugador3.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese Diferentes Jugadores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (Rdb_ListaJugador2.isSelected() && Rdb_ListaJugador3.isSelected()) {
            Metodos.IniciarJuego(Cbx_ListaJ2.getSelectedItem().toString(), Cbx_ListaJ3.getSelectedItem().toString(), Img1, Img2);
            entrar = true;
        } else if (Rdb_NuevoJugador2.isSelected() && Rdb_NuevoJugador3.isSelected()) {
            Metodos.IniciarJuego(txt_NuevoJugador2.getText(), txt_NuevoJugador3.getText(), Img1, Img2);
            entrar = true;
        } else if (Rdb_ListaJugador2.isSelected() && Rdb_NuevoJugador3.isSelected()) {
            Metodos.IniciarJuego(Cbx_ListaJ2.getSelectedItem().toString(), txt_NuevoJugador3.getText(), Img1, Img2);
            entrar = true;
        } else if (Rdb_ListaJugador3.isSelected() && Rdb_NuevoJugador2.isSelected()) {
            Metodos.IniciarJuego(Cbx_ListaJ3.getSelectedItem().toString(), txt_NuevoJugador2.getText(), Img1, Img2);
            entrar = true;
        }
        if (entrar == true) {
            Frm_Jugando frmPerfil = new Frm_Jugando();
            MDI_Gato.desktopPane.add(frmPerfil);
            frmPerfil.toFront();
            frmPerfil.setVisible(true);
            Metodos.EstaJugando = true;
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_JugarActionPerformed
/*
    La variable FrmEstado la coloca en fase para poder iniciar un nuevo juego y cierra el formulario actual
    */
    private void Btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirActionPerformed
        Metodos.FrmEstado = false;
        this.dispose();

    }//GEN-LAST:event_Btn_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_Jugar;
    private javax.swing.JButton Btn_Salir;
    public javax.swing.JButton Btn_rifa;
    private javax.swing.JComboBox<String> Cbx_ListaJ1;
    private javax.swing.JComboBox<String> Cbx_ListaJ2;
    private javax.swing.JComboBox<String> Cbx_ListaJ3;
    private javax.swing.JLabel LB_rifa1;
    private javax.swing.JLabel LB_rifa2;
    private javax.swing.JLabel Lb_Ficha2;
    private javax.swing.JLabel Lb_rifa1;
    private javax.swing.JPanel Panel_jugador1;
    private javax.swing.JPanel Panel_jugador2;
    private javax.swing.JPanel Panel_jugador3;
    private javax.swing.JRadioButton Rdb_ListaJugador1;
    private javax.swing.JRadioButton Rdb_ListaJugador2;
    private javax.swing.JRadioButton Rdb_ListaJugador3;
    private javax.swing.JRadioButton Rdb_NuevoJugador1;
    private javax.swing.JRadioButton Rdb_NuevoJugador2;
    private javax.swing.JRadioButton Rdb_NuevoJugador3;
    private javax.swing.JButton btn_Jugar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private java.util.List<Gato.Logica.Jugadores_1> jugadores_1List;
    private java.util.List<Gato.Logica.Jugadores_1> jugadores_1List1;
    private javax.persistence.Query jugadores_1Query;
    private javax.persistence.Query jugadores_1Query1;
    private javax.swing.JLabel lb_Ficha1;
    private javax.swing.JTextField txt_NuevoJugador1;
    private javax.swing.JTextField txt_NuevoJugador2;
    private javax.swing.JTextField txt_NuevoJugador3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
