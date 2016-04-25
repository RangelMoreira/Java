package br.com.bossini.modelo;

public class MetaConta {
	
	Conta co ;
	Meta me;
	
	public MetaConta(Conta co, Meta me){
		this.co = co;
		this.me = me;
	}
	
	
	public Conta getCo() {
		return co;
	}


	public void setCo(Conta co) {
		this.co = co;
	}


	public Meta getMe() {
		return me;
	}


	public void setMe(Meta me) {
		this.me = me;
	}


	@Override
	public String toString() {
		return co + " " + me;
	}

}
