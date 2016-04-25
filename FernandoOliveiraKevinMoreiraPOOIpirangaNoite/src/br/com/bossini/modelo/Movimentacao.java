package br.com.bossini.modelo;

public class Movimentacao {

	private String descr_movto;
	private String dataHora;
	private double valorMovto;
	private String sitMovto ;
	private String parcMovto;
	private int qtdeParc ;
	private int saldoAntes ;
	private int saldoAtual;
	
	
	public Movimentacao(String descr_movto,String dataHora,double valorMovto,String sitMovto,String parcMovto, int qtdeParc,int saldoAntes, int saldoAtual){
		this.descr_movto = descr_movto;
		this.dataHora = dataHora;
		this.valorMovto = valorMovto;
		this.sitMovto = sitMovto;
		this.parcMovto = parcMovto;
		this.qtdeParc = qtdeParc;
		this.saldoAntes = saldoAntes;
		this.saldoAtual = saldoAtual;		
	}
	
	
	public String getDescr_movto() {
		return descr_movto;
	}
	public void setDescr_movto(String descr_movto) {
		this.descr_movto = descr_movto;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public double getValor_movto() {
		return valorMovto;
	}
	public void setValor_movto(double valor_movto) {
		this.valorMovto = valor_movto;
	}
	public String getSitMovto() {
		return sitMovto;
	}
	public void setSitMovto(String sitMovto) {
		this.sitMovto = sitMovto;
	}
	public String getParcMovto() {
		return parcMovto;
	}
	public void setParcMovto(String parcMovto) {
		this.parcMovto = parcMovto;
	}
	public int getQtdeParc() {
		return qtdeParc;
	}
	public void setQtdeParc(int qtdeParc) {
		this.qtdeParc = qtdeParc;
	}
	public int getSaldoAntes() {
		return saldoAntes;
	}
	public void setSaldoAntes(int saldoAntes) {
		this.saldoAntes = saldoAntes;
	}
	public int getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(int saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	@Override
	public String toString() {
		return "\n descricao: " + descr_movto + 
			   "\n Data e hora: " + dataHora + 
			   "\n Valor da movimentação: " + valorMovto +
			   "\n Situação da movimentação: " + sitMovto + 
			   "\n Parcelas da movimentação: " + parcMovto + 
			   "\n Quantidade de parcelas: " + qtdeParc + 
			   "\n Saldo anterior: " + saldoAntes + 
			   "\n Saldo atual: " + saldoAtual + "\n\n";
	}
}