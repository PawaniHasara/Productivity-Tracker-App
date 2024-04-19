
package EX;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class Edit extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public Edit() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
        initComponents();
        setTitle("Edit Profile and Features");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jBtnReset = new javax.swing.JButton();
        jTextUserName = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jBtnExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBtnBrowse = new javax.swing.JButton();
        imagePath = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Update Full Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Update E-mail Address");

        jTextPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jTextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPasswordActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Change Password");

        jBtnSave.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jBtnSave.setText("Save ");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jBtnReset.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jBtnReset.setText("Reset");
        jBtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnResetActionPerformed(evt);
            }
        });

        jTextUserName.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jTextEmail.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jBtnExit.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jBtnExit.setText("Exit");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitExit();
            }

            private void exitExit() {
                int response = JOptionPane.showConfirmDialog(Edit.this, "Are you sure you want to exit?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setText("Update Profile Picture");

        jBtnBrowse.setFont(new java.awt.Font("Segoe UI", 0, 10));
        jBtnBrowse.setText("Browse Image");
        jBtnBrowse.setActionCommand("Browse");
        jBtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBrowseActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setText("Notification Preferences");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enable", "Disable" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(88)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jBtnSave)
        					.addGap(112)
        					.addComponent(jBtnReset)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jBtnExit))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(42))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(imagePath, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        								.addComponent(jTextPassword)
        								.addComponent(jTextUserName)
        								.addComponent(jTextEmail))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jBtnBrowse))
        						.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(jLabel2)
        			.addGap(44)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(imagePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jBtnBrowse)
        				.addComponent(jLabel6))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(jTextEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(jTextPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(28)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jBtnSave)
        				.addComponent(jBtnReset)
        				.addComponent(jBtnExit))
        			.addGap(29))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setText("EDIT USER'S PROFILE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(80)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(219)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(30, Short.MAX_VALUE)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jBtnResetActionPerformed(java.awt.event.ActionEvent evt) {

        jTextUserName.setText(null);
        jTextEmail.setText(null);
        jTextPassword.setText(null);
        imagePath.setText(null);
    }

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextUserName.getText();
        String email = jTextEmail.getText();
        char[] passwordChars = jTextPassword.getPassword();
        String password = new String(passwordChars);

        try {
            FileWriter Writer = new FileWriter("editdata.txt", true);
            Writer.write(name + " ");
            Writer.write(email + " ");
            Writer.write(password + " ");
            Writer.write(System.getProperty("line.separator"));
            Writer.close();
            JOptionPane.showMessageDialog(null, "Save Details");
            JOptionPane.showMessageDialog(this, "Details saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Edit().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    private void jTextPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jBtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(this);

        if (load == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            imagePath.setText(path);
        }
    }
    

    
    
    private javax.swing.JTextField imagePath;
    private javax.swing.JButton jBtnBrowse;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnReset;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JPasswordField jTextPassword;
    private javax.swing.JTextField jTextUserName;
   
}
