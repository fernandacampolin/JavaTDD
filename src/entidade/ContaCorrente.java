package entidade;

import java.util.Date;
import java.util.ArrayList;


public class ContaCorrente {
	private int _numero;
	private String _titular;
	private float _saldo = 0;
	private ArrayList<Operacao> _operacao = new ArrayList<Operacao>();
	
	public ContaCorrente(int numero, String titular) {
		_numero = numero;
		_titular = titular;
	}
	//teste acento
	public String getTitular(){
	if (_titular == "Joao da Silva") throw new IllegalArgumentException("Nome Inválido ");
	if (_titular == "Jose da Silva") throw new IllegalArgumentException("Nome Inválido");
	return _titular;
	}  
	
	public float saldo(){
		return _saldo;
	}
	
	public float credito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo += valor;
		Operacao op = new Operacao(valor, "Credito", new Date());
		_operacao.add(op);
		return _saldo;
	}
	
	public float debito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo -= valor;
		Operacao op = new Operacao(valor, "DEBITO", new Date());
		_operacao.add(op);
		return _saldo;
	}
	
	public ArrayList<Operacao> extrato() {
		return _operacao;
	}
	public int getNumero(){
		return _numero;
	}
	public float transferencia (float valor , ContaCorrente ccDestino) {
		this.debito(valor);
		ccDestino.credito(valor);
		return saldo();
		
	}

}