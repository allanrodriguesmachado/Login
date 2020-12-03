package test.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import test.controle.ControleOp;
import test.model.Usuario;

/**
 *
 * @author Allan Rodrigues
 */
public class TelaListaBanco extends JFrame {
    public TelaListaBanco(ArrayList<Usuario> dadosUser) {

        JTable tabela;
        JScrollPane barraRolagem;
        ArrayList<Usuario> dadosDB = null;

        String[] colunas = { "ID", "Nome", "Email" };

        ControleOp controle = new ControleOp();

        try {
            dadosDB = controle.recuperarDadosALL();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dadosList[][] = new String[dadosDB.size()][3];
        int index = 0;

        for (Usuario elemento : dadosDB) {
            dadosList[index][0] = Integer.toString(elemento.getId());
            dadosList[index][1] = elemento.getNome();
            dadosList[index][2] = elemento.getEmail();

            index++;
        }

        tabela = new JTable(dadosList, colunas);
        barraRolagem = new JScrollPane(tabela);

        setTitle("Tela de leitura dos dados");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(Color.green);

        JButton btn = new JButton("Voltar");
        btn.setBackground(Color.orange);
        btn.setForeground(Color.white);
        btn.setFont(new Font("helvetica", Font.BOLD, 20));
        btn.setBounds(90, 240, 180, 30);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new TelaLogado(dadosUser).setVisible(true);
            }
        });

        painel.setLayout(new GridLayout(0, 2));
        painel.add(barraRolagem);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(barraRolagem, BorderLayout.CENTER);
        this.getContentPane().add(btn, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cadastro");
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        add(painel);
    }

}
