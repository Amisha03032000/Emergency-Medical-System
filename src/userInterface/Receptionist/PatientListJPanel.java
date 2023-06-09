/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.Receptionist;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.medicalEmployment.Doctor;
import business.medicalEmployment.DoctorList;
import business.medicalEmployment.Patient;
import business.medicalEmployment.PatientList;
import business.network.Network;
import business.organization.DoctorOrganization;
import business.organization.Organization;
import business.organization.PatientOrganization;
import business.userAccount.UserAccount;
import business.workQueue.DoctorWorkRequest;
import business.workQueue.WorkRequest;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

import userInterface.Patient.PatientWorkAreaJPanel;
import userInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *s

 * @author amisha03
 */
public class PatientListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientListJPanel
     */
    PatientList patientList;
    DoctorList doctorList;
    EcoSystem ecoSystem;
    JPanel userProcessContainer;
    Network network;
    Organization organization ;
    private static Logger log = Logger.getLogger(PatientListJPanel.class);
    private static final String CLASS_NAME = PatientListJPanel.class.getName();
    public PatientListJPanel(JPanel userProcessContainer,Network network, Organization organization ,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.patientList = ecoSystem.getPatientDirectory();
        this.doctorList = ecoSystem.getDoctroDirectory();
        this.network = network;
        this.organization = organization;
        populateTable();
        populateDocTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        btnCreatePatient = new javax.swing.JButton();
        btnUpdatePatient = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        btnCreateDoctor = new javax.swing.JButton();
        btnUpdatePatient1 = new javax.swing.JButton();
        btnDeletePatient1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("RECEPTION");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 26));

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FullName", "PhoneNumber", "EmailAddress", "BirthDate", "Address", "UserName"
            }
        ));
        jScrollPane1.setViewportView(tblPatient);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 97, 649, 133));

        btnCreatePatient.setBackground(new java.awt.Color(0, 153, 153));
        btnCreatePatient.setText("Create Patient");
        btnCreatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePatientActionPerformed(evt);
            }
        });
        add(btnCreatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 184, -1));

        btnUpdatePatient.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdatePatient.setText("View Patient Info");
        btnUpdatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePatientActionPerformed(evt);
            }
        });
        add(btnUpdatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 184, -1));

        btnDeletePatient.setBackground(new java.awt.Color(0, 153, 153));
        btnDeletePatient.setText("Delete Patient");
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatientActionPerformed(evt);
            }
        });
        add(btnDeletePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 184, -1));

        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FullName", "Qualification", "Specilization", "UserName"
            }
        ));
        jScrollPane2.setViewportView(tblDoctor);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 362, 649, 133));

        btnCreateDoctor.setBackground(new java.awt.Color(0, 153, 153));
        btnCreateDoctor.setText("Create Doctor");
        btnCreateDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDoctorActionPerformed(evt);
            }
        });
        add(btnCreateDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 513, 184, -1));

        btnUpdatePatient1.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdatePatient1.setText("Modify or View Doctor");
        btnUpdatePatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePatient1ActionPerformed(evt);
            }
        });
        add(btnUpdatePatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 513, -1, -1));

        btnDeletePatient1.setBackground(new java.awt.Color(0, 153, 153));
        btnDeletePatient1.setText("Delete Doctor");
        btnDeletePatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatient1ActionPerformed(evt);
            }
        });
        add(btnDeletePatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 184, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 325, 790, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/receptionist.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 670, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePatientActionPerformed
        // TODO add your handling code here:
        CreatePatientJPanel createPatient = new CreatePatientJPanel(userProcessContainer, ecoSystem, patientList, network);
        userProcessContainer.add("CreatePatientJPanel",createPatient);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreatePatientActionPerformed

    private void btnUpdatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePatientActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatient.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first");
            return;
        }
        Patient patient = (Patient)tblPatient.getValueAt(selectedRow,0);
        CreatePatientJPanel modifyPatient = new CreatePatientJPanel(userProcessContainer, ecoSystem, patientList, patient,network);
        userProcessContainer.add("ModifyPatientJPanel",modifyPatient);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdatePatientActionPerformed

    private void btnDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatientActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatient.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warining", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Patient patient = (Patient) tblPatient.getValueAt(selectedRow, 0);
        patientList.removePatient(patient);
        populateTable();
    }//GEN-LAST:event_btnDeletePatientActionPerformed

    private void btnCreateDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDoctorActionPerformed
        // TODO add your handling code here:
         CreateDoctorJPanel createDoctor = new CreateDoctorJPanel(userProcessContainer, ecoSystem, doctorList, network);
        userProcessContainer.add("CreatePatientJPanel",createDoctor);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnCreateDoctorActionPerformed

    private void btnUpdatePatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePatient1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDoctor.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first");
            return;
        }
        Doctor doctor = (Doctor)tblDoctor.getValueAt(selectedRow,0);
        CreateDoctorJPanel createDoctor = new CreateDoctorJPanel(userProcessContainer, ecoSystem, doctorList, network,doctor);
        userProcessContainer.add("CreatePatientJPanel",createDoctor);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdatePatient1ActionPerformed

    private void btnDeletePatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatient1ActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblDoctor.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warining", JOptionPane.WARNING_MESSAGE);
            return;
        }
         Doctor doctorSelected = (Doctor) tblDoctor.getValueAt(selectedRow, 0);
         Organization doctorOrg = null;
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
        {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
               if (organization instanceof DoctorOrganization ) {

                   doctorOrg = organization;
                   break;
               }
           }
        }

            for(Doctor doctor : doctorList.getDoctorList())
            {
                String UserName = "" ;
                String Password = ""; 
                for(UserAccount useraccount : doctorOrg.getUserAccountDirectory().getUserAccountList())
                {
                    if(useraccount.getEmployee().getName().equals(doctorSelected.getDocName()))
                    {
                        if(useraccount.getWorkQueue().getWorkRequestList().size() > 0)
                        {
                             JOptionPane.showMessageDialog(null,"There is already request assigned to this Doctor, So Doctor won't delete");
                             return;
                        }
                    }
                }
            }
        
        
        
        
        
