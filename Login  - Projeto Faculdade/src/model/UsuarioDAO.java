package test.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Allan Rodrigues
 */
public interface UsuarioDAO {
    public int salvarDados(Usuario usuario) throws SQLException,ClassNotFoundException;
    public int fazerLogin(Usuario usuario) throws SQLException,ClassNotFoundException;
    public ArrayList<Usuario> recuperarDados(Usuario usuario) throws SQLException,ClassNotFoundException;
    public int alterarEmail(Usuario usuario,String novoEmail) throws SQLException,ClassNotFoundException;
    public ArrayList<Usuario> recuperarDadosALL() throws SQLException,ClassNotFoundException; 
}
