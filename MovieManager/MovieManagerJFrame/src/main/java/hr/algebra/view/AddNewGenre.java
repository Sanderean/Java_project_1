/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package hr.algebra.view;

import hr.algebra.MovieManagerJFrame;
import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.Genre;
import hr.algebra.model.Movie;
import hr.algebra.utilities.MessageUtils;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author andru
 */
public class AddNewGenre extends javax.swing.JDialog {

    /**
     * Creates new form AddNewItem
     */
    private Repository repository;
    public AddNewGenre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initValidation();
        hideErrors();
        initRepository();
    }
    
    private List<JTextField> validationFields;
    private List<JLabel> errorLabels;

    private void initValidation() {
        validationFields = Arrays.asList(tfName
        );
        errorLabels = Arrays.asList(lbNameError
        );
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private boolean formValid() {
        hideErrors();
        boolean ok = true;
        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbNameError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel6.setText("Genre name:");

        lbNameError.setForeground(new java.awt.Color(255, 0, 0));
        lbNameError.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNameError)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameError))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void initRepository() {
        repository = RepositoryFactory.getRepository();
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if(!formValid())
        {
            return;
        }
        Genre genre = new Genre(
            tfName.getText().trim()
        );
        try {
           List<Genre> genres = repository.selectGenres();

                if(!genres.contains(genre)){
                    repository.createGenre(genre);
                    dispose();
                }
                else{
                    MessageUtils.showErrorMessage("Error", "You can not insert the duplicate");
                }
            
        } catch (Exception ex) {
            Logger.getLogger(AddNewGenre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbNameError;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
