/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato.IU;

import Gato.Logica.Gato_Metodos;
import Gato.Logica.conexionDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristiam
 */
public class MDI_Gato extends javax.swing.JFrame {

    conexionDB cone = new conexionDB();
    Gato_Metodos Metodos = Frm_NuevoJuego.Metodos;
 

    private void close(){
       Metodos.SalirGuardar();
            System.exit(0);
    }  
    public MDI_Gato() {
       
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        Btn_NuevoJuego = new javax.swing.JMenu();
        Btn_Estadistica = new javax.swing.JMenu();
        Btn_Salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tic_tac_toe_by_niraj.png"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 360);

        menuBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        menuBar.setMaximumSize(new java.awt.Dimension(316, 21));

        Btn_NuevoJuego.setForeground(new java.awt.Color(0, 0, 153));
        Btn_NuevoJuego.setText("Nuevo Juego");
        Btn_NuevoJuego.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Btn_NuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_NuevoJuegoMouseClicked(evt);
            }
        });
        Btn_NuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NuevoJuegoActionPerformed(evt);
            }
        });
        menuBar.add(Btn_NuevoJuego);

        Btn_Estadistica.setForeground(new java.awt.Color(0, 51, 153));
        Btn_Estadistica.setText("Estadistica Jugadores");
        Btn_Estadistica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Btn_Estadistica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_EstadisticaMouseClicked(evt);
            }
        });
        menuBar.add(Btn_Estadistica);

        Btn_Salir.setForeground(new java.awt.Color(0, 51, 153));
        Btn_Salir.setText("Salir");
        Btn_Salir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_SalirMouseClicked(evt);
            }
        });
        menuBar.add(Btn_Salir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_SalirMouseClicked
     Metodos.SalirGuardar();
 this.dispose(); 
    }//GEN-LAST:event_Btn_SalirMouseClicked

    private void Btn_EstadisticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_EstadisticaMouseClicked
        Frm_Estadistc frmEstadistica = new Frm_Estadistc();
        desktopPane.add(frmEstadistica);
        frmEstadistica.toFront();
        frmEstadistica.setVisible(true);

    }//GEN-LAST:event_Btn_EstadisticaMouseClicked

    private void Btn_NuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NuevoJuegoActionPerformed

    }//GEN-LAST:event_Btn_NuevoJuegoActionPerformed

    private void Btn_NuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_NuevoJuegoMouseClicked
      if (Metodos.FrmEstado == false ){
          cone.conexionDB();
          try {
             if (cone.Buscar_Partida()){
                  int conf = JOptionPane.showConfirmDialog(rootPane, "Existe una patida iniciada desea continuar", "Advertencia", WIDTH, HEIGHT);
                  if (JOptionPane.NO_OPTION == conf) {
                      Frm_NuevoJuego frmNuevo = new Frm_NuevoJuego();
                      desktopPane.add(frmNuevo);
                      frmNuevo.toFront();
                      frmNuevo.setVisible(true);
                      Btn_NuevoJuego.setEnabled(false);
                      Metodos.FrmEstado =true;
                      cone.eliminar_Partida();
                  } else if (conf == JOptionPane.OK_OPTION) {
                      cone.Seleccionar_Partida();
                      Frm_Jugando frmJugando = new Frm_Jugando();
                      desktopPane.add(frmJugando);
                      frmJugando.toFront();
                      frmJugando.setVisible(true);
                      Btn_NuevoJuego.setEnabled(false);
                      Metodos.FrmEstado =true;
                  }
                
             }
                  else {
                       Frm_NuevoJuego frmNuevo = new Frm_NuevoJuego();
                      desktopPane.add(frmNuevo);
                      frmNuevo.toFront();
                      frmNuevo.setVisible(true);
                      Btn_NuevoJuego.setEnabled(false);
                      Metodos.FrmEstado =true;
                  }
               } catch (SQLException ex) {
              Logger.getLogger(MDI_Gato.class.getName()).log(Level.SEVERE, null, ex);
          }
          }
    }//GEN-LAST:event_Btn_NuevoJuegoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDI_Gato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI_Gato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI_Gato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI_Gato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Gato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Btn_Estadistica;
    private javax.swing.JMenu Btn_NuevoJuego;
    private javax.swing.JMenu Btn_Salir;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
