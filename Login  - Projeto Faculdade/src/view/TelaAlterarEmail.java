/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.controle.ControleOp;
import test.model.Usuario;

/**
 *
 * @author Allan Rodrigues
 */
public class TelaAlterarEmail extends JFrame {
    public TelaAlterarEmail(ArrayList<Usuario> dadosUser) {

        Usuario dados = dadosUser.get(0);

        ImageIcon icon = new ImageIcon("Imagens/logo.png");
        JLabel lIcon = new JLabel(icon);
        lIcon.setBounds(10, 30, 210, 230);

        setTitle("Tela Inicial");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.green);

        JLabel titulo = new JLabel("Tela de Alterar email");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("helvetica", Font.BOLD, 18));
        titulo.setBounds(50, 60, 320, 30);

        JLabel titulo_nome = new JLabel("Bem vindo: " + dados.getNome());
        titulo_nome.setForeground(Color.white);
        titulo_nome.setFont(new Font("helvetica", Font.BOLD, 16));
        titulo_nome.setBounds(30, 15, 180, 30);

        JLabel lbid = new JLabel("Id: " + dados.getId());
        lbid.setForeground(Color.white);
        lbid.setFont(new Font("helvetica", Font.BOLD, 14));
        lbid.setBounds(190, 90, 180, 30);

        JLabel lbnome = new JLabel("Nome: " + dados.getNome());
        lbnome.setForeground(Color.white);
        lbnome.setFont(new Font("helvetica", Font.BOLD, 14));
        lbnome.setBounds(190, 110, 180, 30);

        JLabel lbemail = new JLabel("Email: " + dados.getEmail());
        lbemail.setForeground(Color.white);
        lbemail.setFont(new Font("helvetica", Font.BOLD, 14));
        lbemail.setBounds(190, 130, 180, 30);

        JLabel titulo_email = new JLabel("Email");
        titulo_email.setForeground(Color.white);
        titulo_email.setFont(new Font("helvetica", Font.PLAIN, 14));
        titulo_email.setBounds(190, 155, 180, 30);

        JTextField email = new JTextField();
        email.setForeground(Color.GRAY);
        email.setBounds(190, 180, 180, 30);

        JButton btnAlt = new JButton("Alterar Email");
        btnAlt.setBackground(Color.orange);
        btnAlt.setForeground(Color.white);
        btnAlt.setFont(new Font("helvetica", Font.BOLD, 14));
        btnAlt.setBounds(190, 220, 180, 30);

        btnAlt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int status = 0;
                Usuario usuario = new Usuario();
                usuario = dadosUser.get(0);

                ControleOp controle = new ControleOp();

                try {
                    status = controle.alterarEmail(usuario, email.getText().toLowerCase());
                    usuario.setEmail(email.getText().toLowerCase());

                    dadosUser.set(0, usuario);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaAlterarEmail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaAlterarEmail.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (status == 1) {
                    JOptionPane.showMessageDialog(null, "Seu email foi alterado com sucesso!");
                    dispose();
                    new TelaLogado(dadosUser).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar o seu email!");
                }
            }

        }

        );

        JButton btnVolt = new JButton("Voltar");
        btnVolt.setBackground(Color.GRAY);
        btnVolt.setForeground(Color.white);
        btnVolt.setFont(new Font("helvetica", Font.BOLD, 14));
        btnVolt.setBounds(190, 255, 180, 30);

        btnVolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new TelaLogado(dadosUser).setVisible(true);
            }
        });

        painel.add(titulo_nome);
        painel.add(titulo);
        painel.add(lbid);
        painel.add(lbnome);
        painel.add(lbemail);
        painel.add(titulo_email);
        painel.add(email);
        painel.add(btnAlt);
        painel.add(btnVolt);
        painel.add(lIcon);
        add(painel);
    }

}
