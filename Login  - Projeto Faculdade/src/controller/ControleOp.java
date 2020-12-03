package test.controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import test.model.OpCRUD;
import test.model.Usuario;

/**
 *
 * @author Allan Rodrigues
 */
public class ControleOp {
    public int salvar(Usuario usuario) throws SQLException, ClassNotFoundException{
        int status;
        
        OpCRUD op = new OpCRUD();
        status = op.salvarDados(usuario);
        
        return status;
    }
    public int fazerLogin(Usuario usuario) throws SQLException, ClassNotFoundException{
        int status = 0;
        
        OpCRUD op = new OpCRUD();
        status = op.fazerLogin(usuario);
        
        return status;
    }
    public ArrayList recuperarDados(Usuario usuario) throws SQLException,ClassNotFoundException{
        OpCRUD op = new OpCRUD();
        ArrayList<Usuario> dadosUser = op.recuperarDados(usuario);
        
        
        return dadosUser;
    }
    public int alterarEmail(Usuario usuario,String novoEmail) throws SQLException,ClassNotFoundException{
        int status = 0;
        
        OpCRUD op = new OpCRUD();
        status = op.alterarEmail(usuario, novoEmail);
        
        return status;
    }
    
    public ArrayList<Usuario> recuperarDadosALL() throws SQLException,ClassNotFoundException{
        OpCRUD op = new OpCRUD();
        ArrayList<Usuario> dadosUser = op.recuperarDadosALL();
        
        
        return dadosUser;
    }
}
