/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato.IU;

/**
 *
 * @author Cristiam
 */
public class Frm_ListaJugadores extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frm_ListaJugador
     */
    public Frm_ListaJugadores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("JIMENEZ:1433;databaseName=GatoPU").createEntityManager();
        jugadores_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT j FROM Jugadores_1 j");
        jugadores_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : jugadores_1Query.getResultList();
        jPanel1 = new javax.swing.JPanel();
        Btn_Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista_juagadores = new javax.swing.JList<>();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Salir.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/BotonSalirSinTexto.png"))); // NOI18N
        Btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_SalirMouseClicked(evt);
            }
        });
        Btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icono-equipo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 300, 170));

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Lista de Jugadores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jugadores_1List, Lista_juagadores);
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(Lista_juagadores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 240, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 330));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_SalirMouseClicked

    }//GEN-LAST:event_Btn_SalirMouseClicked

    private void Btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SalirActionPerformed
      this.dispose();
    }//GEN-LAST:event_Btn_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Salir;
    private javax.swing.JList<String> Lista_juagadores;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<Gato.Logica.Jugadores_1> jugadores_1List;
    private javax.persistence.Query jugadores_1Query;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
