package co.edu.upb;

import principal.dominio.PersonalAtencion.PersonalAtencion;
import principal.dominio.administrador.Administrador;
import principal.dominio.user.Usuario;
import principal.dominio.user.UsuarioServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
        private JTextField nombreUsuario;
        private JPasswordField passwordField;

        private PersonalAtencion javaApplication = new PersonalAtencion();

        private Usuario user = new Usuario("2101", "Sergio", "Mesa", "Médico");

        private UsuarioServices usuarioServices;




        public Login() {
                usuarioServices = new UsuarioServices();
                // Configuración de la ventana
                setTitle("IPS Salud Pro - Inicio de Sesión");
                setExtendedState(JFrame.MAXIMIZED_BOTH); // Poner en pantalla completa
                setResizable(false); // Desactivar la capacidad de redimensionamiento
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);

                // Creación de paneles
                JPanel mainPanel = new JPanel();
                mainPanel.setBackground(new Color(150, 198, 198));

                // Diseño y estilos adicionales
                mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                // Agregar el panel principal a la ventana
                getContentPane().add(mainPanel);
                mainPanel.setLayout(null);

                JLabel lblUsuario = new JLabel("Usuario");
                lblUsuario.setForeground(new Color(7, 29, 68));
                lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblUsuario.setBounds(334, 339, 100, 25);
                mainPanel.add(lblUsuario);

                JLabel lblPassword = new JLabel("Contraseña");
                lblPassword.setForeground(new Color(7, 29, 68));
                lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblPassword.setBounds(334, 415, 127, 25);
                mainPanel.add(lblPassword);

                nombreUsuario = new JTextField();
                nombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
                nombreUsuario.setBounds(334, 374, 213, 31);
                mainPanel.add(nombreUsuario);
                nombreUsuario.setColumns(10);

                passwordField = new JPasswordField();
                passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
                passwordField.setBounds(334, 450, 213, 31);
                mainPanel.add(passwordField);

                JButton btnLogin = new JButton("Iniciar sesión");
                btnLogin.setBackground(new Color(7, 29, 68));
                btnLogin.setForeground(new Color(255, 255, 255));
                btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
                btnLogin.setBounds(355, 505, 170, 50);
                btnLogin.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String usuario = nombreUsuario.getText();
                                String contrasena = new String(passwordField.getPassword());
                                try {
                                        validarSesion(usuario, contrasena);
                                } catch (Exception ex) {
                                }
                        }
                });
                mainPanel.add(btnLogin);

                JLabel lblImagenLogin = new JLabel("New label");
                lblImagenLogin.setBounds(250, 223, 380, 540);
                mainPanel.add(lblImagenLogin);
                lblImagenLogin.setIcon(new ImageIcon(getClass().getResource("/login.jpg")));

                JLabel lblFondoLogin = new JLabel("");
                lblFondoLogin.setIcon(new ImageIcon(getClass().getResource("/fondoLogin.jpg")));
                lblFondoLogin.setBounds(0, 0, 1600, 900);
                mainPanel.add(lblFondoLogin);

                // Hacer visible la ventana
                setVisible(true);
        }

        public void validarSesion(String nombreUsuario, String password) throws Exception {
                Usuario usuario = usuarioServices.searchPerID(password); // Se asume que el ID es la contraseña

                if (usuario != null && usuario.getNombre().equals(nombreUsuario)) {
                        if (usuario.getCargo() == "Agente atención al paciente"){
                                AgenteAtencionAlPaciente atencionAlPaciente = new AgenteAtencionAlPaciente();
                                atencionAlPaciente.setVisible(true);
                                dispose();
                        }

                } else {
                        // Usuario o contraseña incorrectos
                        JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                new Login();
                        }
                });
        }
}