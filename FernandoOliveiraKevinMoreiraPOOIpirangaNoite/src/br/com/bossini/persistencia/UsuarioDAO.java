package br.com.bossini.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.bossini.modelo.Usuario;


public class UsuarioDAO {
	
	public void inserir(Usuario u)throws Exception{	
		
		Connection conn = 
				ConnectionFactory.getConnection();
		String sql = "INSERT INTO Usuario VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getLogin());
		ps.setString(2, u.getSenha());
		ps.setString(3, u.getNome());
		ps.execute();
		ps.close();
		conn.close();
	
	}
	
	public boolean verificarSeUsuarioExiste(Usuario us) throws Exception{
		
		String sql = "Select * FROM USUARIO WHERE NOME_USUARIO = '" + us.getNome() + 
				"' AND LOGIN = '" + us.getLogin() + "' AND SENHA = '" + us.getSenha() +"'";
		
		//String sql = "Select count(*) FROM USUARIO WHERE NOME_USUARIO = '" + us.getNome() + 
		//		"' AND LOGIN = '" + us.getLogin() + "' AND SENHA = '" + us.getSenha() +"'";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){        
	        if (rs.getString("LOGIN").isEmpty()){
	        	conn.close();
	            ps.close();
	        	rs.close();
	        	
	        	return false;
	        }
	        else{
	        	conn.close();
	            ps.close();
	        	rs.close();
	        	 
	        	return true;
	        }               
        }
        return false;
	}   

	
}