package test.view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
public class TelaLogado extends JFrame {
    public TelaLogado(ArrayList<Usuario> dadosUser) {

        Usuario dados = dadosUser.get(0);

        ImageIcon icon = new ImageIcon("Imagens/logo.png");
        JLabel lIcon = new JLabel(icon);
        lIcon.setBounds(70, 30, 210, 230);

        setTitle("Tela Inicial");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.green);

        JLabel titulo_nome = new JLabel("Bem vindo: " + dados.getNome());
        titulo_nome.setForeground(Color.white);
        titulo_nome.setFont(new Font("helvetica", Font.BOLD, 20));
        titulo_nome.setBounds(40, 35, 320, 30);

        JButton btn = new JButton("Alterar Email");
        btn.setBackground(Color.orange);
        btn.setForeground(Color.white);
        btn.setFont(new Font("helvetica", Font.BOLD, 16));
        btn.setBounds(90, 200, 180, 30);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new TelaAlterarEmail(dadosUser).setVisible(true);
            }
        });

        JButton btnList = new JButton("Listar");
        btnList.setBackground(Color.orange);
        btnList.setForeground(Color.white);
        btnList.setFont(new Font("helvetica", Font.BOLD, 16));
        btnList.setBounds(90, 240, 180, 30);

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new TelaListaBanco(dadosUser).setVisible(true);
            }
        });

        painel.add(titulo_nome);
        painel.add(btnList);
        painel.add(btn);
        painel.add(lIcon);
        add(painel);
    }

}
