package test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import test.model.Usuario;

/**
 *
 * @author Allan Rodrigues
 */
public class OpCRUD implements UsuarioDAO {
    
    Connection coon;
    PreparedStatement psmt;
    String SQL;
    ResultSet rs;

    @Override
    public int salvarDados(Usuario usuario) throws SQLException,ClassNotFoundException{
        int status = 0;
        String SQL = "INSERT INTO usuarios (nome,senha,email) VALUES (?,?,?)";
        coon = new Conexao().getConnection();
        psmt = coon.prepareStatement(SQL);
        psmt.setString(1, usuario.getNome());
        psmt.setString(2, usuario.getSenha());
        psmt.setString(3, usuario.getEmail());
        
        status = psmt.executeUpdate();
        return status;
    }

    @Override
    public int fazerLogin(Usuario usuario) throws SQLException, ClassNotFoundException {
        int status = 0;
        String SQL = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        coon = new Conexao().getConnection();
        psmt = coon.prepareStatement(SQL);
        psmt.setString(1, usuario.getEmail());
        psmt.setString(2, usuario.getSenha());
        
        rs = psmt.executeQuery();
        
        if(rs.next()){
            status = 1;
        }
        return status;
    }
    @Override
    public ArrayList<Usuario> recuperarDados(Usuario usuario)throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        
        ArrayList<Usuario> dadosUser = new ArrayList();
        coon = new Conexao().getConnection();
        psmt = coon.prepareStatement(SQL);
        psmt.setString(1, usuario.getEmail());
        psmt.setString(2, usuario.getSenha());
        
        rs = psmt.executeQuery();
        
        while(rs.next()){
            Usuario user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setSenha(rs.getString("senha"));
            dadosUser.add(user);
        }
 
        return dadosUser;
    }
    
    public int alterarEmail(Usuario usuario,String novoEmail) throws SQLException,ClassNotFoundException{
        int status = 0;
        String SQL = "UPDATE usuarios SET email=? WHERE id=?;";
        coon = new Conexao().getConnection();
        psmt = coon.prepareStatement(SQL);
        psmt.setString(1, novoEmail);
        psmt.setInt(2, usuario.getId());
        
        psmt.executeUpdate();
        status = 1;
        return status;
    }
    
    @Override
    public ArrayList<Usuario> recuperarDadosALL() throws SQLException,ClassNotFoundException{
        String SQL = "SELECT * FROM usuarios";
        
        ArrayList<Usuario> dadosUser = new ArrayList();
        coon = new Conexao().getConnection();
        psmt = coon.prepareStatement(SQL);
        
        rs = psmt.executeQuery();
        
        while(rs.next()){
            Usuario user = new Usuario();
            user.setId(rs.getInt("id"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            dadosUser.add(user);
        }
 
        return dadosUser;
    }
    
}