//        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {
//            if(wr instanceof DoctorWorkRequest) {
//                
//                DoctorWorkRequest epr = (DoctorWorkRequest)wr;

       
        doctorList.removeDoctor(doctorSelected);
        populateDocTable();
    }//GEN-LAST:event_btnDeletePatient1ActionPerformed

    
    
    public void populateTable()
    {
        DefaultTableModel patientModel = (DefaultTableModel) tblPatient.getModel();
        patientModel.setRowCount(0);
        
        for(Patient patient : patientList.getPatientList())
        {
            String UserName = "" ;
            String Password = ""; 
             Organization patientOrg = null;
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
        {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
               if (organization instanceof PatientOrganization) {

                   patientOrg = organization;
                   break;
               }
           }
        }
            for(UserAccount useraccount : patientOrg.getUserAccountDirectory().getUserAccountList())
            {
                if(useraccount.getEmployee().getName().equals(patient.getPatientName()))
                {
                    System.out.println(useraccount);
                    UserName = useraccount.getUsername();
                    Password = useraccount.getUsername();
                }
            }
            //for()
            Object [] row = new Object[6];
            row[0] = patient;
            row[1] = patient.getPhoneNumber();
            row[2] = patient.getEmailAddress();
            row[3] = patient.getBirthDate();
            row[4] = patient.getAddress();
            row[5] = patient.getUserName();
           
            patientModel.addRow(row);
        }
    }
    
    public void populateDocTable()
    {
        try{
            log.info("Receptionist Panel Opening");
            DefaultTableModel patientModel = (DefaultTableModel) tblDoctor.getModel();
            patientModel.setRowCount(0);
            
             Organization doctorOrg = null;
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
        {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
               if (organization instanceof DoctorOrganization ) {

                   doctorOrg = organization;
                   break;
               }
           }
        }

            for(Doctor doctor : doctorList.getDoctorList())
            {
                String UserName = "" ;
                String Password = ""; 
                for(UserAccount useraccount : doctorOrg.getUserAccountDirectory().getUserAccountList())
                {
                    if(useraccount.getEmployee().getName().equals(doctor.getDocName()))
                    {
                        UserName = useraccount.getUsername();
                        Password = useraccount.getUsername();
                    }
                }
                //for()
                Object [] row = new Object[4];
                row[0] = doctor;
                row[1] = doctor.getQualification();
                row[2] = doctor.getSpecilizationName();
                row[3] = UserName;

                patientModel.addRow(row);
            }
        }
        catch(Exception e)
        {
            log.error(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDoctor;
    private javax.swing.JButton btnCreatePatient;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnDeletePatient1;
    private javax.swing.JButton btnUpdatePatient;
    private javax.swing.JButton btnUpdatePatient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JTable tblPatient;
    // End of variables declaration//GEN-END:variables
}
