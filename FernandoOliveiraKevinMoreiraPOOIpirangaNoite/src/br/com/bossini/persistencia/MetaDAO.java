package br.com.bossini.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import br.com.bossini.modelo.Conta;
import br.com.bossini.modelo.Meta;
import br.com.bossini.modelo.MetaConta;

public class MetaDAO {
	
	Conta c;
	Meta m;
	
	public  List <MetaConta> obterMetasVigentes(String login) throws Exception{
		 List <MetaConta> metas = new ArrayList<MetaConta>();
		 ContaDAO cdao = new ContaDAO();
		 Conta co;
		 String sql= "CALL SP_GET_METAS_CONTA(?,?) ";
		 Connection conn = ConnectionFactory.getConnection();		 
		 CallableStatement cs = conn.prepareCall(sql);
		 cs.setString(1, login);
		 cs.registerOutParameter(2,OracleTypes.CURSOR);
		 cs.execute();
		 //ResultSet rs = (ResultSet)cs.getObject("tabela");
		 ResultSet rs = (ResultSet)cs.getObject(2);
		 while (rs.next()){
			 int numConta = rs.getInt("num_conta");
			 if (cdao.verificarSeContaExiste(numConta)){
				 co = cdao.getConta(numConta);				 
			 }
			 else{				 
				System.out.println("nenhuma conta cadastrada para o login " + login);
				break;
			 }
			 
			 String nomeMeta = rs.getString("Nome_Meta");
			 String dtIniMeta = rs.getString("dt_ini_meta");
			 String dtFimMeta = rs.getString("dt_term_meta");
			 double valorMeta = rs.getDouble("vl_meta");
			 String debCredMeta = rs.getString("deb_cred_meta");
			 
			 Meta m = new Meta(nomeMeta,dtIniMeta,dtFimMeta,valorMeta,debCredMeta);
			 MetaConta mc = new MetaConta(co, m);
			 
			 int iMc = metas.indexOf(mc);
			 if (iMc >=0)
				 mc = metas.get(iMc);
			 else
				 metas.add(mc);
			 
		 }
		 
		 cs.close();
		 conn.close();
		 return metas;
		 
	}
	
	@Override
	public String toString() {
		
		return c.toString() + " | " + m.toString(); 
	}

}
