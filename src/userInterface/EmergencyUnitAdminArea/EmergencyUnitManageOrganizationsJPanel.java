/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.EmergencyUnitAdminArea;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.Organization.Type;
import business.organization.OrganizationDirectory;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sri_sai_nikhil_enni
 */
public class EmergencyUnitManageOrganizationsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmergencyUnitManageOrganizationsJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem ecosystem;
     private OrganizationDirectory organizationDirectory;
    public EmergencyUnitManageOrganizationsJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecosystem = ecosystem;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        populateCombo();
        populateTable();
    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        organizationJComboBox.addItem(Type.EmergencyDepartment);
//        organizationJComboBox.addItem(Type.AmbulanceDepartment);
//        organizationJComboBox.addItem(Type.LabDepartment);
//        organizationJComboBox.addItem(Type.PatientDepartment);
//        organizationJComboBox.addItem(Type.ReceptionistDepartment);
//        organizationJComboBox.addItem(Type.DoctorDepartment);
        }
     
      private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrgEme.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[3];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            row[2] = organization.getType().getValue();

            model.addRow(row);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrgEme = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOrgName = new javax.swing.JTextField();
        btnAddOrg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrgEme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Type"
            }
        ));
        jScrollPane2.setViewportView(tblOrgEme);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 81, 564, 155));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Organization Type :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 266, -1, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Organization Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 327, -1, 30));

        txtOrgName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrgNameActionPerformed(evt);
            }
        });
        add(txtOrgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 327, 200, 30));

        btnAddOrg.setBackground(new java.awt.Color(0, 153, 153));
        btnAddOrg.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAddOrg.setText("Add Organization");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });
        add(btnAddOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 387, 200, 32));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("EMERGENCY MANAGE ORGANIZATION ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 31));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 267, 200, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/emergencyadmin.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 880, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        // TODO add your handling code here:
      Type type = (Type) organizationJComboBox.getSelectedItem();
        
        if("".equals(txtOrgName.getText())) {
            JOptionPane.showMessageDialog(null, "Enter organization name!"); 
        }
        else {
            for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        if(organization.getType() ==  type)
                        {
                            JOptionPane.showMessageDialog(null, "Organization already Created");
                              txtOrgName.setText("");
                            return;
                        }
                    }
            
            
            
            Organization organization =  organizationDirectory.createOrganization(type,txtOrgName.getText());
            JOptionPane.showMessageDialog(null, "Organization Successfully Created");
            txtOrgName.setText("");
            populateTable();
            resetFields();
        }
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void txtOrgNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrgNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrgNameActionPerformed

      public void resetFields() {
        txtOrgName.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable tblOrgEme;
    private javax.swing.JTextField txtOrgName;
    // End of variables declaration//GEN-END:variables
}
