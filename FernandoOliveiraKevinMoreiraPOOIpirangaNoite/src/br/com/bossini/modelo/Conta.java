package br.com.bossini.modelo;

public class Conta {
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	private String nomeConta;
	private String tipoConta;
	private String descricaoConta;
	private String usuario;
	private double saldoSeguranca;
	//data de criaçao e usuario vai ser automatico
	
	public Conta(String nmCon, String tipoCon, String descCon, double saldoSeg, String login){
		nomeConta = nmCon;
		tipoConta = tipoCon;
		descricaoConta = descCon;
		this.usuario = login;
		saldoSeguranca = saldoSeg;		
	}
	
	public String getNomeConta() {
		return nomeConta;
	}
	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}	
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	public String getDescricaoConta() {
		return descricaoConta;
	}
	public void setDescricaoConta(String descricaoConta) {
		this.descricaoConta = descricaoConta;
	}
	public double getSaldoSeguranca() {
		return saldoSeguranca;
	}
	public void setSaldoSeguranca(double saldoSeguranca) {
		this.saldoSeguranca = saldoSeguranca;
	}
	
	@Override
	public String toString() {
	
		return "\n Nome da conta: " + nomeConta +
			"\n tipo de conta: " + tipoConta +
			"\n descrição da conta: " + descricaoConta +
			"\n Usuário: " + usuario + 
			"\n saldo de segurança: " + saldoSeguranca;
				
	}
	
}
