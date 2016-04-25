package br.com.bossini.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import br.com.bossini.modelo.Conta;

public class ContaDAO {

public boolean verificarSeContaExiste(int numConta)throws Exception{
		
		String sql = "Select * FROM CONTA WHERE NUM_CONTA = "  + numConta; 
				
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){        
	        if (rs.getString("NUM_CONTA").equals("")){
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
	
	public Conta getConta(int numConta)throws Exception{
		
		Conta c;
		String sql = "Select * FROM CONTA WHERE NUM_CONTA = "  + numConta;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()){     
        	String nomeConta = rs.getString("NOME_CONTA");
        	String tipoCon = rs.getString("TIPO_CONTA");
        	String descCon = rs.getString("DESCR_CONTA");
        	double saldoSeg = rs.getDouble("SALDO_SEGURANCA");
        	String login = rs.getString("Login");
        	c = new Conta(nomeConta, tipoCon, descCon, saldoSeg, login);
        	return c;
        }
        else
        	return null;
		
	}
	
	public void Inserir(Conta co)throws Exception{
		Connection conn = ConnectionFactory.getConnection();
	
		int indice=registro();
		String sql = "INSERT INTO CONTA VALUES ("+indice+",?,current_timestamp,?,?,?,?)";		

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, co.getNomeConta());
		ps.setString(2, co.getTipoConta());
		ps.setString(3, co.getDescricaoConta());
		ps.setString(4, co.getUsuario());
		ps.setDouble(5, co.getSaldoSeguranca());
		
		ps.execute();
		ps.close();
		conn.close();
	
	}


	public int conta()throws Exception{
		String sql = "SELECT COUNT(num_conta)as c  from conta";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int aux=rs.getInt("c");
		return aux;
	}

	
	public int registro()throws Exception{
//	if (conta()>0){
			String sql = "SELECT MAX(num_conta) c  from conta";
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			int aux=rs.getInt("c");
			conn.close();
		    ps.close();
			rs.close();
		return aux+1;
//	}
//	else
//		return 1;
	
	}
	}




