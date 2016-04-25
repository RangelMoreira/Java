package br.com.bossini.modelo;

public class Meta {
	String nomeMeta;
	String dataIniMeta;
	String dataFimMeta;
	double valorMeta;
	String debCredMeta;
	
	
	public Meta(String nomeMeta, String dtIniMeta, String dtFimMeta, double vlMeta, String dcMeta){
		this.nomeMeta = nomeMeta;
		this.dataIniMeta = dtIniMeta;
		this.dataFimMeta = dtFimMeta;
		this.valorMeta = vlMeta;
		this.debCredMeta = dcMeta;
	}
	
	public String getNomeMeta() {
		return nomeMeta;
	}
	public void setNomeMeta(String nomeMeta) {
		this.nomeMeta = nomeMeta;
	}
	public String getDataIniMeta() {
		return dataIniMeta;
	}
	public void setDataIniMeta(String dataIniMeta) {
		this.dataIniMeta = dataIniMeta;
	}
	public String getDataFimMeta() {
		return dataFimMeta;
	}
	public void setDataFimMeta(String dataFimMeta) {
		this.dataFimMeta = dataFimMeta;
	}
	public double getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}
	public String getDebCredMeta() {
		return debCredMeta;
	}
	public void setDebCredMeta(String debCredMeta) {
		this.debCredMeta = debCredMeta;
	}
	
	@Override
	public String toString() {
	
		return "\n Nome da meta: " + nomeMeta +
				"\n data de inicio: " + dataIniMeta.substring(0, 10) +
				"\n data de termino: " + dataFimMeta.substring(0, 10) +
				"\n Valor da meta: " + valorMeta + 
				"\n debito ou credito: " + debCredMeta + "\n";					
	}
	
}
