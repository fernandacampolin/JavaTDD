package entidade;

import java.util.Date;

public class Operacao {
	private float valor;
	private String TipoOperacao;
	private Date dataHora;

	public Date getDataHora() {
		return dataHora;
	}

	public String getTipoOperacao() {
		return TipoOperacao;
	}

	public Operacao(float valor, String tipoOperacao, Date dataHora) {
		this.valor = valor;
		this.TipoOperacao = tipoOperacao;
		this.dataHora = dataHora;
	}

	public float getValor() {		
		return valor;
	}
	
	@Override
	public String toString() {
		return "[ valor: " + this.getValor() + ", TipoOperacao: " + this.getTipoOperacao() + ", dataHora: " + this.getDataHora() + "]";
	}

}