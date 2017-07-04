package entidade;

import java.util.ArrayList;


public class ContaCorrente {
	private String _titular;
	private int _numero;
	private float _saldo = 0;
	private ArrayList<Float> _operacoes = new ArrayList<Float>();
	
	public ContaCorrente(int i, String string) {
		this._numero = get_numero();
		this._titular = get_titular();
	}
	

	public float saldo(){
		return _saldo;
	}
	
	public float credito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo += valor;
		_operacoes.add(valor);
		return _saldo;
	}
	
	public float debito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo -= valor;
		_operacoes.add(-valor);
		return _saldo;
	}
	
	public ArrayList<Float> extrato() {
		return _operacoes;
	}

	public String get_titular1() {
		return _titular;
	}

	public void set_titular(String _titular) {
		this._titular = _titular;
	}

	public int get_numero(){
		return _numero;
	}

	public void set_numero(int _numero) {
		this._numero = _numero;
	}

	public float transferencia (float valor , ContaCorrente ccDestino) {
		this.debito(valor);
		ccDestino.credito(valor);
		return saldo();
		
	}
	//teste acento
	public String get_titular(){
	if (_titular == "Joao da Silva") throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
	if (_titular == "José da Silva") throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
	return _titular;
	}
}