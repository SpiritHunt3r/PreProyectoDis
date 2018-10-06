/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DaoAlfabetos;
import Modelo.Alfabeto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author juan_
 */
public class CRUDAlfabeto extends javax.swing.JFrame {

    /**
     * Creates new form AddAlfabeto
     */
    DaoAlfabetos BD;
    
    public CRUDAlfabeto() {
        initComponents();
        BD = new DaoAlfabetos();
        cargarInfo();
        
    }
    
    private void cargarInfo(){
        BD.refresh();
        List<Alfabeto> alfabetos = BD.getAlfabetos();
        alfabetosList.removeAllItems();
        for (Alfabeto alfabeto:alfabetos){
            alfabetosList.addItem(alfabeto.getNombre());
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
        alfabetoNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        alfabetoSimbolos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        alfabetosList = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("CRUD Alfabeto");
        jLabel7.setToolTipText("");

        alfabetoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetoNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese nombre del Alfabeto");

        jLabel2.setText("Ingrese simbolos del Alfabeto");

        alfabetoSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetoSimbolosActionPerformed(evt);
            }
        });

        jButton1.setText("Cargar Alfabeto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        alfabetosList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetosListActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("El simbolo ( * ) es reservado por lo que no puede existir en el Alfabeto");

        jLabel4.setText("Todo alfabeto incluye el espacio por lo que no debe ser agregado como simbolo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(26, 26, 26)))
                        .addComponent(jButton3)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alfabetoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(alfabetosList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alfabetoSimbolos))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(alfabetoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alfabetoSimbolos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(alfabetosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alfabetoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alfabetoNombreActionPerformed

    private void alfabetoSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetoSimbolosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alfabetoSimbolosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new GUI().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nombre = alfabetoNombre.getText();
        String simbolos = alfabetoSimbolos.getText();
        Alfabeto test = new Alfabeto();
        test.setNombre(nombre);
        test.setSimbolos(simbolos);
        if (BD.validar(test)){
            if(BD.agregar(test)){
                System.out.println();
                System.out.println("******************************");
                System.out.println("Se agrego el Alfabeto "+test.getNombre()+" correctamente");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null, "Se agrego el Alfabeto "+test.getNombre()+" correctamente");
                cargarInfo();
            }
            else{
                System.out.println();
                System.out.println("******************************");
                System.out.println("Error al agregar el Alfabeto");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null, "Error al agregar el Alfabeto");
            }
        }
        else{
            System.out.println();
            System.out.println("******************************");
            System.out.println("Alfabeto invalido o ya existente");
            System.out.println("******************************");
            JOptionPane.showMessageDialog(null, "Alfabeto invalido o ya existente");
        }
        
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void alfabetosListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetosListActionPerformed
        try{
        int posicion = alfabetosList.getSelectedIndex();
        alfabetoNombre.setText(BD.getAlfabetos().get(posicion).getNombre());
        alfabetoSimbolos.setText(BD.getAlfabetos().get(posicion).getSimbolos());
        }
        catch (Exception e){
            
        }
    }//GEN-LAST:event_alfabetosListActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (this.BD.getAlfabetos().size() <= 1){
            System.out.println();
            System.out.println("******************************");
            System.out.println("Error al eliminar el Alfabeto");
            System.out.println("******************************");
            JOptionPane.showMessageDialog(null, "Debe existir al menos un alfabeto");
        }
        else{
            Alfabeto test = new Alfabeto();
            test.setId(alfabetosList.getSelectedIndex());
            test.setNombre(alfabetosList.getSelectedItem().toString());
            if (BD.eliminar(test)){
                System.out.println();
                System.out.println("******************************");
                System.out.println("Se eliminio el Alfabeto "+test.getNombre()+" correctamente");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null,"Se eliminio el Alfabeto "+test.getNombre()+" correctamente");
                cargarInfo();
            }
            else{
                System.out.println();
                System.out.println("******************************");
                System.out.println("Error al eliminar el Alfabeto");
                System.out.println("******************************");
                JOptionPane.showMessageDialog(null, "Error al eliminar el Alfabeto");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nombre = alfabetoNombre.getText();
        String simbolos = alfabetoSimbolos.getText();
        Alfabeto test = new Alfabeto();
        test.setNombre(nombre);
        test.setSimbolos(simbolos);
        test.setId(alfabetosList.getSelectedIndex());
        if(BD.modificar(test)){
            System.out.println();
            System.out.println("******************************");
            System.out.println("Se modifico el Alfabeto "+test.getNombre()+" correctamente");
            System.out.println("******************************");
            JOptionPane.showMessageDialog(null, "Se modifico el Alfabeto "+test.getNombre()+" correctamente");
            cargarInfo();
        }
        else{
            System.out.println();
            System.out.println("******************************");
            System.out.println("Error al modificar el Alfabeto");
            System.out.println("******************************");
            JOptionPane.showMessageDialog(null, "Error al modificar el Alfabeto");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try{
        String dir = System.getProperty("user.home") + "/Desktop/";
        JFileChooser fc = new JFileChooser(dir);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        fc.showDialog(null, "Agregar Archivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File selected = fc.getSelectedFile();
        String Nombre = selected.getName().substring(0, selected.getName().length()-4);
        BufferedReader br = new BufferedReader(new FileReader(selected.getPath()));
        String Simbolos = br.readLine();
        this.alfabetoNombre.setText(Nombre);
        this.alfabetoSimbolos.setText(Simbolos);
    }
    catch (Exception e){
        
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alfabetoNombre;
    private javax.swing.JTextField alfabetoSimbolos;
    private javax.swing.JComboBox<String> alfabetosList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
