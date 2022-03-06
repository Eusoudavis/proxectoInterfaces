/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Xanelas;

import com.formdev.flatlaf.FlatLightLaf;
import modelo.Loxica.LoxicaCliente;
import modelo.Loxica.LoxicaPropietario;
import modelo.Loxica.LoxicaUsuario;
import modelo.vo.Usuario.Cliente;
import modelo.vo.Usuario.Propietario;
import modelo.vo.Usuario.Usuario;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author david
 */
public class Xanela1 extends javax.swing.JFrame {

    public int xMouse, yMouse;
    LoxicaUsuario loxicaUsuario = new LoxicaUsuario();
    LoxicaPropietario loxicaPropietario = new LoxicaPropietario();
    LoxicaCliente loxicaCliente = new LoxicaCliente();

    /**
     * Creates new form Xanela1
     */
    public Xanela1() {
        initComponents();
        load();

        this.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());

        Busqueda busqueda = new Busqueda();
        busqueda.setSize(580, 70);
        busqueda.setLocation(0, 0);

        PanelBuscador.removeAll();
        PanelBuscador.add(busqueda);
        PanelBuscador.revalidate();
        PanelBuscador.repaint();
    }

    private void load() {
        try {

            File file = new File("src/main/java/help/help.hs");
            URL hsURL = file.toURI().toURL();

            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            hb.enableHelpKey(this.rootPane.getContentPane(), "manual", helpset);

        } catch (MalformedURLException ex) {
            Logger.getLogger(LoadHelp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HelpSetException ex) {
            Logger.getLogger(LoadHelp.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        PanelInicioRexistro = new javax.swing.JPanel();
        LabelContra = new javax.swing.JLabel();
        LabelInicioSesion = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        infoText = new javax.swing.JLabel();
        UsuarioText = new javax.swing.JTextField();
        ContrasinalText = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        BotonInicioSesion = new javax.swing.JButton();
        BotonRexistro = new javax.swing.JButton();
        PanelBuscador = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        btnSaida = new java.awt.Label();
        PanelCorpo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicioRexistro.setBackground(new java.awt.Color(0, 72, 193));
        PanelInicioRexistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelContra.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LabelContra.setForeground(new java.awt.Color(255, 255, 255));
        LabelContra.setText("CONTRASINAL");
        PanelInicioRexistro.add(LabelContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 160, 20));

        LabelInicioSesion.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        LabelInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        LabelInicioSesion.setText("INICIO SESION");
        PanelInicioRexistro.add(LabelInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 200, 50));

        LabelUsuario.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsuario.setText("USUARIO");
        PanelInicioRexistro.add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 160, 20));

        infoText.setForeground(new java.awt.Color(255, 255, 255));
        infoText.setText("SE NON TES CONTA PODES...");
        PanelInicioRexistro.add(infoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 150, -1));

        UsuarioText.setForeground(new java.awt.Color(196, 196, 196));
        UsuarioText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UsuarioText.setBorder(null);
        UsuarioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioTextActionPerformed(evt);
            }
        });
        PanelInicioRexistro.add(UsuarioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 230, 30));

        ContrasinalText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ContrasinalText.setBorder(null);
        PanelInicioRexistro.add(ContrasinalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 230, 30));
        PanelInicioRexistro.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 230, -1));
        PanelInicioRexistro.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 230, -1));

        BotonInicioSesion.setBackground(new java.awt.Color(102, 102, 255));
        BotonInicioSesion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BotonInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        BotonInicioSesion.setText("INICIO SESION");
        BotonInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInicioSesionActionPerformed(evt);
            }
        });
        PanelInicioRexistro.add(BotonInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 230, 60));

        BotonRexistro.setBackground(new java.awt.Color(102, 102, 255));
        BotonRexistro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BotonRexistro.setForeground(new java.awt.Color(255, 255, 255));
        BotonRexistro.setText("REXISTRARSE");
        BotonRexistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRexistroActionPerformed(evt);
            }
        });
        PanelInicioRexistro.add(BotonRexistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 230, 60));

        bg.add(PanelInicioRexistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 320, 650));

        PanelBuscador.setBackground(new java.awt.Color(219, 243, 255));

        javax.swing.GroupLayout PanelBuscadorLayout = new javax.swing.GroupLayout(PanelBuscador);
        PanelBuscador.setLayout(PanelBuscadorLayout);
        PanelBuscadorLayout.setHorizontalGroup(
                PanelBuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );
        PanelBuscadorLayout.setVerticalGroup(
                PanelBuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(PanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 580, 70));

        BarraSuperior.setBackground(new java.awt.Color(255, 255, 255));
        BarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraSuperiorMouseDragged(evt);
            }
        });
        BarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraSuperiorMousePressed(evt);
            }
        });

        btnSaida.setAlignment(java.awt.Label.CENTER);
        btnSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaida.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnSaida.setForeground(new java.awt.Color(0, 72, 193));
        btnSaida.setText("X");
        btnSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaidaMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaidaMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaidaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
                BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BarraSuperiorLayout.createSequentialGroup()
                                .addComponent(btnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 539, Short.MAX_VALUE))
        );
        BarraSuperiorLayout.setVerticalGroup(
                BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BarraSuperiorLayout.createSequentialGroup()
                                .addComponent(btnSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        bg.add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 72, 193));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>\n<body>\nBENVIDO \n<br>\n WELCOME \n<br>\n BIENVENIDO\n</body>\n</html>");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout PanelCorpoLayout = new javax.swing.GroupLayout(PanelCorpo);
        PanelCorpo.setLayout(PanelCorpoLayout);
        PanelCorpoLayout.setHorizontalGroup(
                PanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCorpoLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelCorpoLayout.setVerticalGroup(
                PanelCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCorpoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(194, Short.MAX_VALUE))
        );

        bg.add(PanelCorpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 580, 540));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuarioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioTextActionPerformed

    /**
     * Método para o control da posición da interfaz na pantalla
     *
     * @param evt
     */
    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed

        xMouse = evt.getX();
        yMouse = evt.getY();

        // TODO add your handling code here:
    }//GEN-LAST:event_BarraSuperiorMousePressed

    /**
     * Método para o control da posición da interfaz na pantalla
     *
     * @param evt
     */
    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);

        // TODO add your handling code here:
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    /**
     * Método para pechar a aplicación
     *
     * @param evt
     */
    private void btnSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseClicked

    private void btnSaidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseEntered

        btnSaida.setBackground(Color.red);
        btnSaida.setForeground(Color.WHITE);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseEntered

    private void btnSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseExited

        btnSaida.setBackground(Color.white);
        btnSaida.setForeground(new Color(0, 72, 193));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseExited

    /**
     * Método que comproba en bbdd o usuario, rol e contrasinal para iniciar sesión
     *
     * @param evt
     */
    private void BotonInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInicioSesionActionPerformed

        String user = UsuarioText.getText().replaceAll("\\p{Punct}", "");
        String pwd = ContrasinalText.getText();
        if (!user.equals("") && !user.isBlank() && !pwd.equals("") && !pwd.isBlank()) {

            if (user.length() >= 1 && pwd.length() >= 3) {
                Usuario usuario = new Propietario();
                usuario.setIdUsuario(Integer.parseInt(user));
                usuario.setContrasinal(pwd);
                Usuario usuarioBDProba = loxicaUsuario.validarFindById(usuario);
                if (usuarioBDProba.getIdUsuario() != (0)) {
                    usuario.setRol(loxicaPropietario.validarFindByIdPropietario(usuario).getRol());
                    if (loxicaPropietario.validarFindByIdPropietario(usuario).getRol().equals("Propietario") &&
                            loxicaPropietario.validarFindByIdPropietario(usuario).getContrasinal().equals(pwd)) {
                        System.setProperty("idPropietario", user);
                        new XanelaPropietario().setVisible(true);
                        this.setVisible(false);
                    } else {
                        Usuario usuarioBD = new Cliente();
                        usuarioBD.setIdUsuario(Integer.parseInt(user));
                        usuarioBD.setContrasinal(pwd);
                        usuarioBD.setRol(loxicaPropietario.validarFindByIdPropietario(usuarioBD).getRol());

                        if (loxicaPropietario.validarFindByIdPropietario(usuario).getRol().equals("Cliente") &&
                                loxicaPropietario.validarFindByIdPropietario(usuario).getContrasinal().equals(pwd)) {
                            System.setProperty("idUsuario", user);
                            new XanelaCliente().setVisible(true);
                            this.setVisible(false);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou Contrasinal erroneo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou Contrasinal demasiado cortos. Min 3 caracteres");
                return;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor complete todos os campos");
            return;
        }
    }

    // TODO add your handling code here:
//GEN-LAST:event_BotonInicioSesionActionPerformed

    /**
     * Método que abre o JDialog para o rexistro
     *
     * @param evt
     */
    private void BotonRexistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRexistroActionPerformed

        new DialogoRexistro(this, true).setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_BotonRexistroActionPerformed

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
            java.util.logging.Logger.getLogger(Xanela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xanela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xanela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xanela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        FlatLightLaf.setup();        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Xanela1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonInicioSesion;
    private javax.swing.JButton BotonRexistro;
    private javax.swing.JPasswordField ContrasinalText;
    private javax.swing.JLabel LabelContra;
    private javax.swing.JLabel LabelInicioSesion;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPanel PanelBuscador;
    private javax.swing.JPanel PanelCorpo;
    private javax.swing.JPanel PanelInicioRexistro;
    private javax.swing.JTextField UsuarioText;
    private javax.swing.JPanel bg;
    private java.awt.Label btnSaida;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel infoText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
