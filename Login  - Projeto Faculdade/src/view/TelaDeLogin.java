package test.view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import test.controle.ControleOp;
import test.model.Usuario;

/**
 *
 * @author Allan Rodrigues
 */
public class TelaDeLogin extends JFrame {
    public TelaDeLogin() {

        ImageIcon icon = new ImageIcon("Imagens/logo.png");
        JLabel lIcon = new JLabel(icon);
        lIcon.setBounds(0, 30, 210, 230);

        setTitle("Tela de Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.green);

        JLabel titulo_email = new JLabel("Email");
        titulo_email.setForeground(Color.white);
        titulo_email.setFont(new Font("helvetica", Font.PLAIN, 12));
        titulo_email.setBounds(200, 10, 120, 30);

        JTextField email = new JTextField();
        email.setForeground(Color.GRAY);
        email.setBounds(200, 40, 120, 30);

        JLabel titulo_senha = new JLabel("Senha");
        titulo_senha.setForeground(Color.WHITE);
        titulo_senha.setFont(new Font("helvetica", Font.BOLD, 12));
        titulo_senha.setBounds(200, 80, 120, 30);

        JPasswordField senha = new JPasswordField();
        senha.setForeground(Color.GRAY);
        senha.setBounds(200, 110, 120, 30);

        JButton btn = new JButton("Logar");
        btn.setBackground(Color.orange);
        btn.setForeground(Color.white);
        btn.setFont(new Font("helvetica", Font.PLAIN, 12));
        btn.setBounds(200, 160, 120, 30);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String e = email.getText().toLowerCase();
                String s = senha.getText();

                int status = 0;

                if (e.equals("") || s.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha as caixas de login");
                } else {
                    Usuario usuario = new Usuario(null, s, e);
                    ControleOp op = new ControleOp();

                    try {
                        status = op.fazerLogin(usuario);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (status == 1) {
                        JOptionPane.showMessageDialog(null, "Logado com sucesso!");
                        email.setText("");
                        senha.setText("");
                        dispose();

                        try {
                            ArrayList<Usuario> result = op.recuperarDados(usuario);
                            new TelaLogado(result).setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao realizar o login!");
                        email.setText("");
                        senha.setText("");
                    }

                }
            }

        });

        JButton btnCad = new JButton("Fazer Cadastro");
        btnCad.setOpaque(false);
        btnCad.setContentAreaFilled(false);
        btnCad.setBorderPainted(false);
        btnCad.setForeground(Color.red);
        btnCad.setFont(new Font("helvetica", Font.BOLD, 16));
        btnCad.setBounds(170, 210, 180, 30);

        btnCad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new TelaDeCadastro().setVisible(true);
            }
        }

        );

        JLabel titulo_login = new JLabel("Sistem de Login");
        titulo_login.setForeground(Color.white);
        titulo_login.setFont(new Font("helvetica", Font.BOLD, 15));
        titulo_login.setBounds(30, 10, 150, 40);

        painel.add(titulo_senha);
        painel.add(titulo_email);
        painel.add(titulo_login);
        painel.add(senha);
        painel.add(email);
        painel.add(btn);
        painel.add(btnCad);
        painel.add(lIcon);
        add(painel);
    }
}
