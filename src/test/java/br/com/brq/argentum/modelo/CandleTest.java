package br.com.brq.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;


public class CandleTest {

	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorDoQueMinimo() {
		
		CandleBuilder builder = new CandleBuilder();
		
		Candle candle = builder.comAbertura(10.0)
				.comFechamento(30.0)
				.comMaximo(2.0)
				.comMinimo(10.0)
				.comVolume(200.0)
				.comData(LocalDateTime.now())
				.geraCandle();
	}
	
	@Test
	public void ehAltaSeFechamentoForIgualAbertura() {
		
		CandleBuilder builder = new CandleBuilder();
		
		Candle candle = builder.comAbertura(30.0)
				.comFechamento(30.0)
				.comMaximo(11.0)
				.comMinimo(10.0)
				.comVolume(200.0)
				.comData(LocalDateTime.now())
				.geraCandle();
		
		Assert.assertTrue(candle.isAlta());
	}
}
