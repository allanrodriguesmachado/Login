package test.view;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import test.controle.ControleOp;
import test.model.Usuario;

public class TelaDeCadastro extends JFrame {
    public TelaDeCadastro(){
        setTitle("Tela de Cadastro");
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.green);

        JLabel titulo_nome = new JLabel("Nome:");
        titulo_nome.setForeground(Color.white);
        titulo_nome.setFont(new Font("helvetica",Font.PLAIN,12));
        titulo_nome.setBounds(200,10,120,30);

        JTextField nome = new JTextField();
        nome.setForeground(Color.GRAY);
        nome.setBounds(200,40,120,30);

        JLabel titulo_email = new JLabel("Email:");
        titulo_email.setForeground(Color.white);
        titulo_email.setFont(new Font("helvetica",Font.PLAIN,12));
        titulo_email.setBounds(200,70,120,30);

        JTextField email = new JTextField();
        email.setForeground(Color.GRAY);
        email.setBounds(200,100,120,30);
        
        JLabel titulo_senha = new JLabel("Senha:");
        titulo_senha .setForeground(Color.WHITE);
        titulo_senha .setFont(new Font("helvetica",Font.PLAIN,12));
        titulo_senha .setBounds(200,130,120,30);

        JPasswordField senha = new JPasswordField();
        senha.setForeground(Color.GRAY);
        senha.setBounds(200,160,120,30);

        JButton btn = new JButton("Cadastrar");
        btn.setBackground(Color.orange);
        btn.setForeground(Color.white);
        btn.setFont(new Font("helvetica",Font.PLAIN,12));
        btn.setBounds(200,200,120,30);
        
        btn.addActionListener(
                new ActionListener(){
                    
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int status = 0;
                
                String n = nome.getText();
                String e = email.getText().toLowerCase();
                String s = senha.getText();
                
                Usuario usuario = new Usuario(n,s,e);
                ControleOp controle = new ControleOp();
                try {
                    status = controle.salvar(usuario);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(status == 1){
                    JOptionPane.showMessageDialog(null, "Seu cadastro foi efetuado com sucesso!");
                }
                dispose();
                new TelaDeLogin().setVisible(true);
            }
                    
            }
        
        );

        JLabel titulo_cadastrar = new JLabel("Sistem de Cadastro");
        titulo_cadastrar.setForeground(Color.white);
        titulo_cadastrar.setFont(new Font("helvetica",Font.PLAIN,15));
        titulo_cadastrar.setBounds(30,10,150,40);

        painel.add(titulo_senha);
        painel.add(titulo_nome);
        painel.add(titulo_cadastrar);
        painel.add(titulo_email);
        painel.add(email);
        painel.add(senha);
        painel.add(nome);
        painel.add(btn);
        add(painel);

    }
}
