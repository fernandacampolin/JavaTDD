package entidade;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTeste {
	@Test
	public void getTitular(){
	    ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
	    assertEquals("João da Silva",cc.getTitular());			
	}
	
	//teste acento
	@Test (expected = IllegalArgumentException.class)
	public void testcomAcento(){
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		assertEquals("Joao da Silva", cc.getTitular());
	}
	@Test 
	public void get_numero(){
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		assertEquals (12345, cc.getNumero());
	}
	@Test
	public void saldo() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		assertEquals(0, cc.saldo(), 0);
	}

	@Test
	public void credito() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		cc.credito(100);
		assertEquals(100, cc.saldo(), 0);
	}

	@Test
	public void debito() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		cc.debito(100);
		assertEquals(-100, cc.saldo(), 0);
	}
	
	@Test
	public void testConstrutor(){
		ContaCorrente cc = new ContaCorrente(1234,"João da Silva");
		assertNotNull(cc);
	}
	
	private void assertNotNull(ContaCorrente cc) {		
	}

	@Test
	public void extrato() {
		ContaCorrente cc = new ContaCorrente(12345,"Joao da Silva");
		cc.credito(100);
		cc.debito(100);
		ArrayList<Operacao> listaoperacao = cc.extrato();
		assertEquals(2, listaoperacao.size());
		assertEquals(100,listaoperacao.get(0).getValor(),0);
		assertEquals("CREDITO", listaoperacao.get(0).getTipoOperacao());
		assertEquals(100, listaoperacao.get(1).getValor(), 0);
		assertEquals("DEBITO", listaoperacao.get(1).getTipoOperacao());
	}
	
	@Test
	public void testSaldoPequenosFloats() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		cc.credito(0.1f);
		cc.credito(0.2f);
		assertEquals(0.3f, cc.saldo(), 0.0f);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");	
		cc.credito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		cc.debito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTrasnferenciaoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		ContaCorrente ccDestino = new ContaCorrente(83742,"José da Silva");
		cc.transferencia(-10,ccDestino);		
	}
	
	@Test
	public void transferencia(){
		ContaCorrente cc = new ContaCorrente(12345,"João da Silva");
		ContaCorrente ccDestino = new ContaCorrente(83742,"José da Silva");
		//transfere
			cc.transferencia(10,ccDestino);
	   //testa
			assertEquals(-10,cc.saldo(),0);
			assertEquals(10,ccDestino.saldo(),0);		
	}

}