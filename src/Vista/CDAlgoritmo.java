/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DAOOperaciones;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juan_
 */
public class CDAlgoritmo extends javax.swing.JFrame {

    /**
     * Creates new form CDAlgrotimo
     */
    DAOOperaciones BD;
    
    public CDAlgoritmo() {
        initComponents();
        BD = new DAOOperaciones();
        cargarInfo();
        
    }
    
    private void cargarInfo(){
        BD.refresh();
        algoritmosList.removeAllItems();
        for (int i=0;i<BD.getAlgoritmos().size();i++){
            algoritmosList.addItem(BD.getAlgoritmos().get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        algoritmosList = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Agregar/Eliminar Algoritmo");
        jLabel7.setToolTipText("");

        jButton1.setText("Eliminar Algoritmo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Algoritmo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algoritmosList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(algoritmosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton2)))
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = algoritmosList.getSelectedItem().toString();
        if (BD.eliminarAlgoritmo(nombre)){
                System.out.println();
                System.out.println("******************************");
                System.out.println("Se eliminio el Algoritmo "+nombre+" correctamente");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null,"Se eliminio el Algoritmo "+nombre+" correctamente");
                cargarInfo();
            }
            else{
                System.out.println();
                System.out.println("******************************");
                System.out.println("Error al eliminar el Algoritmo");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null, "Error al eliminar el Algoritmo");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try{ 
        String dir = System.getProperty("user.home") + "/Desktop/";
        JFileChooser fc = new JFileChooser(dir);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java", "JAVA");
        fc.setFileFilter(filter);
        fc.showDialog(null, "Agregar Archivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File selected = fc.getSelectedFile();
        String nombre = selected.getName().substring(0, selected.getName().length()-5);
        if (BD.agregarAlgoritmo(selected)){
                System.out.println();
                System.out.println("******************************");
                System.out.println("Se agrego el Algoritmo "+nombre+" correctamente");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null,"Se agrego el Algoritmo "+nombre+" correctamente");
                cargarInfo();
            }
            else{
                System.out.println();
                System.out.println("******************************");
                System.out.println("Error al agregar el Algoritmo");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null, "Error al agregar el Algoritmo");
            }
    }
    catch (Exception e){
        
    }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algoritmosList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
