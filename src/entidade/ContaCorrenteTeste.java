package entidade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTeste {

	private ContaCorrenteTeste cc;
	
	@Test
	public void get_titular(){
	    ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
	    assertEquals("Joao da Silva",cc.get_titular());			
	}
	//teste acento
	@Test (expected = IllegalArgumentException.class)
	public void comAcento(){
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		assertEquals("Joao da Silva", cc.get_titular());
	}
	@Test 
	public void get_numero(){
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		assertEquals (12345, cc.get_numero());
	}
	@Test
	public void saldo() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		assertEquals(0, cc.saldo(), 0);
	}

	@Test
	public void Credito() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.credito(100);
		assertEquals(100, cc.saldo(), 0);
	}

	@Test
	public void Debito() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.debito(100);
		assertEquals(-100, cc.saldo(), 0);
	}

	@Test
	public void Extrato() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.credito(100);
		cc.debito(100);
		ArrayList<Float> op = cc.extrato();
		assertEquals(2, op.size());
		assertEquals(100, op.get(0), 0);
		assertEquals(-100, op.get(1), 0);
	}
	
	@Test
	public void testSaldoPequenosFloats() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.credito(0.1f);
		cc.credito(0.2f);
		assertEquals(0.3f, cc.saldo(), 0.0f);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");	
		cc.credito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.debito(-10);		
	}
	
	@Test
	public void transferencia(){
		ContaCorrente ccOrigem = new ContaCorrente(12345,"Joao da Silva");
		ContaCorrente ccDestino = new ContaCorrente(12345,"Joao da Silva");
		//transfere
			ccOrigem.transferencia(100,ccDestino);
	   //testa
			assertEquals(-100,ccOrigem.saldo(),0);
			assertEquals(100,ccDestino.saldo(),0);		
	}
	public ContaCorrenteTeste getCc() {
		return cc;
	}
	public void setCc(ContaCorrenteTeste cc) {
		this.cc = cc;
	}


}