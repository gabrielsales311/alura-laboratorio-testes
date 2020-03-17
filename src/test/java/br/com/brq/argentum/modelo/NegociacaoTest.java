package br.com.brq.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;


public class NegociacaoTest {

	// O teste passa porque você espera que o resultado seja uma exceção
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		LocalDateTime data = LocalDateTime.now();
		new Negociacao(-20.0, 2, data);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10.0, 2, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeNegativa() {
		new Negociacao(10.0, -2, LocalDateTime.now());
	}
	
	@Test
	public void horariosDiferentesEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2016,  04, 04, 12, 00);
		LocalDateTime agora = LocalDateTime.of(2016,  04, 04, 13, 00);
		
		Negociacao negociacao = new Negociacao(100.0, 20, hoje);
		
		Assert.assertTrue(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void mesesDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2016,  04, 04, 12, 00);
		LocalDateTime agora = LocalDateTime.of(2016,  03, 04, 13, 00);
		
		Negociacao negociacao = new Negociacao(100.0, 20, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
	}
	
	@Test
	public void anosDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.of(2016,  04, 04, 12, 00);
		LocalDateTime agora = LocalDateTime.of(2017,  04, 04, 13, 00);
		
		Negociacao negociacao = new Negociacao(100.0, 20, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
	}


}
