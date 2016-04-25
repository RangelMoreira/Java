package br.com.bossini.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.bossini.modelo.Movimentacao;

public class MovimentacaoDAO {
	public List<Movimentacao> listarMovimentacao(int numConta)throws Exception{
		
		List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
		String sql = "SELECT * FROM MOVIMENTACAO where deb_cred_movto = 'C' and NUM_CONTA = " + numConta;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			String descr_movto = rs.getString("DESCR_MOVTO");
			String dataHora = rs.getString("DT_HORA_MOVTO");
			double valorMovto = rs.getDouble("VL_MOVTO");
			String sitMovto = rs.getString("SITUACAO_MOVTO");
			String parcMovto = rs.getString("PARCELA_MOVTO");
			int qtdeParc = rs.getInt("QTDE_PARCELAS");
			int saldoAntes = rs.getInt("SALDO_ANTES");
			int saldoAtual = rs.getInt("SALDO_ATUAL");
			
			Movimentacao mov = new Movimentacao(descr_movto,dataHora,valorMovto,sitMovto,parcMovto,qtdeParc,saldoAntes,saldoAtual);
			movimentacoes.add(mov);
		}
		conn.close();
		ps.close();
		rs.close();
		
		return movimentacoes;
	}
	
	public List<Movimentacao> listarMovimentacaoEmpresa(int numConta, String empresa)throws Exception{
		
		List<Movimentacao> movimentacoesEmp = new ArrayList<Movimentacao>();
		String sql = "select * from movimentacao where num_conta = " + numConta 
		+ " and cod_gerador = (select cod_gerador from gerador where nome_gerador = '" + empresa + "')";
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			String descr_movto = rs.getString("DESCR_MOVTO");
			String dataHora = rs.getString("DT_HORA_MOVTO");
			double valorMovto = rs.getDouble("VL_MOVTO");
			String sitMovto = rs.getString("SITUACAO_MOVTO");
			String parcMovto = rs.getString("PARCELA_MOVTO");
			int qtdeParc = rs.getInt("QTDE_PARCELAS");
			int saldoAntes = rs.getInt("SALDO_ANTES");
			int saldoAtual = rs.getInt("SALDO_ATUAL");
			
			Movimentacao mov = new Movimentacao(descr_movto,dataHora,valorMovto,sitMovto,parcMovto,qtdeParc,saldoAntes,saldoAtual);
			movimentacoesEmp.add(mov);
		
		}
		
		conn.close();
		ps.close();
		rs.close();
		
		return movimentacoesEmp;
	}
}
